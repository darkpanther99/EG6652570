package proto;

import java.util.List;

/**
 * BuildingCommand-ot tokenekből létrehozó osztály.
 */
public class BuildingCommandParser implements CommandParser {

    /**
     * A parancs kulcsszava.
     * @return A kulcsszó
     */
    @Override
    public String getKeyword() {
        return "building";
    }

    /**
     * Tokenekből létrehozza a parancsot.
     * @param tokens: A tokenek
     * @return A parancs
     */
    @Override
    public Command parse(List<String> tokens) {
        return new BuildingCommand(tokens.get(1));
    }
}
