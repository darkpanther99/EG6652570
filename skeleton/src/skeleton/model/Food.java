package skeleton.model;

import static skeleton.Logger.*;

/**
 * Étel tárgy.
 */
public class Food implements Item {

    /**
     * A játékos kap egy egység ételt az ételesdobozába.
     *
     * @param p A játékos.
     */
    public void GiveTo(Player p) {
        logMethodCall(this, p);
        p.getFoodStore().Gain();
        p.RemoveFromInventory(this);
        logMethodReturn();
    }
}
