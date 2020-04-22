package proto.model;
/**
 * 
 * A j�gt�bla �gy h�ti a v�zbe esett j�t�kosokat. V�zben tart�zkod�s eset�n a j�t�kos testh�je cs�kken, a megval�s�tott strat�gia alapj�n.
 *
 */
public interface ChillWaterStrategy {
	/**
	 * A strat�gi�t megval�s�t� elem dolga implement�lni mi t�rt�nik
	 * @param t A Tile t�pus� objektum, amin a j�t�kos f�zni fog.
	 */
    void chill(Tile t);
}
