package proto;

import java.util.List;

/**
 * Argumentum listából PickUpCommand-ot létrehozó osztály
 */
public class PickUpCommandParser implements CommandParser {
    /**
     * Visszaadja a parancshoz tartozó kulcssszót.
     * @return A kulcsszó. Mindig "pickup"
     */
    @Override
    public String getKeyword() {
        return "pickup";
    }

    /**
     * Létrehozza a parancsot az argumentum listából
     * @param tokens
     * @return A parancs
     * @throws ProtoException Hibás bemenet eseténkivételt dob
     */
    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if (tokens.size() < 1 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new ProtoException("Rossz bemenet");
        }

        return new PickUpCommand();
    }
}
