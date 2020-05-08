package grafikus.maploader;

import grafikus.model.Tile;

/**
 * Hóvihart indító parancs
 */
public class StormCommand implements Command {
    /**
     * Lefuttatja a hóvihart minden mezőn.
     * @param state
     */
    @Override
    public void execute(MapLoader state) {
        for (Tile t : state.game.getTiles()) {
            t.chillStorm();
        }
    }

    /**
     * A parancs szöveges formában
     * @return
     */
    @Override
    public String toString() {
        return "storm";
    }
}
