package grafikus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.*;
import java.util.List;
import java.util.Map;

import grafikus.model.*;

public class Controller extends JFrame implements TileClickListener {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    private PlayerListMenu playerListMenu = null;
    private InventoryMenu inventoryMenu = null;
    private ActionsMenu actionsMenu = null;

    private View view = null;

    public Game game = null;
    public Player selectedPlayer = null;

    public Controller(Game game) {
        this.game = game;
        selectedPlayer = game.getPlayer(0);
        selectedPlayer.addToInventory(new BreakingShovel(1)); // TEMP

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Jegmezo");

        setLayout(new BorderLayout(0, 0));

        view = new View(this);
        this.add(view, BorderLayout.CENTER);

        playerListMenu = new PlayerListMenu(this);
        this.add(playerListMenu, BorderLayout.EAST);


        inventoryMenu = new InventoryMenu(this);
        this.add(inventoryMenu, BorderLayout.WEST);

        actionsMenu = new ActionsMenu(this);
        this.add(actionsMenu, BorderLayout.SOUTH);

        pack();
        setVisible(true);

        this.update();
    }

    public Player getNextPlayer() {
        List<Player> players = game.getPlayers();
        int index = players.indexOf(selectedPlayer);
        if(++index >= players.size()) {
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

        for(Player player : players) {
            if(player.getEnergy() > 0) {
                return;
            }
        }

        nextTurn();
    }

    public void nextTurn() {
        game.turn();
    }

    @Override
    public void tileClick(Tile t) {
        if(selectedPlayer == null) {
            return;
        }

        Map<Integer, Tile> neighbors = selectedPlayer.getCurrentTile().getNeighbors();
        for(Map.Entry<Integer, Tile> entry : neighbors.entrySet()) {
            if(entry.getValue() == t) {
                selectedPlayer.step(entry.getKey());
                break;
            }
        }

        update();
    }
}
