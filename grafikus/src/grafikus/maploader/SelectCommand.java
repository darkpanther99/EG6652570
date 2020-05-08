package grafikus.maploader;

/**
 * Parancs, ami kiválaszt egy játékost/mezőt/ medvét a jégmezőn.
 */
public class SelectCommand implements Command {
    /**
     * A típus, amit ki szeretnénk választani.
     */
    private final String type;
    /**
     * A kiválasztandó lény indexe
     */
    private final int index;

    /**
     * Konstruktor
     * @param type
     * @param index
     */
    public SelectCommand(String type, int index) {
        this.type = type;
        this.index = index;
    }

    /**
     * Kiválasztja az megadott játékost/medvét/mezőt.
     * @param state
     * @throws MapLoaderException Ha helytelen a típus, vagy nincs ilyen indexű lény, kivételt dob
     */
    @Override
    public void execute(MapLoader state) throws MapLoaderException {
        try {
            if (type.contentEquals("tile")) state.selectTile(state.game.getTile(index));
            else if (type.contentEquals("polarbear")) state.selectBear(state.game.getBear(index));
            else if (type.contentEquals("player")) state.selectPlayer(state.game.getPlayer(index));
            else {
                throw new MapLoaderException("Sanity check failed");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new MapLoaderException(e.getMessage(), e.getCause());
        }
    }

    /**
     * Visszaadja a parancsot szöveges formában.
     * @return
     */
    @Override
    public String toString() {
        return "select " + type + " " + index;
    }
}
