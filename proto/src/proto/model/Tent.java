package proto.model;

/**
 * Sátor osztály. Le lehet rakni táblára.
 */
public class Tent extends Shelter {
    /**
     * Így viselkedik a tábla, ha sátor van rajta hóviharban. A sátorban lévo˝
     * játékosok nem fáznak, a metódus csak visszatér, nem csinál semmit.
     * @param t
     */
    public void chillStorm(Tile t) {
        return;
    }

    /**
     * Így viselkedik a sátor, ha eltörik. Beállítja a paraméterként kapott Tile menedékét sima jégre, ezzel jelezve halálát.
     * @param t
     */
    public void ruin(Tile t) {
        t.setShelter(new BearIce());
    }
}
