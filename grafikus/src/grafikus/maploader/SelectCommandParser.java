package grafikus.maploader;

import java.util.List;

/**
 * Argumentum listából SelectCommandot létrehozó osztály
 */
public class SelectCommandParser implements CommandParser {
    /**
     * Visszaadja a parancshoz tartozó kulcsszót.
     * @return A kulcsszó.
     */
    @Override
    public String getKeyword() {
        return "select";
    }

    /**
     * Létrehozza a SelectCommandot az argumentum listából.
     * @param tokens Az argumentum lista. Formátum: {"select", "$type", "$index"}
     * @return A parancs
     * @throws MapLoaderException hibás bemenet esetén kivételt dob
     */
    @Override
    public Command parse(List<String> tokens) throws MapLoaderException {
        if (tokens.size() < 2 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new MapLoaderException("Rossz bemenet");
        }

        try {
            String type = tokens.get(1);
            if (type.contentEquals("polarbear")) {
                return new SelectCommand(type, 0);
            }

            int index = Integer.parseInt(tokens.get(2));
            return new SelectCommand(type, index);
        } catch (NumberFormatException e) {
            throw new MapLoaderException(e.getMessage(), e.getCause());
        }

    }
}
