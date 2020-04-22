package proto.model;
/**
 * 
 * A j�t�kos nem tudja kih�zni a csapatt�rs�t. A j�t�kos ilyen �llapotban van, ha nincs n�la k�t�l.
 *
 */
public class CantRescue implements RescueStrategy {
	/**
	 * Mivel a j�t�kos ebben az �llapotban nem tudja megmenteni a csapatt�rs�t, ez a fv nem csin�l vele semmit.
	 * @param water A Tile t�pus� objektum, amin a kimentend� j�t�kos �ll.
	 * @param land A Tile t�pus� objektum, amin a kiment� j�t�kos �ll.
	 */
    public void rescue(Tile water, Tile land) {
        return;
    }
}
