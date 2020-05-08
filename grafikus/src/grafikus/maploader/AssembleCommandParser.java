package grafikus.maploader;

import java.util.List;

/**
 * AssembleCommand-ot tokenekből elkészítő osztály.
 */
public class AssembleCommandParser implements CommandParser {

    /**
     * Visszaadja a parancs kulcsszavát.
     * @return A kulcsszó
     */
    @Override
    public String getKeyword() {
        return "assemble";
    }

    /**
     * Tokenekből elkészít egy AssembleCommand-ot.
     * @param tokens: A tokenek
     * @return Az elkészült parancs
     */
    @Override
    public Command parse(List<String> tokens) {
        return new AssembleCommand();
    }
}
