package grafikus.mapgen;

import grafikus.model.Game;
import grafikus.model.Player;
import grafikus.model.Tile;

import javax.swing.*;
import java.util.List;

public class MapGen {
    private static Game game;
    private static int rows = 7;
    private static int cols = 10;
    private static int index(int col, int row) {
        return cols * row + col;
    }

    /*
        NORTH = 0
        EAST = 1
        SOUTH = 2
        WEST = 3
    */

    public static void generateMap(Game game) {
        List<Tile> tiles = game.getTiles();
        for (int i = 0; i <= cols*rows-1; i++) tiles.add(new Tile());

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                if (y - 1 >= 0)      tiles.get(index(x,y)).addNeighbor(tiles.get(index(x,y-1)),0); // NORTH
                if (x + 1 <= cols-1) tiles.get(index(x,y)).addNeighbor(tiles.get(index(x+1,y)),1); // EAST
                if (y + 1 <= rows-1) tiles.get(index(x,y)).addNeighbor(tiles.get(index(x,y+1)),2); // SOUTH
                if (x - 1 >= 0)      tiles.get(index(x,y)).addNeighbor(tiles.get(index(x-1,y)),3); // WEST
                tiles.get(index(x,y)).setWeightLimit(999);
                tiles.get(index(x,y)).setSnow(3);
            }
        }
        for (int x = 0; x < cols; x++) {
            tiles.get(index(x,0)).setSnow(0);
            tiles.get(index(x,0)).setWeightLimit(0);
            tiles.get(index(x,rows-1)).setSnow(0);
            tiles.get(index(x,rows-1)).setWeightLimit(0);
        }
        for (int y = 0; y < rows; y++) {
            tiles.get(index(0,y)).setSnow(0);
            tiles.get(index(0,y)).setWeightLimit(0);
            tiles.get(index(cols-1,y)).setSnow(0);
            tiles.get(index(cols-1,y)).setWeightLimit(0);
        }

        for (Player p : game.getPlayers()) {
            p.placeOn(tiles.get(index(1,1)));
        }
    }

    private MapGen() {

    }
}
