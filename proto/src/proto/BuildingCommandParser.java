package proto;

import java.util.List;

public class BuildingCommandParser implements CommandParser {

    @Override
    public String getKeyword() {
        return "building";
    }

    @Override
    public Command parse(List<String> tokens) {
        return new BuildingCommand(tokens.get(1));
    }
}
