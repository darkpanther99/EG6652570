package grafikus;

import grafikus.model.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MapGen {
    private static Game game;
    private static int rows = 7;
    private static int cols = 10;

    private MapGen() { }

    private static int index(int col, int row) {
        return cols * row + col;
    }

    private static boolean generateTiles() {
        List<Tile> tiles = game.getTiles();
        tiles.clear();
        for (int i = 0; i <= cols * rows - 1; i++) {
            game.createTile(new Random().nextInt(5 + 1), new Random().nextInt(game.getPlayers().size() + 1 + 1) - 1);
            //game.createTile(0,1);
        }

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                if (y - 1 >= 0) tiles.get(index(x, y)).addNeighbor(tiles.get(index(x, y - 1)), 0); // NORTH
                if (x + 1 <= cols - 1) tiles.get(index(x, y)).addNeighbor(tiles.get(index(x + 1, y)), 1); // EAST
                if (y + 1 <= rows - 1) tiles.get(index(x, y)).addNeighbor(tiles.get(index(x, y + 1)), 2); // SOUTH
                if (x - 1 >= 0) tiles.get(index(x, y)).addNeighbor(tiles.get(index(x - 1, y)), 3); // WEST
            }
        }
        for (int x = 0; x < cols; x++) {
            tiles.get(index(x, 0)).setSnow(0);
            tiles.get(index(x, 0)).setWeightLimit(0);
            tiles.get(index(x, rows - 1)).setSnow(0);
            tiles.get(index(x, rows - 1)).setWeightLimit(0);
        }
        for (int y = 0; y < rows; y++) {
            tiles.get(index(0, y)).setSnow(0);
            tiles.get(index(0, y)).setWeightLimit(0);
            tiles.get(index(cols - 1, y)).setSnow(0);
            tiles.get(index(cols - 1, y)).setWeightLimit(0);
        }

        tiles.get(index(1, 1)).setWeightLimit(999);
        tiles.get(index(1,1)).setChillWaterStrategy(new DryLand()); // NOTE(Mark): Volt egy bug, hogy elkezdtek meghalni a fiúk az első mezőn, ez azért volt, mert amikor legenerálódott, akkor még 0 volt a weight limit, ezért Sea ChillWaterStrategy volt.
        return true;
    }

    private static boolean generateItems() {
        List<Tile> tiles = game.getTiles();
        LinkedList<PartView> parts = new LinkedList<>(Arrays.asList(new PartView(ResourceManager.flareGun), new PartView(ResourceManager.flareLight), new PartView(ResourceManager.flare)));
        while (parts.size() > 0) {
            //random.nextInt(max - min + 1) + min
            int x = new Random().nextInt(cols - 2) + 1;
            int y = new Random().nextInt(rows - 2) + 1;
            if (!(tiles.get(index(x, y)).getItem() instanceof Empty) || tiles.get(index(x, y)).getWeightLimit() <= 0) {
            } else {
                tiles.get(index(x, y)).setItem(parts.pop());
            }
        }
        LinkedList<Item> items = new LinkedList<>();
        int numShovels = (int)Math.ceil((rows-2)*(cols-2)/15.0);
        int numBreakingShovels = (int)Math.ceil((rows-2)*(cols-2)/15.0);
        int numRopes = (int)Math.ceil((rows-2)*(cols-2)/15.0);
        int numFood = (int)Math.ceil((rows-2)*(cols-2)/8.0);
        int numScuba = (int)Math.ceil((rows-2)*(cols-2)/15.0);
        int numTentKit = (int)Math.ceil((rows-2)*(cols-2)/15.0);
        for (int i = 0; i < numShovels; i++) items.push(new Shovel());
        for (int i = 0; i < numBreakingShovels; i++) items.push(new BreakingShovel(3));
        for (int i = 0; i < numRopes; i++) items.push(new Rope());
        for (int i = 0; i < numFood; i++) items.push(new Food());
        for (int i = 0; i < numScuba; i++) items.push(new ScubaGear());
        for (int i = 0; i < numTentKit; i++) items.push(new TentKit());

        while (items.size() > 0) {
            //random.nextInt(max - min + 1) + min
            int x = new Random().nextInt(cols - 2) + 1;
            int y = new Random().nextInt(rows - 2) + 1;
            if (!(tiles.get(index(x, y)).getItem() instanceof Empty) || tiles.get(index(x, y)).getWeightLimit() <= 0) {
            } else {
                tiles.get(index(x, y)).setItem(items.pop());
            }
        }
        return true;

    }

    private static boolean placeBears() {
        List<Tile> tiles = game.getTiles();
        int tries = 0;
        for (PolarBear b : game.getBears()) {
            int done = 0;
            boolean badbadbear = false;
            while (done < game.getBears().size() && tries < rows*cols) {
                int x = new Random().nextInt(cols - 2) + 1;
                int y = new Random().nextInt(rows - 2) + 1;
                if (tiles.get(index(x, y)).getWeightLimit() <= 0) {
                    tries++;
                    continue;
                }
                for (Entity e : tiles.get(index(x, y)).getOccupants()) {
                    if (e instanceof Player) {
                        badbadbear = true;
                        tries++;
                        break;
                    }
                }
                if (badbadbear) {
                    tries++;
                    continue;
                }

                if (b.getCurrentTile() != null) {
                    b.getCurrentTile().getOccupants().remove(b);
                }
                b.placeOn(tiles.get(index(x, y)));
                done++;

            }
            if (tries >= rows*cols-1) return false;
        }
        return true;
    }
    private static boolean placePlayers() {
        List<Tile> tiles = game.getTiles();

        for (Player p : game.getPlayers()) {
            if (p.getCurrentTile() != null) {
                p.getCurrentTile().getOccupants().remove(p);
            }
            p.placeOn(tiles.get(index(1, 1)));
        }
        return true;
    }

    public static void generateMap(Game g, int r, int c) {
        rows = r;
        cols = c;
        game = g;
        boolean done = false;
        while (!done) {
            generateTiles();
            generateItems();
            placePlayers();
            while (!placeBears()) {
                if (game.getBears().get(0).getCurrentTile() != null)
                    game.getBears().get(0).getCurrentTile().getOccupants().remove(game.getBears().get(0));
                game.getBears().remove(0);
            }
            done = true;
        }
    }
}
