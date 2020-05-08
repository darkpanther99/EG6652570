package grafikus.maploader;

/**
 * Játékos ás parancs.
 */
public class DigCommand implements Command {
    /**
     * A kiválasztott játékos ás.
     * @param state
     * @throws MapLoaderException
     */
    @Override
    public void execute(MapLoader state) throws MapLoaderException {
        state.getSelectedPlayer().dig();
    }

    /**
     * Így jelenik meg a parancs a konzolon.
     * @return A parancs String
     */
    @Override
    public String toString() {
        return "dig";
    }
}
