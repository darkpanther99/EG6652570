package skeleton.model;

import skeleton.Logger;

public class ScubaGear implements Item {
    public void GiveTo(Player p) {
        Logger.logMethodCall(this, p);
        p.SetWaterResistanceStrategy(new ScubaWearing());
		Logger.logMethodReturn();
    }
}
