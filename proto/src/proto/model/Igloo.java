package proto.model;
/**
 * 
 * Ezen a jégtáblán iglu áll, a játékosok védve vannak a vihartól. Az ilyen táblán nem csökken a viharban a rajta állók testhõje. 
 *
 */
public class Igloo extends Shelter {
	/**
	 * A paraméterként kapott cellán álló játékosok testhoje nem csökken, mivel igluban vannak.
	 */
    public void chillStorm(Tile t) {
        return;
    }

    /**
     * Így viselkedik a mezo ha valaki igluban van és megtámadja a medve. Visszatér, mert a medve az igluban meghúzódó játékosokat nem bántja.
     */
    public void bearAttack(Tile t) {
        return;
    }
    
    /**
     * Visszatér, nem csinál semmit, mivel az iglu nem törik el soha.
     */
    public void ruin(Tile t) {
    	return;
    }
}
