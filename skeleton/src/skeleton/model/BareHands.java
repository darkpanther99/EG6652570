package skeleton.model;

public class BareHands implements DigStrategy {
	
	/**
	 * Az implement�lt DigStrategy interface Dig met�dus�t fel�ldefini�lja.
	 * Cs�kkenteni szertn� a t Tilen l�v� h� mennyis�g�t, annak DecrementSnow met�dus�nak megh�v�s�val.
	 * Puszta k�zzel �s�st reprezent�l� met�dus.
	 * 
	 * 
	 * @param t A Tile t�pus� j�gt�bla objektum, amin a j�t�kos �sni szeretne.
	 * @return 	Visszaadja, hogy a j�t�kso f�rad-e az �s�st�l, mivel puszta k�zzel mindig f�rad, ez�rt mindig true.
	 */
	public boolean Dig(Tile t) {
		t.DecrementSnow();
		return true;
	}
	
}
