package proto;

import java.util.List;

/**
 * Szöveges argumentum listából EquipCommand-ot létrehozó osztály
 */
public class EquipCommandParser implements CommandParser {
    /**
     * A parancshoz tartozó kulcsszó
     */
    private String keyword = "equip";

    /**
     * Visszaadja a parancshoz tartozó kulcsszót
     * @return A kulcsszó. Mindig "equip"
     */
    @Override
    public String getKeyword() {
        return keyword;
    }

    /**
     * EquipCommandot hoz létre az argumentumokból
     * @param tokens az argumentumok. { "equip", "$i" }, i lehet "all" vagy az inventory egy indexe.
     * @return EquipCommand parancs a megfelelő argumentumokkal
     * @throws ProtoException helytelen bemenet esetén kivételt dob.
     */
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
