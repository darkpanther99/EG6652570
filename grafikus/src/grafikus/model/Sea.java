package grafikus.model;

public class Sea implements ChillWaterStrategy {
    /**
     * Minden rajta álló testhoje csökken a WaterResistanceStrategy szerint
     *
     * @param t
     */
    public void chill(Tile t) {
        for (Entity e : t.getOccupants()) {
            e.resistWater();
        }
    }
}
