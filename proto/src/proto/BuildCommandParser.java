package proto;

import java.util.List;

public class BuildCommandParser implements CommandParser {
    private String keyword;

    public BuildCommandParser() {
        keyword = "build";
    }
    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        return new BuildCommand();
    }
}
