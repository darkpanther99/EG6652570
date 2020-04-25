package proto;

import java.util.List;

public class DigCommandParser implements CommandParser {
    private String keyword;
    public DigCommandParser() {
        keyword = "dig";
    }
    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        return new DigCommand();
    }
}
