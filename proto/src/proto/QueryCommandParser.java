package proto;

import java.util.List;

/**
 * QueryCommand-ot tokenekből elkészítő osztály.
 */
public class QueryCommandParser implements CommandParser {

    /**
     * Visszaadja a parancs kulcsszavát
     * @return A kulcsszó
     */
    @Override
    public String getKeyword() {
        return "query";
    }

    /**
     * Tokenekből létrehoz egy QueryCommand-ot
     * @param tokens: A tokenek
     * @return A QueryCommand
     */
    @Override
    public Command parse(List<String> tokens) {
        return new QueryCommand();
    }
}
