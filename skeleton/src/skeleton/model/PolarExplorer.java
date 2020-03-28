package skeleton.model;

import static skeleton.Logger.*;

public class PolarExplorer extends Player {
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
