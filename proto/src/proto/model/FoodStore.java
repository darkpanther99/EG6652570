package proto.model;

/**
 * A játékos ebben a zsebben tárolja az élelmet.
 */
public class FoodStore {

    /**
     * Hány élelem van a játékosnál.
     */
    private int count = 0;

    /**
     * Játékos testhője megnő, az élelem mennyisége csökken, mivel a játékos megeszi azt.
     *
     * @param p
     */
    public void feed(Player p) {
        if (count > 0) {
            count--;
            p.incrementBodyTemp();
        }
    }

    /*Ez a fv lehet nem kell, kikommentezve bent hagyom egyelőre.
     * public void decrementCount() {
        count--;
    }*/

    /**
     * Növeli a benne található elemek számát.
     */
    public void gain() {
        count++;
    }
}
