package proto;

import java.util.List;

public class QueryCommandParser implements CommandParser {
    private String keyword;
    public QueryCommandParser() {
        keyword = "query";
    }
    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        return new QueryCommand();
    }
}
