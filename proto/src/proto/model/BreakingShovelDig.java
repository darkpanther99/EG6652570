package proto.model;
/**
 * 
 * A játékos így ás, ha törheto ásó van nála.
 *
 */
public class BreakingShovelDig implements DigStrategy {
	
	/**
	 * Volt-e használva a körben.
	 */
    private boolean lastUsed;
    
    /**
     * Mennyiszer lehet még ásni vele.
     */
    private int durability;
    
    /**
     * Tárolja a "szülõ" BreakingShovelt
     */
    private BreakingShovel b;
    
    /**
     * Konstruktor, beállítja a "szülõ" BreakingShovelt
     * 
     * @param br A BreakingShovel, ami tartalmazza ezt az objektumot instanceként
     */
    public BreakingShovelDig(BreakingShovel br) {
    	b=br;
    	lastUsed=false;
    }
    
    /**
     * Csökkenti a tile-on található hó mennyiségét.
     * 
     * @param t A Tile típusú objektum, ahol a játékos ásni szeretne.
     * @return Attól függõen ad vissza igazat vagy hamisat, ha a játékos ásott-e már a körben:Minden második ásás legyen fárasztó.
     */
    public boolean dig(Tile t) {
    	if (durability>0) {
    		t.decrementSnow();
    		b.decrementInstanceDurability();
    		durability--;
    		lastUsed=!lastUsed;
            return !lastUsed; //dupla negálás, az eredetit adja vissza
    	}else {
    		return false;
    	}
    }
    
    /**
     * Durability setter metódus.
     * @param n A leendõ durability értéke.
     */
    public void setDurability(int n){
    	durability=n;
    }
    
    /**
     * Durability dekrementáló metódus.
     */
    public void decrementDurability() {
    	durability--;
    }
    
}
