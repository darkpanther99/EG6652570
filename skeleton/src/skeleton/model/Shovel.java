package skeleton.model;

import static skeleton.Logger.*;

/**
 * Egy ásót reprezentáló osztály.
 * @author Botondar
 *
 */
public class Shovel implements Item {
	
	/**
	 * A játékos "kezébe adja" az ásót.
	 * @param p A játékos, akinek adjuk az ásót.
	 */
    public void GiveTo(Player p) {
        logMethodCall(this, p);
        DigStrategy ds = new ShovelDig();
        logConstructorCall(ds, "shovelDig");
        p.setDigStrategy(ds);
        logMethodReturn();
    }
}
