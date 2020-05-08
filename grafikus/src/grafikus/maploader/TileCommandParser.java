package grafikus.maploader;

import java.util.List;

/**
 * Argumentum listából TileCommand-ot létrehozó osztály.
 */
public class TileCommandParser implements CommandParser {

    /**
     * Visszaadja a parancshoz tartozó kulcsszót.
     * @return A kulcsszó.
     */
    @Override
    public String getKeyword() {
        return "tile";
    }

    /**
     * Létrehozza a TileCommand-ot a megadott argumentumokból.
     * @param tokens Az argumentumok.
     * @return TileCommand
     * @throws MapLoaderException Hibás bemenet esetén kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws MapLoaderException {
        if (tokens.size() < 3 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new MapLoaderException("Rossz bemenet");
        }

        try {
            int snow = Integer.parseInt(tokens.get(1));
            int weightLimit = 999;
            if (!tokens.get(2).contentEquals("*")) {
                weightLimit = Integer.parseInt(tokens.get(2));
            }

            return new TileCommand(snow, weightLimit);
        } catch (NumberFormatException e) {
            throw new MapLoaderException(e.getMessage(), e.getCause());
        }
    }
}
