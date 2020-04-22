package proto.model;
/**
 * 
 * A j�t�kos v�dtelen a hideg v�zzel szemben. A j�t�kos ha �gy esik v�zbe �s nem menek�tik ki megfullad.
 *
 */
public class Naked implements WaterResistanceStrategy {
	/**
	 * J�t�kosnak nincsen ereje a v�zben �szni b�v�rruha n�lk�l. Emellett f�zik is.
	 */
    public void chill(Player p) {
        p.setEnergy(0);
        p.chill();
    }
}
