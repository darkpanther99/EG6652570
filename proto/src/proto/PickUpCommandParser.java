package proto;

import java.util.List;

public class PickUpCommandParser implements CommandParser {
    private String keyword = "pickup";

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        if(tokens.size() < 1 || !tokens.get(0).contentEquals(keyword)) {
            throw new RuntimeException();
        }

        return new PickUpCommand();
    }
}
