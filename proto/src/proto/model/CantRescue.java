package proto.model;
/**
 * 
 * A játékos nem tudja kihúzni a csapattársát. A játékos ilyen állapotban van, ha nincs nála kötél.
 *
 */
public class CantRescue implements RescueStrategy {
	/**
	 * Mivel a játékos ebben az állapotban nem tudja megmenteni a csapattársát, ez a fv nem csinál vele semmit.
	 * @param water A Tile típusú objektum, amin a kimentendõ játékos áll.
	 * @param land A Tile típusú objektum, amin a kimentõ játékos áll.
	 */
    public void rescue(Tile water, Tile land) {
        return;
    }
}
