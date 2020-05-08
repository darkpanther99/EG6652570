package grafikus.maploader;

/**
 * Játékkört lefuttató parancs.
 */
public class TurnCommand implements Command {
    /**
     * Lefuttat egy kört.
     * @param state
     */
    @Override
    public void execute(MapLoader state) {
        state.game.turn();
    }

    /**
     * Visszaadja a parancsot szöveges formában.
     * @return
     */
    @Override
    public String toString() {
        return "turn";
    }
}