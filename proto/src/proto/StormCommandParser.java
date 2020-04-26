package proto;

import java.util.List;

public class StormCommandParser implements CommandParser {

    @Override
    public String getKeyword() {
        return "storm";
    }

    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if (tokens.size() < 1 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new ProtoException("Rossz bemenet");
        }

        return new StormCommand();
    }
}
