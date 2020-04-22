package proto.model;
/**
 * 
 * A j�t�kos ebben a zsebben t�rolja az �lelmet.
 *
 */
public class FoodStore {
	
	/**
	 * H�ny �lelem van a j�t�kosn�l.
	 */
    private int count = 0;
    
    /**
     * J�t�kos testhoje megn�, az �lelem mennyis�ge cs�kken, mivel a j�t�kos megeszi azt.
     * @param p
     */
    public void feed(Player p) {
        if(count>0) {
        	count--;
        	p.incrementBodyTemp();
        }
    }

    /*Ez a fv lehet nem kell, kikommentezve bent hagyom egyel�re.
     * public void decrementCount() {
        count--;
    }*/

    /**
     * N�veli a benne tal�lhat� elemek sz�m�t.
     */
    public void gain() {
        count++;
    }
}
