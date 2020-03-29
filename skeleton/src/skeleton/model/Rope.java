package skeleton.model;

import static skeleton.Logger.*;

/**
 * Kötél tárgy.
 */
public class Rope implements Item {

    /**
     * A játékos megkapja a kötelet. (beállítódik a megfelelő RescueStrategy)
     *
     * @param p A játékos.
     */
    public void GiveTo(Player p) {
        logMethodCall(this, p);
        RescueStrategy rs = new RopeRescue();
        logConstructorCall(rs, "rescueStrategy");
        p.setRescueStrategy(rs);
        logMethodReturn();
    }
}
