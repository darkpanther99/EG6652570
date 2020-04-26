package proto;

import java.util.List;

public class ExamineCommandParser implements CommandParser {
    /**
     * Visszaadja a parancshoz tartozó kulcsszót
     *
     * @return A kulcsszó. Mindig "examine"
     */
    @Override
    public String getKeyword() {
        return "examine";
    }

    /**
     * @param tokens Formátum: {"examine", "$dir : int"}
     * @return ExamineCommand parancs a megfelelő argumentumokkal
     * @throws ProtoException Hibás bemenet esetén kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if (tokens.size() < 2 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new ProtoException("Rossz bemenet");
        }

        try {
            int direction = Integer.parseInt(tokens.get(1));
            return new ExamineCommand(direction);
        } catch (NumberFormatException e) {
            throw new ProtoException(e.getMessage(), e.getCause());
        }
    }
}
