package grafikus.maploader;

import java.util.List;

/**
 * Argumentum listából TurnCommand-ot létrehozó osztály.
 */
public class TurnCommandParser implements CommandParser {

    /**
     * Visszaadja a parancshoz tartozó kulcsszót.
     * @return
     */
    @Override
    public String getKeyword() {
        return "turn";
    }

    /**
     * Létrehozza a parancsot az argumentum listából.
     * @param tokens Az argumentumok
     * @return TurnCommand
     * @throws MapLoaderException Hibás bemenet esetén kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws MapLoaderException {
        if (tokens.size() < 1 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new MapLoaderException("Rossz bemenet");
        }

        return new TurnCommand();
    }
}
