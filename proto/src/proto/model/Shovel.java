package proto.model;

/**
 * Jégbe fagyott ásó. Ezzel lehet több havat eltakarítani a celláról.
 */
public class Shovel implements Item {
    private ShovelDig sd;

    /**
     * A játékos ásót kap, ami bekerül az inventoryjába és a megfelelo stratégiájához is ˝
     * bekerül az ásó által adott képesség
     *
     * @param p
     */
    public void giveTo(Player p) {
        sd = new ShovelDig(this);
        p.setDigStrategy(sd);
    }
}
