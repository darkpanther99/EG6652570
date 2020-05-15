package grafikus;

import grafikus.model.Tile;

/**
 * Cella klikkelés esemény.
 * Akkor keletkezik, ha a View-ben cellára kattintanak.
 */
public interface TileClickListener {
    /**
     * @param t A kattintott cella.
     */
    void tileClick(Tile t);
}
