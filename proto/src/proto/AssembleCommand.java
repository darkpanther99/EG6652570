package proto;

/**
 * Összeszerelés parancs
 */
public class AssembleCommand implements Command {
    /**
     * A kiválasztott játékos megpróbálja összerakni a rakétát.
     * @param state
     * @throws ProtoException
     */
    @Override
    public void execute(Proto state) throws ProtoException {
        state.getSelectedPlayer().assembleFlare();
    }

    /**
     * Visszaadja a parancsot.
     * @return A parancs
     */
    @Override
    public String toString() {
        return "assemble";

    }
}
