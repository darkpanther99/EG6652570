package proto;

import java.util.List;

/**
 * EatCommand-ot tokenekből létrehozó osztály.
 */
public class EatCommandParser implements CommandParser {
    /**
     * A parancs kulcsszava.
     * @return A kulcsszó
     */
    @Override
    public String getKeyword() {
        return "eat";
    }
    /**
     * Tokenekből létrehozza a parancsot.
     * @param tokens: A tokenek
     * @return A parancs
     */
    @Override
    public Command parse(List<String> tokens) {
        return new EatCommand();

    }
}
