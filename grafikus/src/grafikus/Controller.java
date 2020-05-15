package grafikus;

import grafikus.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Controller extends JFrame implements TileClickListener, PlayerSelectListener {
    public Mode mode = Mode.NONE;
    public Game game;
    public Player selectedPlayer;
    // NOTE(boti): ez csak a rajzolashoz szukseges
    public int foundParts = 0;
    private PlayerListMenu playerListMenu;
    private InventoryMenu inventoryMenu;
    private ActionsMenu actionsMenu;
    private View view;

    public Controller(Game game, int rows, int cols) {
        this.game = game;

        selectedPlayer = game.getPlayer(0);
        selectedPlayer.addToInventory(new Rope()); // TEMP
        selectedPlayer.equip(0); // TEMP

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Jegmezo");

        setLayout(new BorderLayout(0, 0));

        view = new View(this, rows, cols);
        this.add(view, BorderLayout.CENTER);
        game.subscribe(view);

        playerListMenu = new PlayerListMenu(this);
        this.add(playerListMenu, BorderLayout.EAST);


        inventoryMenu = new InventoryMenu(this);
        this.add(inventoryMenu, BorderLayout.WEST);

        actionsMenu = new ActionsMenu(this);
        this.add(actionsMenu, BorderLayout.SOUTH);

        pack();

        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenDim.width - getWidth()) / 2, (screenDim.height - getHeight()) / 2);

        setVisible(true);
        setResizable(false);
        this.update();
    }

    public Player getNextPlayer() {
        List<Player> players = game.getPlayers();
        int index = players.indexOf(selectedPlayer);
        if (++index >= players.size()) {
            index = 0;
        }
        return players.get(index);
    }

    public void update() {
        view.update();
        inventoryMenu.update();
        playerListMenu.update();
        actionsMenu.update();
        this.repaint();

        List<Player> players = game.getPlayers();

        for (Player player : players) {
            if (player.getEnergy() > 0) {
                return;
            }
        }

        nextTurn();
    }

    public void nextTurn() {
        Random random = new Random();
        for (PolarBear bear : game.getBears()) {
            int[] arr = {0, 1, 2, 3};

            ArrayList<Integer> moveDirs = new ArrayList<>();
            moveDirs.add(0);
            moveDirs.add(1);
            moveDirs.add(2);
            moveDirs.add(3);

            while (!moveDirs.isEmpty()) {
                int index = random.nextInt(moveDirs.size());
                int dir = moveDirs.get(index);
                moveDirs.remove(index);
                if (bear.getCurrentTile().getNeighbor(dir).getWeightLimit() > 0) {
                    bear.step(dir);
                    break;
                }
            }
        }

        int stormChance = random.nextInt(100);
        if (stormChance > 50) {
            for (Tile t : game.getTiles()) {
                t.chillStorm();
            }
        }

        game.turn();
    }

    @Override
    public void select(Player p) {
        selectedPlayer = p;
        update();
    }

    @Override
    public void tileClick(Tile t) {
        if (mode == Mode.NONE) return;

        int tileDirection = -1;
        Map<Integer, Tile> neighbors = selectedPlayer.getCurrentTile().getNeighbors();
        for (Map.Entry<Integer, Tile> entry : neighbors.entrySet()) {
            if (entry.getValue() == t) {
                tileDirection = entry.getKey();
                break;
            }
        }

        if (tileDirection == -1) return;

        if (mode == Mode.STEP) {
            selectedPlayer.step(tileDirection);
        } else if (mode == Mode.EXAMINE) {
            if (selectedPlayer instanceof PolarExplorer) {
                PolarExplorer explorer = (PolarExplorer) selectedPlayer;
                explorer.examine(tileDirection);
            }
        } else if (mode == Mode.RESCUE) {
            selectedPlayer.rescueTeammate(tileDirection);
        }

        mode = Mode.NONE;

        update();
    }

    enum Mode {
        NONE,
        STEP,
        RESCUE,
        EXAMINE,
    }
}
