package skeleton.model;

import static skeleton.Logger.*;

/**
 * Meztelen.
 * Az alap WaterResistanceStrategy.
 */
public class Naked implements WaterResistanceStrategy {

    /**
     * A játékos mozgásképtelen lesz és elkezd veszíteni a testhőjéből.
     *
     * @param p A játékos
     */
    public void Chill(Player p) {
        logMethodCall(this, p);
        p.setEnergy(0);
        p.Chill();
        logMethodReturn();
    }
}
