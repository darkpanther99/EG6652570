package skeleton.model;

public interface ChillStormStrategy {
	
	/**
	 * Interface függvénye, ami a játékosok fázásáról gondoskodik, az interfacet megvalósító osztályoknak kötelezõ felüldefiniálni
	 * 
	 * @param t  Tile típusú jégtábla objektum, ahol a játékos fázni fog.
	 */
	public void Chill(Tile t);
}
