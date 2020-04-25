package proto;

import java.util.List;

public class RescueCommandParser implements CommandParser {
    private String keyword = "rescue";

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        if(tokens.size() < 2 || !tokens.get(0).contentEquals(keyword)) {
            throw new RuntimeException();
        }

        int direction = Integer.parseInt(tokens.get(1));
        return new RescueCommand(direction);
    }
}
