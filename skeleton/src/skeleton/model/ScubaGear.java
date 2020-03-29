package skeleton.model;

import static skeleton.Logger.*;

/**
 * Búvárfelszerelés tárgy.
 */
public class ScubaGear implements Item {

    /**
     * A játékos megkapja a búvárfelszerelést. (beállítódik a megfelelő WaterResistanceStrategy)
     *
     * @param p A játékos.
     */
    public void GiveTo(Player p) {
        logMethodCall(this, p);
        ScubaWearing sw = new ScubaWearing();
        logConstructorCall(sw, "scubaWearing");
        p.setWaterResistanceStrategy(sw);
        logMethodReturn();
    }
}
