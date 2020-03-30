package skeleton.model;

import static skeleton.Logger.*;

/**
 * Strategy osztály, ami az ásóval való ásást modellezi.
 */
public class ShovelDig implements DigStrategy {

    /**
     * Eltakarít egy réteg havat egy mezőről.
     *
     * @param t A mező, amiről a havat takarítjuk.
     * @return Kell-e csökkenteni a játékos energiáját ásás után.
     */
    public boolean Dig(Tile t) {
        logMethodCall(this, t);
        t.DecrementSnow();
        boolean tiring = prompt("Fárasztó volt az ásás?", true);
        logMethodReturn(tiring);
        return tiring;
    }
}
