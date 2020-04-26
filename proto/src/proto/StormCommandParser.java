package proto;

import java.util.List;

public class StormCommandParser implements CommandParser {
    private String keyword = "storm";

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if (tokens.size() < 1 || !tokens.get(0).contentEquals(keyword)) {
            throw new ProtoException("Rossz bemenet");
        }

        return new StormCommand();
    }
}
