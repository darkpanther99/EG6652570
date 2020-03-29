package skeleton.model;

import static skeleton.Logger.*;

public class BareIce implements ChillStormStrategy {

    /**
     * Az implementált ChillStormStrategy interface Chill metódusát felüldefiniálja.
     * Sima jégen álló játékosok fázására alkalmazott metódus.
     * A t Tile-en lévő összes játékost hűti, meghívja a Chill metódusukat.
     *
     * @param t A Tile típusú jégtábla objektum, amin a játékosok fázni fognak.
     */
    public void Chill(Tile t) {
        logMethodCall(this, t);
        for (Player p : t.getOccupants()) {
            p.Chill();
        }
        logMethodReturn();
    }
}
