package skeleton.model;

public interface DigStrategy {
	
	/**
	 * Interface függvénye, ami a játékosok ásásáról gondoskodik, az interfacet megvalósító osztályoknak kötelezõ felüldefiniálni
	 * 
	 * @param t  Tile típusú jégtábla objektum, ahol a játékos ásni fog.
	 */
	public boolean Dig(Tile t);
}
