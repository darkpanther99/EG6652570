package proto.model;

/**
 * 
 * A j�t�kos �gy k�pes s�trat �p�teni.
 *
 */
public class BuildStrategy {
	
	/**
	 * Az �p�thet� s�trak sz�ma.
	 */
    private int count = 0;
    
    /**
     * �p�t egy s�trat a j�t�kos a param�terk�nt kapott mez�re. Az �p�thet� s�trak sz�ma eggyel cs�kken.
     * @param t A Tile t�p�s� mez�, ahova �p�teni akarja a j�t�kos a s�trat.
     */
    public void build(Tile t) {
        if (count >0) {
        	count--;
        	Tent te=new Tent();
        	t.setShelter(te);
        }
    }

    /**
     * Kap egy s�trat, eggyel n� az �p�thet� �trak sz�ma
     */
    public void gain() {
        count++;
    }
}
