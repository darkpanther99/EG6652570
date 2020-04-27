package proto;

import java.util.List;

/**
 * BuildCommand-ot tokenekből elkészítő osztály.
 */
public class BuildCommandParser implements CommandParser {

    /**
     * Visszaadja a parancs kulcsszavát
     * @return A kulcsszó
     */
    @Override
    public String getKeyword() {
        return "build";
    }

    /**
     * Tokenekből létrehozza a parancsot.
     * @param tokens: A tokenek
     * @return A parancs
     */
    @Override
    public Command parse(List<String> tokens) {
        return new BuildCommand();
    }
}
