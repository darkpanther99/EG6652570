package grafikus.maploader;

/**
 * Parancs interfész
 */
public interface Command {
    /**
     * Végrehajtás az adott állapoton
     * @param state
     * @throws MapLoaderException
     */
    void execute(MapLoader state) throws MapLoaderException;

    /**
     * Így jelenik meg a konzolon.
     * @return
     */
    String toString();
}
