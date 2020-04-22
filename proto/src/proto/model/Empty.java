package proto.model;

/**
 * 
 * Nincs j�gbe fagyott t�rgy. Ez az �res eszk�z t�pus, nem k�pes semmi extra tulajdons�got biztos�tani a tulajdonosnak.
 *
 */
public class Empty implements Item {
	
	/**
	 * A param�terk�nt kapott j�t�kost nem ruh�zza fel extra tulajdons�ggal, mivel �pp nincs itt j�gbe fagyott t�rgy.
	 * @param A j�t�kos, aki nem kap semmi extra tulajdons�got.
	 */
    public void giveTo(Player p) {
        return;
    }
}
