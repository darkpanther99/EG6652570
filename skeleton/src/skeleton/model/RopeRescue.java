package skeleton.model;

import skeleton.Logger;

public class RopeRescue implements RescueStrategy {
    public void Rescue(Tile water, Tile land) {
        Logger.logMethodCall(this, water, land);
        Player p = water.getOccupants().get(0);
        if (p != null) {
            p.PlaceOn(land);
        }
        Logger.logMethodReturn();
    }
}
