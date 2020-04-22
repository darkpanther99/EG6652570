package proto.model;

/**
 * A játékos védtelen a hideg vízzel szemben. A játékos, ha így esik vízbe és nem menekítik ki, megfullad.
 */
public class Naked implements WaterResistanceStrategy {
    /**
     * Játékosnak nincsen ereje a vízben úszni búvárruha nélkül. Emellett fázik is.
     */
    public void chill(Player p) {
        p.setEnergy(0);
        p.chill();
    }
}
