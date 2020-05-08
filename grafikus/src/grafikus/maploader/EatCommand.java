package grafikus.maploader;

/**
 * Játékos eszik parancs.
 */
public class EatCommand implements Command {
    /**
     * A kiválasztott játékos eszik.
     * @param state
     * @throws MapLoaderException
     */
    @Override
    public void execute(MapLoader state) throws MapLoaderException {
        state.getSelectedPlayer().eatFood();
    }
    /**
     * Így jelenik meg a parancs a konzolon.
     * @return A parancs String
     */
    @Override
    public String toString() {
        return "eat";
    }
}
