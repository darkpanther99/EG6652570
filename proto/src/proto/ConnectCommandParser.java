package proto;

import java.util.ArrayList;
import java.util.List;
/**
 * ConnectCommand-ot tokenekből létrehozó osztály.
 */
public class ConnectCommandParser implements CommandParser {

    /**
     * A parancs kulcsszava.
     * @return A kulcsszó
     */
    @Override
    public String getKeyword() {
        return "connect";
    }

    /**
     * Tokenekből létrehozza a parancsot.
     * @param tokens: A tokenek
     * @return A parancs
     */
    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        List<Integer> tmp = new ArrayList<>();
        if (tokens.size() < 2) throw new ProtoException("Invalid connect command.");
        for (var i : tokens.subList(1, tokens.size())) {
            tmp.add(Integer.parseInt(i));
        }
        return new ConnectCommand(tmp);
    }
}
