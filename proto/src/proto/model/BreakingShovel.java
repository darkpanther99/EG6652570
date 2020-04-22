package proto.model;
import java.util.Random;
/**
 * 
 * T�rheto �s� oszt�ly.
 *
 */
public class BreakingShovel implements Item {
	/**
	 * T�rolja az aktu�lis BreakingShovelDig instanceot, amivel a j�t�kos �sni fog.
	 */
    private BreakingShovelDig instance;
    /**
     * Konstruktor l�trehozza a random durabilityj� t�r�keny �s� instancet.
     */
    public BreakingShovel() {
    	instance=new BreakingShovelDig(this);
    	instance.setDurability(new Random().nextInt(5)+1);
    }
    /**
     * A j�t�kos �gy kap �s�t. Az �s�ja annyiszor tud majd �sni t�r�s el�tt, amennyit ez a met�dus be�ll�t neki.
     */
    public void giveTo(Player p) {
    	p.setDigStrategy(instance);
    }
    
    public void decrementInstanceDurability() {
    	instance.decrementDurability();
    }
}
