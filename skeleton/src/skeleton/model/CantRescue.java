package skeleton.model;

public class CantRescue implements RescueStrategy {
	
	/**
	 * Az implementált RescueStrategy interface Rescue metódusát felüldefiniálja.
	 * A játékos üres kézzel megpróbálja kimenteni csapattársát, amit nem tud, mert nincs kötele, ezért a függvény nem csinál semmit, csak visszatér.
	 * 
	 * 
	 * 
	 * @param water A Tile típusú jégtábla objektum, ahol a fulladozó csapattárs van.
	 * @param land  A tile típusú jégtábla objektum, ahol a kimenteni vágyakozó játékos található.
	 */
	public void Rescue(Tile water, Tile land) {
		return;
	}
}
