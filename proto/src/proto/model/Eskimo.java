package proto.model;
/**
 * 
 * J�t�kos fajta. 5 egys�gnyi testh�vel kezd. K�pes iglut �p�teni. A j�t�kos ir�ny�tja. 
 *
 */
public class Eskimo extends Player {
	
	/**
	 * Konstruktor, ami l�trehoz egy j�t�kost, majd be�ll�tja a tesh�j�t �tre, mint az eszkim�knak.
	 */
	public Eskimo() {
		super();
		this.bodyTemp=5;
	}
	
	/**
	 * �p�t egy iglut a mez�re, amin �ll, a BuildStrategyj�t�l f�ggetlen�l. Az iglu megv�d majd a h�vihart�l. Be�ll�tja a mez� mened�k�t Iglura. 
	 */
    public void build() {
        if (energy>0) {
        	energy--;
        	Igloo i=new Igloo();
        	currentTile.setShelter(i);
        }
    }
}
