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
            ItemCommand command = null;
            if (type.contentEquals("shovel")) {
                int count = 1;
                int durability = -1;
                if (tokens.get(2).contentEquals("durability")) {
                    durability = Integer.parseInt(tokens.get(3));
                } else {
                    count = Integer.parseInt(tokens.get(2));
                    if (tokens.size() > 3 && tokens.get(3).contentEquals("durability")) {
                        durability = Integer.parseInt(tokens.get(4));
                    }
                }
                command = new ItemCommand(type, count, durability);
            } else {
                int count = Integer.parseInt(tokens.get(2));
                command = new ItemCommand(type, count);
            }

            return command;
        } catch(NumberFormatException e) {
            throw new ProtoException(e.getMessage(), e.getCause());
        } catch(IndexOutOfBoundsException e) {
            throw new ProtoException(e.getMessage(), e.getCause());
        }

    }
}
