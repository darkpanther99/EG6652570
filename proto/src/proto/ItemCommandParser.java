package proto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemCommandParser implements CommandParser {
    private String keyword = "item";
    private static final Set<String> acceptedTypes = new HashSet<>();

    static {
        acceptedTypes.add("empty");
        acceptedTypes.add("food");
        acceptedTypes.add("part");
        acceptedTypes.add("scubagear");
        acceptedTypes.add("rope");
        acceptedTypes.add("tentkit");
        acceptedTypes.add("shovel");
    }

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if (tokens.size() < 2 || !tokens.get(0).contentEquals(keyword)) {
            throw new ProtoException("Rossz bemenet");
        }

        String type = tokens.get(1);
        if (!acceptedTypes.contains(type)) {
            throw new ProtoException("Rossz item tipus");
        }

        try {
            int count = 1;
            int durability = -1;
            ItemCommand command = null;
            if(tokens.size() > 2) {
                for (int i = 2; i < tokens.size(); i++) {
                    String token = tokens.get(i);
                    if(token.contentEquals("durability")) {
                        i++;
                        token = tokens.get(i);
                        durability = Integer.parseInt(token);
                    } else {
                        count = Integer.parseInt(token);
                    }
                }
            }

            command = new ItemCommand(type, count, durability);
            return command;
        } catch(NumberFormatException e) {
            throw new ProtoException(e.getMessage(), e.getCause());
        } catch(IndexOutOfBoundsException e) {
            throw new ProtoException(e.getMessage(), e.getCause());
        }

    }
}
