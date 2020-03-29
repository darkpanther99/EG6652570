package skeleton.model;

import static skeleton.Logger.*;

import java.util.Collection;
import java.util.function.Supplier;

public class RopeRescue implements RescueStrategy {
    public void Rescue(Tile water, Tile land) {
        logMethodCall(this, water, land);
        Collection<Player> occ = water.getOccupants();
        if (occ.size() > 0) {
        	
            Player p = occ.stream().findFirst().orElseThrow(null);
            
            p.PlaceOn(land);
            // A szekvenciáról hiányzik, a water.Remove(p).
            // De úgy se tudom hívni mert privát, úgyhogy csalok.
            occ.remove(p);
        }
        logMethodReturn();
    }
}
