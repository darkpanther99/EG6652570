package grafikus.maploader;

import grafikus.model.Tile;

/**
 * Mezőt létrehozó parancs
 */
public class TileCommand implements Command {
    /**
     * A mezőn lévő hó réteg száma
     */
    private final int snow;
    /**
     * A mező teherbírása
     */
    private final int weightLimit;

    /**
     * Konstruktor
     * @param snow Hóréteg szám.
     * @param weightLimit A teherbírás.
     */
    public TileCommand(int snow, int weightLimit) {
        this.snow = snow;
        this.weightLimit = weightLimit;
    }

    /**
     * Lefuttatja a parancsot.
     * Létrehozza a mezőt a megadott paraméterekkel, és kiválasztja azt.
     * @param state
     */
    @Override
    public void execute(MapLoader state) {
        Tile t = state.game.createTile(snow, weightLimit);
        state.selectTile(t);
    }

    /**
     * Visszaadja a parancsot szöveges formában.
     * @return
     */
    @Override
    public String toString() {
        return "tile " + snow + " " + ((weightLimit < 999) ? weightLimit : "*");
    }
}