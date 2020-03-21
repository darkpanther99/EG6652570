package skeleton.model;

import skeleton.Logger;

public class Naked implements WaterResistanceStrategy {
    public void Chill(Player p) {
        Logger.logMethodCall(this, p);
        p.SetEnergy(0);
        p.Chill();
        Logger.logMethodReturn();
    }
}
