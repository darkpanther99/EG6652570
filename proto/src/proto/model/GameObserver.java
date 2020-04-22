package proto.model;
/**
 * 
 * Figyeli a j�t�k esem�nyeket.
 *
 */
public interface GameObserver {
	
	/**
	 * Veres�g esem�ny
	 */
    void gameOver();
    
    /**
     * Gy�zelem esem�ny
     */
    void victory();
    
    /**
     * Sarkkutat� felder�t esem�ny.
     * @param t A Tile t�p�s� mez� objektum, amit a sarkkutat� feld�rtett.
     */
    void explore(Tile t);
}
