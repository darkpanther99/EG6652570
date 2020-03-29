package skeleton.model;

import static skeleton.Logger.*;

/**
 * Sarkkutató, játékos osztály.
 */
public class PolarExplorer extends Player {

    /**
     * Különleges képessége az táblák megvizsgálása.
     * Az adott irányba megadott cella teherbírását tudja megvizsgálni
     */
    public int Examine(int direction) {
        logMethodCall(this, direction);
        if (prompt("Van elég energiája?")) {
            DecrementEnergy();
            int w = currentTile.neighborAt(direction).getWeightLimit();
            logMethodReturn(w);
            return w;
        }
        logMethodReturn(-1);
        return -1;
    }
}
