package skeleton.model;



public class BareIce implements ChillStormStrategy {
	
	/**
	 * Az implement�lt ChillStormStrategy interface Chill met�dus�t fel�ldefini�lja.
	 * Sima j�gen �ll� j�t�kosok f�z�s�ra alkalmazott met�dus.
	 * A t Tilen l�v� �sszes j�t�kost f�zatja, megh�vja a Chill met�dusukat.
	 * 
	 * @param t A Tile t�pus� j�gt�bla objektum, amin a j�t�kosok f�zni fognak.
	 */
	public void Chill(Tile t) {
		for (Player p : t.GetOccupants()) {
			p.Chill();
		}
	}
}
