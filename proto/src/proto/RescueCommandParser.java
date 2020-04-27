package proto;

import java.util.List;

/**
 * Argumentum listából RescueCommand-ot létrehozó osztály.
 */
public class RescueCommandParser implements CommandParser {

    /**
     * Visszaadja a parancshoz tartozó kulcsszót
     * @return A kulcsszó.
     */
    @Override
    public String getKeyword() {
        return "rescue";
    }

    /**
     * Az argumentum listából RescueCommand-ot hoz létre.
     * @param tokens Az argumentumok. Formátum: {"rescue", "$dir"}
     * @return A parancs
     * @throws ProtoException Hibás bemenet esetén kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if (tokens.size() < 2 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new ProtoException("Rossz bemenet");
        }

        try {
            int direction = Integer.parseInt(tokens.get(1));
            return new RescueCommand(direction);
        } catch (NumberFormatException e) {
            throw new ProtoException(e.getMessage(), e.getCause());
        }
    }
}
