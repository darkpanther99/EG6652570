package proto;

import java.util.List;

public class AssembleCommandParser implements CommandParser {

    @Override
    public String getKeyword() {
        return "assemble";
    }

    @Override
    public Command parse(List<String> tokens) {
        return new AssembleCommand();
    }
}
