package proto;

import java.util.List;

/**
 * Argumentum listából TurnCommand-ot létrehozó osztály.
 */
public class TurnCommandParser implements CommandParser {

    /**
     * Visszaadja a parancshoz tartozó kulcsszót.
     * @return
     */
    @Override
    public String getKeyword() {
        return "turn";
    }

    /**
     * Létrehozza a parancsot az argumentum listából.
     * @param tokens Az argumentumok
     * @return TurnCommand
     * @throws ProtoException Hibás bemenet esetén kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if (tokens.size() < 1 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new ProtoException("Rossz bemenet");
        }

        return new TurnCommand();
    }
}
