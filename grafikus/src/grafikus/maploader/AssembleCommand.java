package grafikus.maploader;

/**
 * Összeszerelés parancs
 */
public class AssembleCommand implements Command {
    /**
     * A kiválasztott játékos megpróbálja összerakni a rakétát.
     * @param state
     * @throws MapLoaderException
     */
    @Override
    public void execute(MapLoader state) throws MapLoaderException {
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
