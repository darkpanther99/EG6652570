package grafikus;

import javax.swing.*;
import java.util.*;
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Jegmezo");

        view = new View(SCREEN_WIDTH, SCREEN_HEIGHT);

        actionsMenu = new ActionsMenu(this);
        this.add(actionsMenu);

        inventoryMenu = new InventoryMenu(this);
        this.add(inventoryMenu);

        this.add(view);
        pack();
        setVisible(true);

        //view.addTileClickListener(this);
    }

    public void update() {
        view.update(view.getGraphics());

        inventoryMenu.update();
        //playerListMenu.update();
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

    //@Override
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
