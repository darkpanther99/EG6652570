package proto;

import java.util.List;

public class QueryCommandParser implements CommandParser {

    @Override
    public String getKeyword() {
        return "query";
    }

    @Override
    public Command parse(List<String> tokens) {
        return new QueryCommand();
    }
}
