package skeleton.model;

public interface ChillWaterStrategy {

    /**
     * Interface függvénye, ami a játékosok vízben történő fázásáról gondoskodik.
     *
     * @param t Tile típusú jégtábla objektum, ahol a játékos fázni fog.
     */
    void Chill(Tile t);
}
