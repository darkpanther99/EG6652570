package proto.model;


/**
 * 
 *  A j�t�kos �gy �s, ha nincs �s�ja, ezt a fajta �s�st reprezent�l� oszt�ly.
 *
 */
public class BareHands implements DigStrategy {
	/**
     * Az implement�lt DigStrategy interface Dig met�dus�t fel�ldefini�lja.
     * Cs�kkenteni szeretn� a t Tile-en l�v� h� mennyis�g�t, annak decrementSnow met�dus�nak megh�v�s�val.
     * Puszta k�zzel �s�st reprezent�l� met�dus.
     *
     * @param t A Tile t�pus� j�gt�bla objektum, amin a j�t�kos �sni szeretne.
     * @return Visszaadja, hogy a j�t�kos f�rad-e az �s�st�l, mivel puszta k�zzel mindig f�rad, ez�rt mindig true.
     */
    public boolean dig(Tile t) {
    	t.decrementSnow();
        return true;
    }
}
