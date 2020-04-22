package proto.model;

/**
 * A szárazföld nem hűti a játékosokat. A játékos nincsen vízben. Ezt reprezentáló osztály.
 */
public class DryLand implements ChillWaterStrategy {
    /**
     * A stratégia megvalósítása miatt kér be egy t Tile paramétert.
     * A rajta levő játékossal viszont nem csinál semmit, mert az nincs vízben, nem csökkenti testhőjét.
     *
     * @param t A stratégia megvalósítása miatt kér be egy t Tile paramétert.
     *         A rajta levő játékossal viszont nem csinál semmit.
     */
    public void chill(Tile t) {
        return;
    }
}
