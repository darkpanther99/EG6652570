package proto.model;

/**
 * Entitás osztály ami a pályán tartózkodhat
 */
public class Entity {

    /**
     * Tárolja a Tile típusú jégtáblát, amin az entitás éppen tartózkodik.
     */
    protected Tile currentTile;

    /**
     * Az entitás a paraméterként kapott irányba lép.
     *
     * @param direction Az irány
     */
    public void step(int direction) {
        Tile t = currentTile.getNeighbor(direction);
        t.stepOff(this);
        this.placeOn(t);
    }

    /**
     * Ráteszi az entitást egy másik táblára. A kötél használatakor is használatos.
     *
     * @param t A mező, amire az entitás lép.
     */
    public void placeOn(Tile t) {
        t.stepOn(this);
        currentTile = t;
    }

    /**
     * Hűti az entitást. A testhője csökken. Nem csinál semmit, csak visszatér, majd a leszármazottak felüldefiniálják.
     */
    public void chill() {
        return;
    }

    /**
     * Így viselkedik vízben. Nem csinál semmit, csak visszatér, majd a leszármazottak felüldefiniálják.
     */
    public void resistWater() {
        return;
    }

    /**
     * Így viselkedik, ha megtámadja a medve. Nem csinál semmit, csak visszatér, majd a leszármazottak felüldefiniálják.
     */
    public void bearAttack() {
        return;
    }
}
