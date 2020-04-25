package proto;

import java.util.List;

public class QueryCommandParser implements CommandParser {
    private String keyword;
    public QueryCommandParser() {
        keyword = "querry";
    }
    @Override
    public String getKeyword() {
        throw new RuntimeException();
    }

    @Override
    public Command parse(List<String> tokens) {
        return new QueryCommand();
    }
}
