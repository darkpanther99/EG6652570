package skeleton.model;

/**
 * A víznek való ellenállást modellező interfész, ami
 * azt keezeli, hogy mit kell tenni, ha egy játékos vízzel érintkezik.
 * @author Botondar
 *
 */
public interface WaterResistanceStrategy {
	/**
	 * A vízzel való érintkezéskor lefutó fv.
	 * @param p A játékos, aki érintkezik a vízzel.
	 */
	public void Chill(Player p);
}
