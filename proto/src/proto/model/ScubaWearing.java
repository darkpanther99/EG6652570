package proto.model;

public class ScubaWearing implements WaterResistanceStrategy {
    ScubaGear source;
    public ScubaWearing(Item s) {
        source = (ScubaGear)s;
    }

    /**
     * A játékost nem h ˝uti a víz, mivel búvárruhát visel. A metódus csak visszatér,
     * nem csinál semmit.
     *
     * @param p
     */
    public void chill(Player p) {
        return;
    }

    public ScubaGear getSource() {
        return source;
    }
}
