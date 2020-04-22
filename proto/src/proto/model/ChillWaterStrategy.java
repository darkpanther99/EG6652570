package proto.model;

/**
 * A jégtábla így hűti a vízbe esett játékosokat. Vízben tartózkodás esetén a játékos testhője csökken, a megvalósított stratégia alapján.
 */
public interface ChillWaterStrategy {

    /**
     * A stratégiát megvalósító elem dolga implementálni mi történik
     *
     * @param t A Tile típusú objektum, amin a játékos fázni fog.
     */
    void chill(Tile t);
}
