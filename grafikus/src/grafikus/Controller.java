package grafikus;

import javax.swing.*;
import java.awt.*;
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

        setLayout(new BorderLayout());

        view = new View(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.add(view, BorderLayout.CENTER);

        playerListMenu = new PlayerListMenu(this);
        this.add(playerListMenu, BorderLayout.EAST);

        actionsMenu = new ActionsMenu(this);
        this.add(actionsMenu, BorderLayout.SOUTH);

        inventoryMenu = new InventoryMenu(this);
        this.add(inventoryMenu, BorderLayout.WEST);

        pack();
        setVisible(true);

        //view.addTileClickListener(this);

        this.update();
    }

    public void update() {
        view.update();
        inventoryMenu.update();
        playerListMenu.update();
        actionsMenu.update();
        List<Player> players = game.getPlayers();

        for(Player player : players) {
            // NOTE(boti): ez van a szekvencian, de nem egeszen ertem,
            //             hogy mit akar jelenteni
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
    }
}
