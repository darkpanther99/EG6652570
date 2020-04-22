package proto.model;

/**
 * A játékos így képes sátrat építeni.
 */
public class BuildStrategy {
    /**
     * Az építhető sátrak száma.
     */
    private int count = 0;

    /**
     * Épít egy sátrat a játékos a paraméterként kapott mezőre. Az építhető sátrak száma eggyel csökken.
     *
     * @param t A Tile típusú mező, ahova építeni akarja a játékos a sátrat.
     */
    public void build(Tile t) {
        if (count > 0) {
            count--;
            Tent te = new Tent();
            t.setShelter(te);
        }
    }

    /**
     * Kap egy sátrat, eggyel nõ az építhető átrak száma.
     */
    public void gain() {
        count++;
    }
}
