package skeleton.model;

public interface DigStrategy {
	
	/**
	 * Interface f�ggv�nye, ami a j�t�kosok �s�s�r�l gondoskodik, az interfacet megval�s�t� oszt�lyoknak k�telez� fel�ldefini�lni
	 * 
	 * @param t  Tile t�pus� j�gt�bla objektum, ahol a j�t�kos �sni fog.
	 */
	public boolean Dig(Tile t);
}
