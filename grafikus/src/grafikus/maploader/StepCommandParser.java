package grafikus.maploader;

import java.util.List;

/**
 * Argumentum listából StepCommand-ot létrehozó osztály
 */
public class StepCommandParser implements CommandParser {

    /**
     * Visszaadja a parancshoz tartozó kulcsszót.
     * @return A kulcsszó.
     */
    @Override
    public String getKeyword() {
        return "step";
    }

    /**
     * Létrehoz egy StepCommand-ot az argumentum listábol.
     * @param tokens Az argumentum lista. Formátum: { "step", "$dir" }
     * @return A parancs
     * @throws MapLoaderException Hibás bemenet esetény kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws MapLoaderException {
        if (tokens.size() < 2 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new MapLoaderException("Rossz bemenet");
        }

        try {
            int direction = Integer.parseInt(tokens.get(1));
            return new StepCommand(direction);
        } catch (NumberFormatException e) {
            throw new MapLoaderException(e.getMessage(), e.getCause());
        }
    }
}
