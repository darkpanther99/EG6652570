package skeleton.model;

import skeleton.Logger;

public class Part implements Item {
    public void GiveTo(Player p) {
        Logger.logMethodCall(this, p);
        p.getPartStore().Gain(1);
        p.RemoveFromInventory(this);
		Logger.logMethodReturn();
    }
}
