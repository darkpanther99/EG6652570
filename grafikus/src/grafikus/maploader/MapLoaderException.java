package grafikus.maploader;

/**
 * Akkor keletkezik, ha a MapLoader illegális parancsot kap.
 */
public class MapLoaderException extends Exception {
    public MapLoaderException() {
        super();
    }

    public MapLoaderException(String message) {
        super(message);
    }

    public MapLoaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
