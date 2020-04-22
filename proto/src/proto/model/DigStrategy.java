package proto.model;
/**
 * 
 * A j�t�kos �gy �s. �s�skor a cell�n a h�mennyis�g cs�kken.
 *
 */
public interface DigStrategy {
	/**
	 * A strat�gi�t megval�s�t� elem dolga implement�lni mi t�rt�nik �s�skor. Visszaadja, hogy az �s�s f�raszt�-e.
	 * @param t A Tile t�pus� objektum, ahol a j�t�kos �sni szeretne.
	 * @return Igaz vagy hamis att�l f�gg�en, hogy az �s�s f�raszt�-e.
	 */
   boolean dig(Tile t);
}
