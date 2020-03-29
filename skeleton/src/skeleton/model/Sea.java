package skeleton.model;

import static skeleton.Logger.*;

/**
 * Tenger osztály, ami a kör elején minden játékost hűt, aki benne tartózkodik.
 * @author Botondar
 *
 */
public class Sea implements ChillWaterStrategy {
	/**
	 * Hűti a mezőt, amihez a tenger tartozik, vagyis hűti az összes a mezőn tartózkodó játékost.
	 * @param t A mező, amihez a tenger tartozik.
	 */
    public void Chill(Tile t) {
        logMethodCall(this, t);
        for (Player p : t.getOccupants()) {
            p.ResistWater();
        }
        logMethodReturn();
    }
}
