package proto.model;

/**
 * 
 *Ilyen a j�gt�bla, ha nincs rajta iglu. A j�gt�bl�n nincs v�delem a vihar elol.
 *
 */
public class BareIce extends Shelter {
	
	/**
	 * A param�terk�nt kapott t Tilen �ll� j�t�kosok testh�je cs�kken.
	 * @param t A Tile t�pus� j�gt�bla objektum, amin a mened�k(jelen esetben a semmi) tal�lhat�, �s a rajta l�v� entit�sok f�znak rajta.
	 *
	 */
	public void chillStorm(Tile t) {
        for (Entity e:t.getOccupants()) {
        	e.chill();
        }
    }

	/**
	 *  A param�terk�nt kapott t Tilen �ll� minden j�t�kost megt�mad a medve.
	 * @param t A Tile t�pus� j�gt�bla objektum, amin a mened�k(jelen esetben a semmi) tal�lhat�, �s a rajta l�v� entit�sok medvet�mad�s �ldozatai lettek.
	 *
	 */
    public void bearAttack(Tile t) {
    	for (Entity e:t.getOccupants()) {
        	e.bearAttack();
        }
    }
    /**
    * Nem csin�l semmit, mert a nem l�tez� mened�k nem t�rik el.
    * @param t A Tile t�pus� j�gt�bla objektum, amin a mened�k(jelen esetben a semmi) tal�lhat�.
    */
    public void ruin(Tile t) {
        return;
    }
}
