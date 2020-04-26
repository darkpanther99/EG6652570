package proto.model;

/**
 * Sátor építését lehetové teszi.
 */
public class TentKit implements Item {
    /**
     * A játékos így kap sátor alapanyagot
     *
     * @param p
     */
    public void giveTo(Player p) {
        p.getBuildStrategy().gain();
    }
}
