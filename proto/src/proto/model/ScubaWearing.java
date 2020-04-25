package proto.model;

public class ScubaWearing implements WaterResistanceStrategy {
    /**
     *  A játékost nem h ˝uti a víz, mivel búvárruhát visel. A metódus csak visszatér,
     * nem csinál semmit.
     * @param p
     */
    public void chill(Player p) {
        return;
    }
}
