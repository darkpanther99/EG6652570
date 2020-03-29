package skeleton.model;

public interface ChillWaterStrategy {
	
	/**
	 * Interface f�ggv�nye, ami a j�t�kosok v�zben t�rt�n� f�z�s�r�l gondoskodik, az interfacet megval�s�t� oszt�lyoknak k�telez� fel�ldefini�lni
	 * 
	 * @param t  Tile t�pus� j�gt�bla objektum, ahol a j�t�kos f�zni fog.
	 */
	public void Chill(Tile t);
}
