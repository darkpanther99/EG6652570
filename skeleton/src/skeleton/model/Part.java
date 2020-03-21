package skeleton.model;

import skeleton.Logger;

public class Part implements Item {
    public void GiveTo(Player p) {
        Logger.logMethodCall(this, p);
        p.GetPartStore().Gain(1);
        p.RemoveFromInventory(this);
		Logger.logMethodReturn();
    }
}
