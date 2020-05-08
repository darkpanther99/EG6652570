package grafikus.maploader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Argumentum listából ItemCommand-ot létrehozó osztály
 */
public class ItemCommandParser implements CommandParser {
    /**
     * Az elfogadott item típusok
     */
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

    /**
     * Visszaadja a parancshoz tartozó kulcsszót
     * @return A kulcsszó, mindig "item"
     */
    @Override
    public String getKeyword() {
        return "item";
    }

    /**
     * Létrehoz egy ItemCommand-ot az argumentumlistából
     * @param tokens az argumentumok. Formátum: { "item", "$type", [count], ["durability", durablity]}
     * @return ItemCommand, a megfelelő argumentumokkal.
     * @throws MapLoaderException Hibás bemenet esetén kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws MapLoaderException {
        if (tokens.size() < 2 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new MapLoaderException("Rossz bemenet");
        }

        String type = tokens.get(1);
        if (!acceptedTypes.contains(type)) {
            throw new MapLoaderException("Rossz item tipus");
        }

        try {
            int count = 1;
            int durability = -1;
            ItemCommand command;
            if (tokens.size() > 2) {
                for (int i = 2; i < tokens.size(); i++) {
                    String token = tokens.get(i);
                    if (token.contentEquals("durability")) {
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
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new MapLoaderException(e.getMessage(), e.getCause());
        }

    }
}
