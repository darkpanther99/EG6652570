package skeleton.model;

/**
 * Egy tárgy, amit egy játékos birtokolhat.
 */
public interface Item {
    /**
     * A játékos megkapja a tárgyat.
     *
     * @param p A játékos.
     */
    void GiveTo(Player p);
}
