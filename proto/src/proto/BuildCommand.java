package proto;

/**
 * A játékos épít parancs.
 */
public class BuildCommand implements Command {
    /**
     * Meghívja a kiválasztott játékos build függvényét
     * @param state
     * @throws ProtoException
     */
    @Override
    public void execute(Proto state) throws ProtoException {
        if (!state.hasSelectedPlayer()) throw new ProtoException("There is no selected player!");
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
