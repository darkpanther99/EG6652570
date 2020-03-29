package skeleton.model;

public interface ChillWaterStrategy {

    /**
     * Interface függvénye, ami a játékosok vízben történõ fázásáról gondoskodik, az interfacet megvalósító osztályoknak kötelezõ felüldefiniálni
     *
     * @param t Tile típusú jégtábla objektum, ahol a játékos fázni fog.
     */
    public void Chill(Tile t);
}
