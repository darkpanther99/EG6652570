package grafikus.maploader;

import grafikus.model.*;

/**
 * Itemet létrehozó, és azt játékoson, vagy mezőn elhelyező parancs.
 */
public class ItemCommand implements Command {
    /**
     * Az item darabszáma
     */
    public final int count;
    /**
     * Ásó esetén az ásó "életereje"
     * -1 a nem törékeny ásót jelenti.
     */
    public final int durability;
    /**
     * Az item típus
     */
    private final String type;

    /**
     * Konstruktor
     * @param type az item típusa
     * @param count az item darabszáma
     * @param durability ásó esetén az életerő
     */
    public ItemCommand(String type, int count, int durability) {
        this.type = type;
        this.count = count;
        this.durability = durability;
    }

    /**
     * Konstruktor
     * @param type az item típusa
     * @param count az item darabszáma
     */
    public ItemCommand(String type, int count) {
        this(type, count, -1);
    }

    /**
     * Konstruktor
     * @param type az item típusa
     */
    public ItemCommand(String type) {
        this(type, 1);
    }

    /**
     * Lefuttatja a parancsot, ami lérehoz count db itemet, és odaadja azt
     * a kiválasztott játékosnak/mezőnek. A játékosoknak precedenciája van.
     * @param state
     * @throws MapLoaderException Exceptiont dob, ha count > 1 és mezőnek akarunk itemet adni, ha type egy nem létező item típus, vagy ha nincs senki kiválasztva
     */
    @Override
    public void execute(MapLoader state) throws MapLoaderException {
        if (!state.hasSelectedPlayer() && state.hasSelectedTile() && count > 1) {
            throw new MapLoaderException("Mezonek csak 1 itemet lehet adni");
        }

        for (int i = 0; i < count; i++) {
            Item item;
            if (type.contentEquals("empty")) item = Empty.instance;
            else if (type.contentEquals("food")) item = new Food();
            else if (type.contentEquals("part")) item = new Part();
            else if (type.contentEquals("scubagear")) item = new ScubaGear();
            else if (type.contentEquals("rope")) item = new Rope();
            else if (type.contentEquals("tentkit")) item = new TentKit();
            else if (type.contentEquals("shovel")) {
                if (durability > -1) item = new BreakingShovel(durability);
                else item = new Shovel();
            } else {
                throw new MapLoaderException("Rossz item tipus");
            }

            if (state.hasSelectedPlayer()) {
                state.getSelectedPlayer().addToInventory(item);
                //item.giveTo(state.getSelectedPlayer()); // ez nem való ide
            } else if (state.hasSelectedTile()) {
                state.getSelectedTile().setItem(item);
            } else {
                throw new MapLoaderException("Nincs mezo/jatekos kivalasztva");
            }
        }
    }

    /**
     * A parancs, szöveges formában
     * @return
     */
    @Override
    public String toString() {
        if (count <= 0) return "";

        StringBuilder b = new StringBuilder();
        b.append("item ").append(type);

        if (count > 1) {
            b.append(" ").append(count);
        }

        if (type.contentEquals("shovel") && durability > -1) {
            b.append(" durability ").append(durability);
        }

        return b.toString();
    }
}
