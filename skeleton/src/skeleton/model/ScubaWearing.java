package skeleton.model;

import static skeleton.Logger.*;

/**
 * Búvárruhás.
 * Az ilyen WaterResistanceStrategy-vel rendelkező játékos nem veszít a testhőjéből, ha vízbe esik, valamint a mozgási képességét sem veszíti el.
 */
public class ScubaWearing implements WaterResistanceStrategy {

    /**
     * A játékos nem veszít a testhőjéből.
     *
     * @param p A játékos
     */
    public void Chill(Player p) {
        logMethodCall(this, p);
        logMethodReturn();
    }
}
