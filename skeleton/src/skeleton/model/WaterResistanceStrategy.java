package skeleton.model;

/**
 * A víznek való ellenállást modellező interfész, ami
 * azt kezeli, hogy mit kell tenni, ha egy játékos vízzel érintkezik.
 */
public interface WaterResistanceStrategy {
    /**
     * A vízzel való érintkezéskor lefutó fv.
     *
     * @param p A játékos, aki érintkezik a vízzel.
     */
    void Chill(Player p);
}
