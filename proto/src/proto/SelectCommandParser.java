package proto;

import java.util.List;

public class SelectCommandParser implements CommandParser {
    private String keyword = "select";

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        if(tokens.size() < 2 || !tokens.get(0).contentEquals(keyword)) {
            throw new RuntimeException();
        }

        String type = tokens.get(1);
        if(type.contentEquals("polarbear")) {
            return new SelectCommand(type, 0);
        }

        int index = Integer.parseInt(tokens.get(2));

        return new SelectCommand(type, index);
    }
}
