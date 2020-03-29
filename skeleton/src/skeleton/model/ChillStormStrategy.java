package skeleton.model;

public interface ChillStormStrategy {
	
	/**
	 * Interface f�ggv�nye, ami a j�t�kosok f�z�s�r�l gondoskodik, az interfacet megval�s�t� oszt�lyoknak k�telez� fel�ldefini�lni
	 * 
	 * @param t  Tile t�pus� j�gt�bla objektum, ahol a j�t�kos f�zni fog.
	 */
	public void Chill(Tile t);
}
