package skeleton.model;

import static skeleton.Logger.*;

public class Sea implements ChillWaterStrategy {
    public void Chill(Tile t) {
        logMethodCall(this, t);
        for (Player p : t.getOccupants()) {
            p.ResistWater();
        }
        logMethodReturn();
    }
}
