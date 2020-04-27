package proto;

/**
 * A felvesz parancsot reprezentáló osztály
 */
public class PickUpCommand implements Command {
    /**
     * A kiválasztott játékos felveszi a mezőjén lévő itemet
     * @param state
     * @throws ProtoException kivételt dob, ha nincs játékos kiválasztva
     */
    @Override
    public void execute(Proto state) throws ProtoException {
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
