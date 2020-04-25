package proto.model;

public class RopeRescue implements RescueStrategy {
    /**
     * A vízben lévok közül egyvalaki rákerül a kihúzó játékos ˝
     * cellájára.
     * @param water
     * @param land
     */
    public void rescue(Tile water, Tile land) {
        Collection<Player> occ = water.getOccupants();
        if (occ.size() > 0) {
            Player p = occ.stream().findFirst().orElseThrow();
            p.PlaceOn(land);
            water.StepOff(p);
        }
    }
}
