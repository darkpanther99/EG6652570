package proto;

import java.util.List;

public class TurnCommandParser implements CommandParser {
    @Override
    public String getKeyword() {
        return "turn";
    }

    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if (tokens.size() < 1 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new ProtoException("Rossz bemenet");
        }

        return new TurnCommand();
    }
}
