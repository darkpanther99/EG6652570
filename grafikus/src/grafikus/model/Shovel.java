package grafikus.model;

/**
 * Jégbe fagyott ásó. Ezzel lehet több havat eltakarítani a celláról.
 */
public class Shovel implements Item {
    private ShovelDig instance;

    /**
     * A játékos ásót kap, ami bekerül az inventoryjába és a megfelelo stratégiájához is ˝
     * bekerül az ásó által adott képesség
     *
     * @param p
     */
    public void giveTo(Player p) {
        if (instance == null)
            instance = new ShovelDig();
        p.setDigStrategy(instance);
    }

    public ShovelDig getInstance() {
        return instance;
    }
}
