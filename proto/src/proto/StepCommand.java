package proto;

import proto.model.Entity;

/**
 * A lépés parancsot reprezentáló osztály
 */
public class StepCommand implements Command {
    /**
     * A lépés iránya
     */
    private final int direction;

    /**
     * Konstruktor.
     * @param direction A lépés iránya
     */
    public StepCommand(int direction) {
        this.direction = direction;
    }

    /**
     * Végrehajtja a lépés parancsot a kiválasztott entity-n.
     * @param state
     * @throws ProtoException Ha nincs entity kiválasztva, vagy érvénytelen a lépési irány, kivételt dob.
     */
    @Override
    public void execute(Proto state) throws ProtoException {
        Entity e;
        if (state.hasSelectedPlayer())
            e = state.getSelectedPlayer();
        else if (state.hasSelectedBear())
            e = state.getSelectedBear();
        else throw new ProtoException("Player or bear must be selected");
        if (e.getCurrentTile().getNeighbors().containsKey(direction))
            e.step(direction);
        else throw new ProtoException("Invalid step direction.");
    }

    /**
     * Visszaadja a parancsot szöveges formában
     * @return
     */
    @Override
    public String toString() {
        return "step " + direction;
    }
}
