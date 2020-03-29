package skeleton.model;

public class CantRescue implements RescueStrategy {
	
	/**
	 * Az implement�lt RescueStrategy interface Rescue met�dus�t fel�ldefini�lja.
	 * A j�t�kos �res k�zzel megpr�b�lja kimenteni csapatt�rs�t, amit nem tud, mert nincs k�tele, ez�rt a f�ggv�ny nem csin�l semmit, csak visszat�r.
	 * 
	 * 
	 * 
	 * @param water A Tile t�pus� j�gt�bla objektum, ahol a fulladoz� csapatt�rs van.
	 * @param land  A tile t�pus� j�gt�bla objektum, ahol a kimenteni v�gyakoz� j�t�kos tal�lhat�.
	 */
	public void Rescue(Tile water, Tile land) {
		return;
	}
}
