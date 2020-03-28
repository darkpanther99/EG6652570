package skeleton.model;

import skeleton.Logger;

public class Naked implements WaterResistanceStrategy {
    public void Chill(Player p) {
        Logger.logMethodCall(this, p);
        p.setEnergy(0);
        p.Chill();
        Logger.logMethodReturn();
    }
}
