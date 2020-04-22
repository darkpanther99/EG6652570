package proto.model;
/**
 * �lelem, amit a j�t�kos meg tud enni, hogy n�velje a testhoj�t. �lelem a p�ly�n lesz tal�lhat�. 
 * 
 *
 */
public class Food implements Item {
	
	/**
	 * A param�terk�nt kapott j�t�kos kap egy �lelmet, az beker�l az �lelemt�rol�j�ba
	 * @param p A j�t�kos, akinek n�velni kell az �lelem mennyis�g�t.
	 */
    public void giveTo(Player p) {
        p.getFoodStore().gain();
        p.removeFromInventory(this);
    }
}
