package proto;

import java.util.List;

public class AssembleCommandParser implements CommandParser {
    private String keyword;
    public AssembleCommandParser() {
        keyword = "assemble";
    }
    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        return new AssembleCommand();
    }
}
