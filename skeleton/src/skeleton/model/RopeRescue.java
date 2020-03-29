package skeleton.model;

import static skeleton.Logger.*;

import java.util.Collection;

/**
 * Strategy osztály, ami a kötéllel vízből való kimentést modellezi.
 */
public class RopeRescue implements RescueStrategy {

    /**
     * Az implementált RescueStrategy interface Rescue metódusát felüldefiniálja.
     * Ezzel a függvénnyel egy játékos képes kimenteni egy másikat a vízből.
     *
     * @param water Tile típusú jégtábla objektum, ahol a játékos akit kimentünk éppen áll.
     * @param land Tile típusú jégtábla objektum, ahova a játékos kihúzza a társát.
     */
    public void Rescue(Tile water, Tile land) {
        logMethodCall(this, water, land);
        Collection<Player> occ = water.getOccupants();
        if (occ.size() > 0) {

            Player p = occ.stream().findFirst().orElseThrow();

            p.PlaceOn(land);
            // A szekvenciáról hiányzik, a water.Remove(p).
            // De úgy se tudom hívni mert privát, úgyhogy csalok.
            occ.remove(p);
        }
        logMethodReturn();
    }
}
