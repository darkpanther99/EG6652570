package skeleton.model;

import static skeleton.Logger.*;

/**
 * Jégbe fagyott alkatrész tárgy.
 */
public class Part implements Item {

    /**
     * A játékos kap egy alkatrészt az alkatrész tárolójába.
     *
     * @param p A játékos.
     */
    public void GiveTo(Player p) {
        logMethodCall(this, p);
        p.getPartStore().Gain(1);
        p.RemoveFromInventory(this);
        logMethodReturn();
    }
}
