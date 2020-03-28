package skeleton.model;

import static skeleton.Logger.*;

public class Shovel implements Item {
    public void GiveTo(Player p) {
        logMethodCall(this, p);
        DigStrategy ds = new ShovelDig();
        logConstructorCall(ds, "shovelDig");
        p.setDigStrategy(ds);
        logMethodReturn();
    }
}
