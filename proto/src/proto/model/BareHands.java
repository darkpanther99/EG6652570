package proto.model;


/**
 * A játékos így ás, ha nincs ásója, ezt a fajta ásást reprezentáló osztály.
 */
public class BareHands implements DigStrategy {
    /**
     * Az implementált DigStrategy interface Dig metódusát felüldefiniálja.
     * Csökkenteni szeretné a t Tile-en lévő hó mennyiségét, annak decrementSnow metódusának meghívásával.
     * Puszta kézzel ásást reprezentáló metódus.
     *
     * @param t A Tile típusú jégtábla objektum, amin a játékos ásni szeretne.
     * @return Visszaadja, hogy a játékos fárad-e az ásástól, mivel puszta kézzel mindig fárad, ezért mindig true.
     */
    public boolean dig(Tile t) {
        t.decrementSnow();
        return true;
    }
}
