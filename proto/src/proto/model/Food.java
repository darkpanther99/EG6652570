package proto.model;
/**
 * Élelem, amit a játékos meg tud enni, hogy növelje a testhojét. Élelem a pályán lesz található. 
 * 
 *
 */
public class Food implements Item {
	
	/**
	 * A paraméterként kapott játékos kap egy élelmet, az bekerül az élelemtárolójába
	 * @param p A játékos, akinek növelni kell az élelem mennyiségét.
	 */
    public void giveTo(Player p) {
        p.getFoodStore().gain();
        p.removeFromInventory(this);
    }
}
