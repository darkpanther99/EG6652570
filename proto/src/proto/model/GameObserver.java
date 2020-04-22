package proto.model;
/**
 * 
 * Figyeli a játék eseményeket.
 *
 */
public interface GameObserver {
	
	/**
	 * Vereség esemény
	 */
    void gameOver();
    
    /**
     * Gyõzelem esemény
     */
    void victory();
    
    /**
     * Sarkkutató felderít esemény.
     * @param t A Tile típúsú mezõ objektum, amit a sarkkutató feldírtett.
     */
    void explore(Tile t);
}
