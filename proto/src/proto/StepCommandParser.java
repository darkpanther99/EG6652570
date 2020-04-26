package proto;

import java.util.List;

public class StepCommandParser implements CommandParser {

    @Override
    public String getKeyword() {
        return "step";
    }

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
