package grafikus.maploader;

import java.util.List;

/**
 * Szöveges argumentum listából EquipCommand-ot létrehozó osztály
 */
public class EquipCommandParser implements CommandParser {

    /**
     * Visszaadja a parancshoz tartozó kulcsszót
     *
     * @return A kulcsszó. Mindig "equip"
     */
    @Override
    public String getKeyword() {
        return "equip";
    }

    /**
     * EquipCommandot hoz létre az argumentumokból
     *
     * @param tokens az argumentumok. { "equip", "$i" }, i lehet "all" vagy az inventory egy indexe.
     * @return EquipCommand parancs a megfelelő argumentumokkal
     * @throws MapLoaderException helytelen bemenet esetén kivételt dob.
     */
    @Override
    public Command parse(List<String> tokens) throws MapLoaderException {
        if (tokens.size() < 2 || !tokens.get(0).contentEquals(getKeyword())) {
            throw new MapLoaderException("Rossz bemenet");
        }

        String index = tokens.get(1);
        if (index.contentEquals("all")) {
            return new EquipCommand();
        } else {
            try {
                return new EquipCommand(Integer.parseInt(index));
            } catch (NumberFormatException e) {
                throw new MapLoaderException(e.getMessage(), e.getCause());
            }
        }
    }
}
