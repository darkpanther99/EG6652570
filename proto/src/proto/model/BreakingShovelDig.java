package proto.model;

/**
 * A játékos így ás, ha törhető ásó van nála.
 */
public class BreakingShovelDig implements DigStrategy {

    /**
     * Volt-e használva a körben.
     */
    private boolean lastUsed;

    /**
     * Mennyiszer lehet még ásni vele.
     */
    private int durability;

    /**
     * Tárolja a "szülő" BreakingShovelt
     */
    private BreakingShovel b;

    /**
     * Konstruktor, beállítja a "szülő" BreakingShovelt
     *
     * @param br A BreakingShovel, ami tartalmazza ezt az objektumot instance-ként
     */
    public BreakingShovelDig(BreakingShovel br) {
        b = br;
        lastUsed = false;
    }

    /**
     * Csökkenti a tile-on található hó mennyiségét.
     *
     * @param t A Tile típusú objektum, ahol a játékos ásni szeretne.
     * @return Attól függően ad vissza igazat vagy hamisat, ha a játékos ásott-e már a körben:Minden második ásás legyen fárasztó.
     */
    public boolean dig(Tile t) {
        if (durability > 0) {
            t.decrementSnow();
            b.decrementInstanceDurability();
            durability--;
            lastUsed = !lastUsed;
            return !lastUsed; //dupla negálás, az eredetit adja vissza
        } else {
            return false;
        }
    }

    /**
     * Durability setter metódus.
     *
     * @param n A leendő durability értéke.
     */
    public void setDurability(int n) {
        durability = n;
    }

    /**
     * Durability csökkentő metódus.
     */
    public void decrementDurability() {
        durability--;
    }

}
