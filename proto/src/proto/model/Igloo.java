package proto.model;
/**
 * 
 * Ezen a j�gt�bl�n iglu �ll, a j�t�kosok v�dve vannak a vihart�l. Az ilyen t�bl�n nem cs�kken a viharban a rajta �ll�k testh�je. 
 *
 */
public class Igloo extends Shelter {
	/**
	 * A param�terk�nt kapott cell�n �ll� j�t�kosok testhoje nem cs�kken, mivel igluban vannak.
	 */
    public void chillStorm(Tile t) {
        return;
    }

    /**
     * �gy viselkedik a mezo ha valaki igluban van �s megt�madja a medve. Visszat�r, mert a medve az igluban megh�z�d� j�t�kosokat nem b�ntja.
     */
    public void bearAttack(Tile t) {
        return;
    }
    
    /**
     * Visszat�r, nem csin�l semmit, mivel az iglu nem t�rik el soha.
     */
    public void ruin(Tile t) {
    	return;
    }
}
