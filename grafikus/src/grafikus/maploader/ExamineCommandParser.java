package grafikus.maploader;

import java.util.List;

/**
 * Argumentum listából ExamineCommand-ot létrehozó osztály
 */
public class ExamineCommandParser implements CommandParser {
    /**
     * Visszaadja a parancshoz tartozó kulcsszót
     *
     * @return A kulcsszó. Mindig "examine"
     */
    @Override
    public String getKeyword() {
        return "examine";
    }

    /**
     * @param tokens Formátum: {"examine", "$dir : int"}
     * @return ExamineCommand parancs a megfelelő argumentumokkal
     * @throws MapLoaderException Hibás bemenet esetén kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws MapLoaderException {
        if (tokens.size() < 2 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new MapLoaderException("Rossz bemenet");
        }

        try {
            int direction = Integer.parseInt(tokens.get(1));
            return new ExamineCommand(direction);
        } catch (NumberFormatException e) {
            throw new MapLoaderException(e.getMessage(), e.getCause());
        }
    }
}
