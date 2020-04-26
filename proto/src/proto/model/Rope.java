package proto.model;

public class Rope implements Item {
    /**
     * A játékos kap egy kötelet. Az bekerül az inventoryjába és a megfelelo˝
     * stratégiájához is a kötél által adott képesség
     *
     * @param p
     */
    public void giveTo(Player p) {
        RopeRescue rr = new RopeRescue();
        p.setRescueStrategy(rr);
    }
}
