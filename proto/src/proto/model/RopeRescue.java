package proto.model;

import java.util.List;

public class RopeRescue implements RescueStrategy {
    Rope source;
    public RopeRescue(Item s) {
        source = (Rope)s;
    }
    /**
     * A vízben lévok közül egyvalaki rákerül a kihúzó játékos ˝
     * cellájára.
     *
     * @param water
     * @param land
     */

    public void rescue(Tile water, Tile land) {
        List<Entity> occ = water.getOccupants();
        if (occ.size() > 0) {
            Entity e = occ.stream().findFirst().orElseThrow();
            e.placeOn(land);
            water.stepOff(e);
        }
    }

    public Rope getSource() {
        return source;
    }
}
