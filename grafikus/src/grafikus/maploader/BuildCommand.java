package grafikus.maploader;

/**
 * A játékos épít parancs.
 */
public class BuildCommand implements Command {
    /**
     * Meghívja a kiválasztott játékos build függvényét
     * @param state
     * @throws MapLoaderException
     */
    @Override
    public void execute(MapLoader state) throws MapLoaderException {
        if (!state.hasSelectedPlayer()) throw new MapLoaderException("There is no selected player!");
        state.getSelectedPlayer().build();
    }

    /**
     * Visszaadja a parancsot.
     * @return A parancs
     */
    @Override
    public String toString() {
        return "build";
    }
}
