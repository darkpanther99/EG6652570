package skeleton.model;

public class BareIce implements ChillStormStrategy {

    /**
     * Az implementált ChillStormStrategy interface Chill metódusát felüldefiniálja.
     * Sima jégen álló játékosok fázására alkalmazott metódus.
     * A t Tilen lévõ összes játékost fázatja, meghívja a Chill metódusukat.
     *
     * @param t A Tile típusú jégtábla objektum, amin a játékosok fázni fognak.
     */
    public void Chill(Tile t) {
        for (Player p : t.getOccupants()) {
            p.Chill();
        }
    }
}
