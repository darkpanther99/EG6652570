package proto.model;

/**
 * Így reagál a játékos a hideg vízre. A vízben búvárruha nélkül nem lehet mozogni. A vízbo ̋l ha búvárruha nélkül
 * nem húznak ki, nem lehet életben maradni.
 */
public interface WaterResistanceStrategy {
    /**
     * A stratégiát megvalósító elem dolga implementálni mi történik.
     *
     * @param p
     */
    void chill(Player p);
}
