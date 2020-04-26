package proto;

import java.util.List;

public class BuildCommandParser implements CommandParser {

    @Override
    public String getKeyword() {
        return "build";
    }

    @Override
    public Command parse(List<String> tokens) {
        return new BuildCommand();
    }
}
