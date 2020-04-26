package proto;

import java.util.List;

/**
 * Argumentum listából EntityCommand-ot generáló osztály.
 */
public class EntityCommandParser implements CommandParser {
    /**
     * A parancshoz tartozó kulcsszó
     */
    private String keyword = "entity";

    /**
     * Visszaadja a parancshoz tartozó kulcsszót.
     * @return A kulcsszó. Mindig "entity".
     */
    @Override
    public String getKeyword() {
        return keyword;
    }

    /**
     * Letrehoz egy EntityCommand-ot a bejovo argumentumokbol
     * @param tokens a parancs argumentumai. { "entity", "$type", ["playerBodyHeat", ["playerEnergy"]]}
     * @return EntityCommand, a bejovo argumentumokkal
     * @throws ProtoException helytelen bemenet esetén kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        if(tokens.size() < 2 || !tokens.get(0).contentEquals(keyword)) {
            throw new ProtoException("Rossz bemenet");
        }

        String type = tokens.get(1);
        if(!type.contentEquals("eskimo") && !type.contentEquals("polarexplorer") && !type.contentEquals("polarbear")) {
            throw new ProtoException("Helytelen entity tipus");
        }

        if(tokens.size() > 2) {
            try {
                int playerBodyHeat = Integer.parseInt(tokens.get(2));
                if (tokens.size() > 3) {
                    int playerEnergy = Integer.parseInt(tokens.get(3));
                    return new EntityCommand(type, playerBodyHeat, playerEnergy);
                }
                return new EntityCommand(type, playerBodyHeat);
            } catch(NumberFormatException e) {
                throw new ProtoException(e.getMessage(), e.getCause());
            }
        }
        return new EntityCommand(type);
    }
}
