package proto.model;
/**
 * 
 * Entit�s oszt�ly ami a p�ly�n tart�zkodhat
 *
 */
public class Entity {
	
	/**
	 * T�rolja a Tile t�pus� j�gt�bl�t, amin az entit�s �ppen tart�zkodik.
	 */
    protected Tile currentTile;
    
    /**
     * Az entit�s a param�terk�nt kapott ir�nyba l�p.
     * @param direction Az ir�ny
     */
    public void step(int direction) {
        Tile t=currentTile.getNeighbor(direction);
        t.stepOff(this);
        this.placeOn(t);
    }

    /**
     * R�teszi az entit�st egy m�sik t�bl�ra. A k�t�l haszn�latakor is haszn�latos.
     * @param t A mez�, amire az entit�s l�p.
     */
    public void placeOn(Tile t) {
    	t.stepOn(this);
        currentTile=t;
    }

    /**
     *  H�ti az entit�st. A testh�je cs�kken. Nem csin�l semmit, csak visszat�r, majd a lesz�rmazottak fel�ldefini�lj�k.
     */
    public void chill() {
       return;
    }

    /**
     *  �gy viselkedik v�zben. Nem csin�l semmit, csak visszat�r, majd a lesz�rmazottak fel�ldefini�lj�k.
     */
    public void resistWater() {
        return;
    }

    /**
     *�gy viselkedik, ha megt�madja a medve. Nem csin�l semmit, csak visszat�r, majd a lesz�rmazottak fel�ldefini�lj�k.
     */
    public void bearAttack() {
        return;
    }
}
