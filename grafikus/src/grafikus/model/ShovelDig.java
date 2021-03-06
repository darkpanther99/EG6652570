package grafikus.model;

/**
 * Egyszer lehet ásni vele fáradság nélkül is.
 */
public class ShovelDig implements DigStrategy {
    private boolean lastUsed = false;

    /**
     * Csökkenti a tile-on található hó mennyiségét. Minden második alkalommal
     * fárasztó.
     *
     * @param t
     * @return
     */
    public boolean dig(Tile t) {
        t.decrementSnow();
        lastUsed = !lastUsed;
        return !lastUsed;
    }
}
