package proto;

/**
 * Játékos eszik parancs.
 */
public class EatCommand implements Command {
    /**
     * A kiválasztott játékos eszik.
     * @param state
     * @throws ProtoException
     */
    @Override
    public void execute(Proto state) throws ProtoException {
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
