package grafikus.model;

/**
 * Tárgy, a játékos képes ilyeneket felvenni a cellákról. A tárgyak képesek a játékosak képességeket adni.
 * A tárgyak alapvetően jégbe fagyva vannak a pályán.
 */
public interface Item {
    /**
     * A játékos kap valamilyen tárgyat, az Item interfészt megvalósító tárgyak felüldefiniálják ezt.
     *
     * @param p Ez a Player típusú objektum kapja tárgyat.
     */
    void giveTo(Player p);
}
