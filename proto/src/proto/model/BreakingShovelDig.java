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
     * Konstruktor, beállítja a "szülő" BreakingShovelt
     */
    public BreakingShovelDig() {
        lastUsed = false;
    }

    /**
     * Csökkenti a tile-on található hó mennyiségét.
     *
     * @param t A Tile típusú objektum, ahol a játékos ásni szeretne.
     * @return Attól függően ad vissza igazat vagy hamisat, ha a játékos ásott-e már a körben:Minden második ásás legyen fárasztó.
     */
    public boolean dig(Tile t) {
        // @NOTE(boti): mivel nincs unequip-ünk, ezért szerintem jobb, ha az eltört ásó
        //              úgy viselkedik, mint a BareHands.
        //              Ezért mindig van decrement snow, csak eltört ásó esetén mindig csökkentjük az energiát is.
        t.decrementSnow();

        if (durability > 0) {

            if (!lastUsed) {
                durability--;
            }
            lastUsed = !lastUsed;

            return !lastUsed; //dupla negálás, az eredetit adja vissza
        } else {
            return true;
        }
    }

    /**
     * Durability csökkentő metódus.
     */
    public void decrementDurability() {
        durability--;
    }

    public int getDurability() {
        return durability;
    }

    /**
     * Durability setter metódus.
     *
     * @param n A leendő durability értéke.
     */
    public void setDurability(int n) {
        durability = n;
    }

}
