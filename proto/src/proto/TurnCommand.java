package proto;

/**
 * Játékkört lefuttató parancs.
 */
public class TurnCommand implements Command {
    /**
     * Lefuttat egy kört.
     * @param state
     */
    @Override
    public void execute(Proto state) {
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