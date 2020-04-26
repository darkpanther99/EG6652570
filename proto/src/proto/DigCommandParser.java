package proto;

import java.util.List;

public class DigCommandParser implements CommandParser {
    @Override
    public String getKeyword() {
        return "dig";
    }

    @Override
    public Command parse(List<String> tokens) {
        return new DigCommand();
    }
}
