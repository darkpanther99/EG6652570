package skeleton.model;

public interface DigStrategy {

    /**
     * Interface függvénye, ami a játékosok ásásáról gondoskodik.
     *
     * @param t Tile típusú jégtábla objektum, ahol a játékos ásni fog.
     */
    boolean Dig(Tile t);
}
