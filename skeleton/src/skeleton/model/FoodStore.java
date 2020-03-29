package skeleton.model;

import static skeleton.Logger.*;

/**
 * Ételesdoboz.
 * Minden játékosnak van.
 */
public class FoodStore {
    /**
     * A tartalmazott étel egységek száma.
     */
    private int count = 0;

    /**
     * A játékos elfogyaszt egy egység élelmet.
     *
     * @param p A játékos.
     */
    public void Feed(Player p) {
        logMethodCall(this, p);
        if (hasAny()) {
            DecrementCount();
            p.IncrementBodyTemp();
        }
        logMethodReturn();
    }

    private boolean hasAny() {
        //return count > 0;
        return prompt("Van étel az ételesdobozban?");
    }

    public void DecrementCount() {
        logMethodCall(this);
        count--;
        logMethodReturn();
    }

    public void Gain() {
        logMethodCall(this);
        count++;
        logMethodReturn();
    }
}
