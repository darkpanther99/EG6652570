package proto.model;

public interface RescueStrategy {
    /**
     * A stratégiát megvalósító elem dolga implementálni mi történik.
     *
     * @param water
     * @param land
     */
    void rescue(Tile water, Tile land);
}
