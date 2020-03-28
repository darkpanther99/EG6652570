package skeleton.model;

import static skeleton.Logger.*;

public class Part implements Item {
    public void GiveTo(Player p) {
        logMethodCall(this, p);
        p.getPartStore().Gain(1);
        p.RemoveFromInventory(this);
        logMethodReturn();
    }
}
