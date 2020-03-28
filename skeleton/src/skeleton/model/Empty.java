package skeleton.model;

import static skeleton.Logger.*;

/**
 * Üres. Azt reprezentálja, hogy nincsen item a slotban.
 */
public class Empty implements Item {

    /**
     * A játékos nem kap semmit.
     *
     * @param p A játékos.
     */
    public void GiveTo(Player p) {
        logMethodCall(this, p);
        logMethodReturn();
    }
}
