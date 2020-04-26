package proto;

import java.util.List;

public class TileCommandParser implements CommandParser {
    private String keyword = "tile";

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if(tokens.size() < 3 || !tokens.get(0).contentEquals(keyword)) {
            throw new ProtoException("Rossz bemenet");
        }

        try {
            int snow = Integer.parseInt(tokens.get(1));
            int weightLimit = 999;
            if (!tokens.get(2).contentEquals("*")) {
                weightLimit = Integer.parseInt(tokens.get(2));
            }

            return new TileCommand(snow, weightLimit);
        } catch(NumberFormatException e) {
            throw new ProtoException(e.getMessage(), e.getCause());
        }
    }
}
