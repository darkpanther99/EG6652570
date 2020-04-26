package proto.model;

/**
 * Ez az absztrakt osztály a menedéket jelképezi egy mezon
 */
public abstract class Shelter {
    /**
     * Minden a paraméterként kapott t mezon lév ˝ o entitás fázik.
     *
     * @param t
     */
    public void chillStorm(Tile t) {
        for (Entity e : t.getOccupants()) {
            e.chill();
        }
    }

    /**
     * A menedéken lévo játékosok medvetámadás áldozatai lesznek.
     *
     * @param t
     */
    public void bearAttack(Tile t) {
        for (Entity e : t.getOccupants()) {
            e.bearAttack();
        }
    }

    /**
     * Az adott mezon lév ˝ o menedék eltörik. Nem csinál semmit, majd a különböz ˝ o˝
     * menedéktípusok másképp definiálják felül.
     *
     * @param t
     */
    public void ruin(Tile t) {
        return;
    }
}
