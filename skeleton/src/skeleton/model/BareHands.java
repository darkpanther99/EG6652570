package skeleton.model;

import static skeleton.Logger.*;

public class BareHands implements DigStrategy {

    /**
     * Az implementált DigStrategy interface Dig metódusát felüldefiniálja.
     * Csökkenteni szeretné a t Tile-en lévő hó mennyiségét, annak DecrementSnow metódusának meghívásával.
     * Puszta kézzel ásást reprezentáló metódus.
     *
     * @param t A Tile típusú jégtábla objektum, amin a játékos ásni szeretne.
     * @return Visszaadja, hogy a játékos fárad-e az ásástól, mivel puszta kézzel mindig fárad, ezért mindig true.
     */
    public boolean Dig(Tile t) {
        logMethodCall(this, t);
        t.DecrementSnow();
        logMethodReturn(true);
        return true;
    }
}
