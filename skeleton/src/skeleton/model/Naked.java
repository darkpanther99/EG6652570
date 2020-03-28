package skeleton.model;

import static skeleton.Logger.*;

public class Naked implements WaterResistanceStrategy {
    public void Chill(Player p) {
        logMethodCall(this, p);
        p.setEnergy(0);
        p.Chill();
        logMethodReturn();
    }
}
