package grafikus.model;

/**
 * Nincs jégbe fagyott tárgy. Ez az üres eszköz típus, nem képes semmi extra tulajdonságot biztosítani a tulajdonosnak.
 */
public class Empty implements Item {
    public static final Empty instance = new Empty();

    private Empty() {
    }

    /**
     * A paraméterként kapott játékost nem ruházza fel extra tulajdonsággal, mivel épp nincs itt jégbe fagyott tárgy.
     *
     * @param p A játékos, aki nem kap semmi extra tulajdonságot.
     */
    public void giveTo(Player p) {
        return;
    }
}
