package proto.model;
import java.util.Random;
/**
 * 
 * Törheto ásó osztály.
 *
 */
public class BreakingShovel implements Item {
	/**
	 * Tárolja az aktuális BreakingShovelDig instanceot, amivel a játékos ásni fog.
	 */
    private BreakingShovelDig instance;
    /**
     * Konstruktor létrehozza a random durabilityjû törékeny ásó instancet.
     */
    public BreakingShovel() {
    	instance=new BreakingShovelDig(this);
    	instance.setDurability(new Random().nextInt(5)+1);
    }
    /**
     * A játékos így kap ásót. Az ásója annyiszor tud majd ásni törés elõtt, amennyit ez a metódus beállít neki.
     */
    public void giveTo(Player p) {
    	p.setDigStrategy(instance);
    }
    
    public void decrementInstanceDurability() {
    	instance.decrementDurability();
    }
}
