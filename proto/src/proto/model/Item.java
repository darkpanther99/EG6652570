package proto.model;
/**
 * 
 * T�rgy, a j�t�kos k�pes ilyeneket felvenni a cell�kr�l. A t�rgyak k�pesek a j�t�kosak k�pess�geket adni.
 * A t�rgyak alapvet�en j�gbe fagyva vannak a p�ly�n. 
 *
 */
public interface Item {
	/**
	 * A j�t�kos kap valamilyen t�rgyat, az Item interf�szt megval�s�t� t�rgyak fel�ldefini�lj�k ezt.
	 * @param p Ez a Player t�pus� objektum kapja t�rgyat.
	 */
    void giveTo(Player p);
}
