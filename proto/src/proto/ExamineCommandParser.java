package proto;

import java.util.List;

public class ExamineCommandParser implements CommandParser {

    private String keyword = "examine";

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        if(tokens.size() < 2 || !tokens.get(0).contentEquals(keyword)) {
            throw new RuntimeException();
        }

        String direction = tokens.get(1);
        return new ExamineCommand(Integer.parseInt(direction));
    }
}
