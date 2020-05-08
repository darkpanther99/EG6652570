package grafikus.maploader;

import java.util.List;

/**
 * DigCommand-ot tokenekből létrehozó osztály.
 */
public class DigCommandParser implements CommandParser {
    /**
     * A parancs kulcsszava.
     * @return A kulcsszó
     */
    @Override
    public String getKeyword() {
        return "dig";
    }
    /**
     * Tokenekből létrehozza a parancsot.
     * @param tokens: A tokenek
     * @return A parancs
     */
    @Override
    public Command parse(List<String> tokens) {
        return new DigCommand();
    }
}
