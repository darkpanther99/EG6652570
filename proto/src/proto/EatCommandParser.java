package proto;

import java.util.List;

public class EatCommandParser implements CommandParser {
    @Override
    public String getKeyword() {
        return "eat";
    }

    @Override
    public Command parse(List<String> tokens) {
        return new EatCommand();

    }
}
