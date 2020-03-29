package skeleton.model;

public class BareHands implements DigStrategy {
	
	/**
	 * Az implementált DigStrategy interface Dig metódusát felüldefiniálja.
	 * Csökkenteni szertné a t Tilen lévõ hó mennyiségét, annak DecrementSnow metódusának meghívásával.
	 * Puszta kézzel ásást reprezentáló metódus.
	 * 
	 * 
	 * @param t A Tile típusú jégtábla objektum, amin a játékos ásni szeretne.
	 * @return 	Visszaadja, hogy a játékso fárad-e az ásástól, mivel puszta kézzel mindig fárad, ezért mindig true.
	 */
	public boolean Dig(Tile t) {
		t.DecrementSnow();
		return true;
	}
	
}
