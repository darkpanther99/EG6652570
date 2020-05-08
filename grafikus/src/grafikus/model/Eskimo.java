package grafikus.model;

/**
 * Játékos fajta. 5 egységnyi testhővel kezd. Képes iglut építeni. A játékos irányítja.
 */
public class Eskimo extends Player {

    /**
     * Konstruktor, ami létrehoz egy játékost, majd beállítja a testhőjét ötre, mint az eszkimóknak.
     */
    public Eskimo(Game g) {
        super(g);
        this.bodyTemp = 5;
    }

    /**
     * Épít egy iglut a mezőre, amin áll, a BuildStrategy-jétől függetlenül. Az iglu megvéd majd a hóvihartól. Beállítja a mező menedékét Iglura.
     */
    public void build() {
        if (energy > 0) {
            energy--;
            Igloo i = new Igloo();
            currentTile.setShelter(i);
        }
    }
}
