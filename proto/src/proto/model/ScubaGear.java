package proto.model;

public class ScubaGear implements Item {
    /**
     * A játékos búvárruhát kap. Az bekerül az inventoryjába és a megfelelo stratégiája ˝
     * helyére is a búvárruha által adott képesség
     * @param p
     */
    public void giveTo(Player p) {
        ScubaWearing sw = new ScubaWearing();
        p.setWaterResistanceStrategy(sw);
    }
}
