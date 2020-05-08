package grafikus.maploader;

/**
 * A kimentés parancsot reprezentáló osztály
 */
public class RescueCommand implements Command {
    /**
     * A kimentés iránya
     */
    private final int direction;

    /**
     * Konstruktor.
     * @param direction A kimentés iránya
     */
    public RescueCommand(int direction) {
        this.direction = direction;
    }

    /**
     * Lefuttatja a parancsot
     *
     * A kiválasztott játékos megpróbálja kimenteni a szomszédos mezőről a csapattársát.
     * @param state
     * @throws MapLoaderException Kivételt dob, ha nincs játékos kiválasztva
     */
    @Override
    public void execute(MapLoader state) throws MapLoaderException {
        if(state.hasSelectedPlayer()) {
            state.getSelectedPlayer().rescueTeammate(direction);
        } else {
            throw new MapLoaderException("Nincs jatekos kivalasztva");
        }
    }

    /**
     * Visszaadja a parancsot szöveges formában
     * @return
     */
    @Override
    public String toString() {
        return "rescue " + direction;
    }
}
