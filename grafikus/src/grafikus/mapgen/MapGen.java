package grafikus.mapgen;

import grafikus.model.*;

import javax.swing.*;
import java.util.List;
import java.util.Random;

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
        for (int i = 0; i <= cols*rows-1; i++) game.createTile(new Random().nextInt(5+1),new Random().nextInt(game.getPlayers().size() + 1 + 1) - 1);

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                if (y - 1 >= 0)      tiles.get(index(x,y)).addNeighbor(tiles.get(index(x,y-1)),0); // NORTH
                if (x + 1 <= cols-1) tiles.get(index(x,y)).addNeighbor(tiles.get(index(x+1,y)),1); // EAST
                if (y + 1 <= rows-1) tiles.get(index(x,y)).addNeighbor(tiles.get(index(x,y+1)),2); // SOUTH
                if (x - 1 >= 0)      tiles.get(index(x,y)).addNeighbor(tiles.get(index(x-1,y)),3); // WEST
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
        tiles.get(index(1,1)).setWeightLimit(999);
        tiles.get(index(1,1)).setSnow(3);
        tiles.get(index(2,1)).setWeightLimit(999);
        tiles.get(index(2,1)).setSnow(3);
        tiles.get(index(2,1)).setItem(new Shovel());
        tiles.get(index(1,2)).setWeightLimit(0);
        tiles.get(index(1,2)).setSnow(0);

        for (PolarBear b : game.getBears()) {
            int x = new Random().nextInt(cols);
            int y = new Random().nextInt(rows);
            b.placeOn(tiles.get(index(x,y)));
        }

        for (Player p : game.getPlayers()) {
            p.placeOn(tiles.get(index(1,1)));
        }
    }

    private MapGen() {

    }
}
