package skeleton.model;

import static skeleton.Logger.*;

/**
 * A rakétalkatrészek tárolóját modellező osztály.
 * @author Botondar
 *
 */
public class PartStore {
    private int count = 0;

    /**
     * Hozzáad n db alkatrészt az eddigi alkatrészekhez.
     * @param n Az érkező alkatrészek száma.
     */
    public void Gain(int n) {
        logMethodCall(this);
        this.setCount(this.getCount() + n);
        logMethodReturn();
    }

    /**
     * Hozzáad egy másik alkatrész tárolót ehhez a tárolóhoz.
     * Ennek a tárolónak az alkatrész száma a kettő összege, míg a másiké 0 lesz.
     * @param ps A másik alkatrész tároló.
     */
    public void Gain(PartStore ps) {
        logMethodCall(this, ps);
        if (ps != this) {
            this.Gain(ps.getCount());
            ps.setCount(0);
        }
        logMethodReturn();
    }

    /**
     * Beállítja, hogy hány alkatrész van a tárolóban
     * @param count Az új alkatrész szám.
     */
    public void setCount(int count) {
        logMethodCall(this);
        this.count = count;
        logMethodReturn();
    }

    /**
     * Visszaadja, hogy hány alkatrész van a tárolóban.
     * @return Az alkatrészek száma.
     */
    public int getCount() {
        logMethodCall(this);
        logMethodReturn(count);
        return count;
    }
}
