package grafikus.model;

/**
 * Figyeli a játék eseményeket.
 */
public interface GameObserver {

    /**
     * Vereség esemény
     */
    void gameOver();

    /**
     * Győzelem esemény
     */
    void victory();

    /**
     * Sarkkutató felderít esemény.
     *
     * @param t A Tile típusú mező objektum, amit a sarkkutató felderített.
     */
    void explore(Tile t);
}
