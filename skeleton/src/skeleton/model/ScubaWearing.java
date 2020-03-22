package skeleton.model;

import skeleton.Logger;

public class ScubaWearing implements WaterResistanceStrategy {
    public void Chill(Player p) {
        Logger.logMethodCall(this, p);
        Logger.logMethodReturn();
        
        // @NOTE(boti): no effect
    }
}
