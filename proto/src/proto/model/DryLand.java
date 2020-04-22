package proto.model;

/**
 * 
 * A sz�razf�ld nem h�ti a j�t�kosokat. A j�t�kos nincsen v�zben. Ezt reprezent�l� oszt�ly.
 *
 */
public class DryLand implements ChillWaterStrategy {
	/**
	 * A strat�gia megval�s�t�sa miatt k�r be egy t Tile param�tert, a rajta lev� j�t�kossal viszont nem csin�l semmit, mert az nincs v�zben, nem cs�kkenti testhoj�t.
	 * @param A strat�gia megval�s�t�sa miatt k�r be egy t Tile param�tert, a rajta lev� j�t�kossal viszont nem csin�l semmit.
	 */
    public void chill(Tile t) {
        return;
    }
}
