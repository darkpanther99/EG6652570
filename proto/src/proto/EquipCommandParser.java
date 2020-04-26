package proto;

import java.util.List;

public class EquipCommandParser implements CommandParser {
    private String keyword = "equip";

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if(tokens.size() < 2 || !tokens.get(0).contentEquals(keyword)) {
            throw new ProtoException("Rossz bemenet");
        }

        String index = tokens.get(1);
        if(index.contentEquals("all")) {
            return new EquipCommand();
        } else {
            try {
                return new EquipCommand(Integer.parseInt(index));
            } catch(NumberFormatException e) {
                throw new ProtoException(e.getMessage(), e.getCause());
            }
        }
    }
}
