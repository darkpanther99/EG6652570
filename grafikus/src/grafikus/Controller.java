package grafikus;

import grafikus.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Vezérlő komponens.
 * A játék fő ablaka, tartalmazza a View-t és vezérlő UI elemeket.
 */
public class Controller extends JFrame implements TileClickListener, PlayerSelectListener {
    /**
     * A TileClick esemény jelentését meghatározó állapotgép állapota.
     */
    enum Mode {
        /**
         * Nem történik semmi.
         */
        //NONE,

        /**
         * A kiválasztott játékos lép.
         */
        STEP,
        /**
         * A kiválasztott játékos kiment.
         */
        RESCUE,
        /**
         * A kiválasztott sarkkutató felderít.
         */
        EXAMINE,
    }

    public Mode mode = Mode.STEP;

    /**
     * A modell.
     */
    public final Game game;

    /**
     * A jelenleg kiválasztott játékos. Az összes Controller parancs rá vonatkozik.
     */
    public Player selectedPlayer;

    /**
     * Rajzoláshoz szükséges segédváltozó.
     */
    public int foundParts = 0;


    // A tartalmazott UI elemek:
    private final PlayerListMenu playerListMenu;
    private final InventoryMenu inventoryMenu;
    private final ActionsMenu actionsMenu;
    private final View view;

    /**
     * @param game Négyzetrács szerkezetű modell
     * @param rows A négyzetrács sorai.
     * @param cols A négyzetrács oszlopai
     */
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

    // TODO: ezt használni
    public Player getNextPlayer() {
        List<Player> players = game.getPlayers();
        int index = players.indexOf(selectedPlayer);
        if (++index >= players.size()) {
            index = 0;
        }
        return players.get(index);
    }

    /**
     * Mindent frissít.
     */
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

    /**
     * Kör vége.
     * Lép a jegesmedve, vihar jön, az energia újratöltődik, a vízben lévők fáznak.
     */
    public void nextTurn() {
        Random random = new Random();
        for (PolarBear bear : game.getBears()) {
            List<Integer> moveDirs = new ArrayList<>();
            Collections.addAll(moveDirs, 0, 1, 2, 3);

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
        for (TileView tv : view.getTileViews()) {
                tv.isStorm = false;
        }
        if (stormChance > 50) {
            for (Tile t : game.getTiles()) {  // TODO(Mark): Itt azt a tömböt kéne megadni, ahol vihar van, azt nem csinálom meg, mert ahhoz gondolkodni kéne. Boti?
                if (t.getWeightLimit() > 0 || (t.getWeightLimit() == 0 && t.getSnow() > 0))
                    t.setSnow((t.getSnow() < 5) ? t.getSnow() + 1 : t.getSnow());
                t.chillStorm();
                for (TileView tv : view.getTileViews()) {
                    if (tv.getTile() == t) {
                        tv.isStorm = true;
                    }
                }
            }
        }

        game.turn();
    }


    @Override
    public void select(Player p) {
        selectedPlayer = p;
        update();
    }

    /**
     * TileClick eseménykezelő.
     *
     * @param t erre a cellára klikkeltek.
     */
    @Override
    public void tileClick(Tile t) {
        //if (mode == Mode.NONE) return;

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

        mode = Mode.STEP;

        update();
    }
}
