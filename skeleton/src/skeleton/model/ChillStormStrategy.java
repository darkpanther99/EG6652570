package skeleton.model;

public interface ChillStormStrategy {

    /**
     * Interface függvénye, ami a játékosok fázásáról gondoskodik.
     *
     * @param t Tile típusú jégtábla objektum, ahol a játékos fázni fog.
     */
    void Chill(Tile t);
}
