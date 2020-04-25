package proto;

import java.util.List;

public class BuildingCommandParser implements CommandParser {
    public String keyword;
    public BuildingCommandParser() {
        keyword = "building";
    }
    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        return new BuildingCommand(tokens.get(1));
    }
}
