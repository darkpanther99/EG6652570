package proto.model;

/**
 * A játékos így ás. Ásáskor a cellán a hómennyiség csökken.
 */
public interface DigStrategy {
    /**
     * A stratégiát megvalósító elem dolga implementálni mi történik ásáskor. Visszaadja, hogy az ásás fárasztó-e.
     *
     * @param t A Tile típusú objektum, ahol a játékos ásni szeretne.
     * @return Igaz vagy hamis attól függően, hogy az ásás fárasztó-e.
     */
    boolean dig(Tile t);
}
