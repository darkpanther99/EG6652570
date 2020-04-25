package proto;

import java.util.List;

public class EquipCommandParser implements CommandParser {
    private String keyword = "equip";

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) {
        if(tokens.size() < 2 || !tokens.get(0).contentEquals(keyword)) {
            throw new RuntimeException();
        }

        String index = tokens.get(1);
        if(index.contentEquals("all")) {
            return new EquipCommand();
        } else {
            return new EquipCommand(Integer.parseInt(index));
        }
    }
}
