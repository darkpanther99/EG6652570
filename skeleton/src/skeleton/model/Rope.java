package skeleton.model;

import static skeleton.Logger.*;

public class Rope implements Item {
    public void GiveTo(Player p) {
        logMethodCall(this, p);
        p.setRescueStrategy(new RopeRescue());
        logMethodReturn();
    }
}
