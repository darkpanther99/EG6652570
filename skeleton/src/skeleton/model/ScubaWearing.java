package skeleton.model;

import static skeleton.Logger.*;

public class ScubaWearing implements WaterResistanceStrategy {
    public void Chill(Player p) {
        logMethodCall(this, p);
        logMethodReturn();
    }
}
