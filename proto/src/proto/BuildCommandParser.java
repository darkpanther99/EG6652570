package proto;

import java.util.List;

public class BuildCommandParser implements CommandParser {
    @Override
    public String getKeyword() {
        throw new RuntimeException();
    }

    @Override
    public Command parse(List<String> tokens) {
        throw new RuntimeException();
    }
}