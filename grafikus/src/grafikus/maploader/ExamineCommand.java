package grafikus.maploader;

import grafikus.model.PolarExplorer;

/**
 * Parancs, ami a kiválasztott sarkkutatóval megvizsgálja
 * az egyik szomszédos mezőt.
 */
public class ExamineCommand implements Command {
    /**
     * Az szomszédos mező iránya, amit a sarkkutató vizsgál
     */
    private final int direction;

    /**
     * Konstruktor
     *
     * @param direction Az szomszédos mező iránya, amit a sarkkutató vizsgál
     */
    public ExamineCommand(int direction) {
        this.direction = direction;
    }

    /**
     * Megvizsgálja a sarkkutató a szomszédos mezőt.
     *
     * @param state
     * @throws MapLoaderException ha nincs játékos/nem sarkkutató van kiválasztva, kivételt dob.
     */
    @Override
    public void execute(MapLoader state) throws MapLoaderException {

        if (state.getSelectedPlayer() instanceof PolarExplorer) {
            PolarExplorer p = (PolarExplorer) state.getSelectedPlayer();
            p.examine(direction);
        } else {
            throw new MapLoaderException("Nem sarkkutato van kivalasztva");
        }
    }

    @Override
    public String toString() {
        return "examine " + direction;
    }
}
