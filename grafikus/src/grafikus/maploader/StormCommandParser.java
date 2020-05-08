package grafikus.maploader;

import java.util.List;

/**
 * Argumentum listából StormCommand-ot létrehozó osztály
 */
public class StormCommandParser implements CommandParser {

    /**
     * Visszaadja a parancshoz tartozó kulcsszót.
     * @return A kulcsszó.
     */
    @Override
    public String getKeyword() {
        return "storm";
    }

    /**
     * Létrehozza a StormCommand-ot az argumentum listából.
     * @param tokens Argumentum lista.
     * @return StormCommand
     * @throws MapLoaderException
     */
    @Override
    public Command parse(List<String> tokens) throws MapLoaderException {
        if (tokens.size() < 1 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new MapLoaderException("Rossz bemenet");
        }

        return new StormCommand();
    }
}
