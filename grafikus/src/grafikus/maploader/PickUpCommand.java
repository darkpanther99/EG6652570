package grafikus.maploader;

/**
 * A felvesz parancsot reprezentáló osztály
 */
public class PickUpCommand implements Command {
    /**
     * A kiválasztott játékos felveszi a mezőjén lévő itemet
     * @param state
     * @throws MapLoaderException kivételt dob, ha nincs játékos kiválasztva
     */
    @Override
    public void execute(MapLoader state) throws MapLoaderException {
        state.getSelectedPlayer().pickUp();
    }

    /**
     * Visszaadja a parancsot szöveges formában
     * @return
     */
    @Override
    public String toString() {
        return "pickup";
    }
}
