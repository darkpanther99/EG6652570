package proto.model;

/**
 * 
 * A játékos így képes sátrat építeni.
 *
 */
public class BuildStrategy {
	
	/**
	 * Az építhetõ sátrak száma.
	 */
    private int count = 0;
    
    /**
     * Épít egy sátrat a játékos a paraméterként kapott mezõre. Az építhetõ sátrak száma eggyel csökken.
     * @param t A Tile típúsú mezõ, ahova építeni akarja a játékos a sátrat.
     */
    public void build(Tile t) {
        if (count >0) {
        	count--;
        	Tent te=new Tent();
        	t.setShelter(te);
        }
    }

    /**
     * Kap egy sátrat, eggyel nõ az építhetõ átrak száma
     */
    public void gain() {
        count++;
    }
}
