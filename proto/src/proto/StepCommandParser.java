package proto;

import java.util.List;

/**
 * Argumentum listából StepCommand-ot létrehozó osztály
 */
public class StepCommandParser implements CommandParser {

    /**
     * Visszaadja a parancshoz tartozó kulcsszót.
     * @return A kulcsszó.
     */
    @Override
    public String getKeyword() {
        return "step";
    }

    /**
     * Létrehoz egy StepCommand-ot az argumentum listábol.
     * @param tokens Az argumentum lista. Formátum: { "step", "$dir" }
     * @return A parancs
     * @throws ProtoException Hibás bemenet esetény kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if (tokens.size() < 2 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new ProtoException("Rossz bemenet");
        }

        try {
            int direction = Integer.parseInt(tokens.get(1));
            return new StepCommand(direction);
        } catch (NumberFormatException e) {
            throw new ProtoException(e.getMessage(), e.getCause());
        }
    }
}
