package proto.model;
/**
 * 
 * A j�t�kos �gy �s, ha t�rheto �s� van n�la.
 *
 */
public class BreakingShovelDig implements DigStrategy {
	
	/**
	 * Volt-e haszn�lva a k�rben.
	 */
    private boolean lastUsed;
    
    /**
     * Mennyiszer lehet m�g �sni vele.
     */
    private int durability;
    
    /**
     * T�rolja a "sz�l�" BreakingShovelt
     */
    private BreakingShovel b;
    
    /**
     * Konstruktor, be�ll�tja a "sz�l�" BreakingShovelt
     * 
     * @param br A BreakingShovel, ami tartalmazza ezt az objektumot instancek�nt
     */
    public BreakingShovelDig(BreakingShovel br) {
    	b=br;
    	lastUsed=false;
    }
    
    /**
     * Cs�kkenti a tile-on tal�lhat� h� mennyis�g�t.
     * 
     * @param t A Tile t�pus� objektum, ahol a j�t�kos �sni szeretne.
     * @return Att�l f�gg�en ad vissza igazat vagy hamisat, ha a j�t�kos �sott-e m�r a k�rben:Minden m�sodik �s�s legyen f�raszt�.
     */
    public boolean dig(Tile t) {
    	if (durability>0) {
    		t.decrementSnow();
    		b.decrementInstanceDurability();
    		durability--;
    		lastUsed=!lastUsed;
            return !lastUsed; //dupla neg�l�s, az eredetit adja vissza
    	}else {
    		return false;
    	}
    }
    
    /**
     * Durability setter met�dus.
     * @param n A leend� durability �rt�ke.
     */
    public void setDurability(int n){
    	durability=n;
    }
    
    /**
     * Durability dekrement�l� met�dus.
     */
    public void decrementDurability() {
    	durability--;
    }
    
}
