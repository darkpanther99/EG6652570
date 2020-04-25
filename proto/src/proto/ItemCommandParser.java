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
    public Command parse(List<String> tokens) {
        if (tokens.size() < 2 || !tokens.get(0).contentEquals(keyword)) {
            throw new RuntimeException();
        }

        String type = tokens.get(1);
        if (!acceptedTypes.contains(type)) {
            throw new RuntimeException();
        }

        ItemCommand command = new ItemCommand(type);
        if (type.contentEquals("shovel")) {
            if (tokens.get(3).contentEquals("durability")) {
                command.durability = Integer.parseInt(tokens.get(4));
            } else {
                command.count = Integer.parseInt(tokens.get(3));
                if (tokens.size() > 3 && tokens.get(4).contentEquals("durability")) {
                    command.durability = Integer.parseInt(tokens.get(5));
                }
            }
        } else {
            command.count = Integer.parseInt(tokens.get(3));
        }

        return command;
    }
}
