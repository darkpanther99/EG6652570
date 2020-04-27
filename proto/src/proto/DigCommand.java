package proto;

/**
 * Játékos ás parancs.
 */
public class DigCommand implements Command {
    /**
     * A kiválasztott játékos ás.
     * @param state
     * @throws ProtoException
     */
    @Override
    public void execute(Proto state) throws ProtoException {
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
