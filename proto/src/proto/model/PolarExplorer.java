package proto.model;

public class PolarExplorer extends Player {
    public PolarExplorer(Game g) {
        super(g);
    }
    /**
     * A játékos megnézheti, hogy egy adott irányban lévo Tile-nak mennyi a ˝
     * teherbírása. A Game.Explore metódust hívja
     *
     * @param direction
     */


    public void examine(int direction) {
        if (energy > 0) {
            decrementEnergy();
            Tile t = currentTile.neighborAt(direction);
            game.explore(t);
        }
    }
}
