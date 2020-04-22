package proto.model;

/**
 * 
 * A szárazföld nem hûti a játékosokat. A játékos nincsen vízben. Ezt reprezentáló osztály.
 *
 */
public class DryLand implements ChillWaterStrategy {
	/**
	 * A stratégia megvalósítása miatt kér be egy t Tile paramétert, a rajta levõ játékossal viszont nem csinál semmit, mert az nincs vízben, nem csökkenti testhojét.
	 * @param A stratégia megvalósítása miatt kér be egy t Tile paramétert, a rajta levõ játékossal viszont nem csinál semmit.
	 */
    public void chill(Tile t) {
        return;
    }
}
