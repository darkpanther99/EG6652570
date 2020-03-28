package skeleton.model;

import static skeleton.Logger.*;

public class ScubaGear implements Item {
    public void GiveTo(Player p) {
        logMethodCall(this, p);
        p.setWaterResistanceStrategy(new ScubaWearing());
        logMethodReturn();
    }
}
