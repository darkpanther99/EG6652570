package proto.model;

public class PolarBear extends Entity {
    /**
     * Lép az adott irányba
     *
     * @param direction
     */
    public void step(int direction) {
        step(direction);
    }

    /**
     * Nem csinál semmit, csak visszatér, mert a jegesmaci nem fázik.
     */
    public void chill() {
        return;
    }

    /**
     * Nem csinál semmit, csak visszatér, mert a jegesmaci a vízben sem fázik.
     */
    public void resistWater() {
        return;
    }

    /**
     * Nem csinál semmit, csak visszatér, mert a jegesmaci nem támadja meg fajtársait,
     * kizárólag a játékos húsát ízleli örömmel.
     */
    public void bearAttack() {
        return;
    }

}
