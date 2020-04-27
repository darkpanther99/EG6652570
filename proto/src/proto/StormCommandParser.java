package proto;

import java.util.List;

/**
 * Argumentum listából StormCommand-ot létrehozó osztály
 */
public class StormCommandParser implements CommandParser {

    /**
     * Visszaadja a parancshoz tartozó kulcsszót.
     * @return A kulcsszó.
     */
    @Override
    public String getKeyword() {
        return "storm";
    }

    /**
     * Létrehozza a StormCommand-ot az argumentum listából.
     * @param tokens Argumentum lista.
     * @return StormCommand
     * @throws ProtoException
     */
    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if (tokens.size() < 1 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new ProtoException("Rossz bemenet");
        }

        return new StormCommand();
    }
}
