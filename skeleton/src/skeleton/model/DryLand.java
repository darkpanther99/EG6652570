package skeleton.model;

public class DryLand implements ChillWaterStrategy {

    /**
     * Az implementált ChillWaterStrategy interface Chill metódusát felüldefiniálja.
     * A szárazföldön álló játékosok nem fáznak a víz hidegétõl, ezért a függvény nem csinál semmit, csak visszatér.
     *
     * @param t Tile típusú jégtábla objektum, ahol a játékos fázni fog.
     */
    public void Chill(Tile t) {
        return;
    }
}
