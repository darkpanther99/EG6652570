package proto;

import java.util.List;

public class EatCommandParser implements CommandParser {
    private String keyword;
    public EatCommandParser() {
        keyword = "eat";
    }
    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        return new EatCommand();

    }
}
