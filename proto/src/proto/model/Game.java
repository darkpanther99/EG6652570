package proto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface a Model és a Controller között.
 * A játékmesterhez tartozó működést valósítja meg.
 * Felelős a játékban lévő objektumok tárolásáért és létrehozásáért.
 */
public class Game {

    /**
     * Tárolja a játékosokat.
     */
    private List<Player> players;

    /**
     * Tárolja a pályát alkotó elemeket.
     */
    private List<Tile> iceField;

    /**
     * Tárolja a medvé(ke)t, ha több van akkor is.
     */
    private List<PolarBear> bears;

    /**
     * Őket értesíti a játék eseményekről.
     */
    private List<GameObserver> observers;

    public Game() {
        players = new ArrayList<>();
        iceField = new ArrayList<>();
        bears = new ArrayList<>();
        observers = new ArrayList<>();
    }


    /**
     * Ezt a metódust a Controller hívja körönként, a körök vezénylésére szolgál.
     */
    public void turn() {
        for (Player p : players) {
            p.setEnergy(4);
        }
        for (Tile t : iceField) {
            t.chillWater();
            t.ruinShelter();
        }
    }

    /**
     * Belerakja a kollekcióba a paraméterként kapott megfigyelőt.
     *
     * @param go A feliratkoztatandó megfigyelő.
     */
    public void subscribe(GameObserver go) {
        observers.add(go);
    }

    /**
     * Eltávolítja a kollekcióból a paraméterként kapott megfigyelőt.
     *
     * @param go A leiratkoztatandó megfigyelő.
     */
    public void unsubscribe(GameObserver go) {
        if (observers.contains(go)) {
            observers.remove(go);
        } else {
            return;
        }
    }

    /**
     * Ha vége a játéknak, szól a feliratkozóknak, hogy nyertünk.
     */
    public void victory() {
        for (GameObserver go : observers) {
            go.victory();
        }
    }

    /**
     * Ha vége a játéknak, szól a feliratkozóknak, hogy vesztettünk.
     */
    public void gameOver() {
        for (GameObserver go : observers) {
            go.gameOver();
        }
    }

    /**
     * Hozzáad egy cellát a játékhoz
     *
     * @param t A hozzáadandó Tile típusú cella.
     */
    private void addTile(Tile t) {
        iceField.add(t);
    }

    /**
     * Hozzáad egy játékost a játékhoz.
     *
     * @param p A hozzáadandó Player típusú játékos.
     */
    private void addPlayer(Player p) {
        players.add(p);
    }

    /**
     * Hozzáad egy jegesmedvét a játékhoz.
     *
     * @param pb A hozzáadandó PolarBear típusú jegesmedve.
     */
    public void addPolarBear(PolarBear pb) {
        bears.add(pb);
    }

    /**
     * Szól a feliratkozóknak, hogy egy sarkkutató felderített egy cellát.
     *
     * @param t A Tile típusú felderített cella objektum.
     */
    public void explore(Tile t) {
        for (GameObserver go : observers) {
            go.explore(t);
        }
    }

    /**
     * Létrehoz egy sarkkutató játékost.
     *
     * @return Visszaadja a létrehozott sarkkutatót.
     */
    public PolarExplorer createPolarExplorer() {
        PolarExplorer p = new PolarExplorer(this);
        addPlayer(p);
        return p;
    }

    /**
     * Létrehoz egy eszkimó játékost.
     *
     * @return Visszaadja a létrehozott eszkimót.
     */
    public Eskimo createEskimo() {
        Eskimo e = new Eskimo(this);
        addPlayer(e);
        return e;
    }

    /**
     * Létrehoz egy jegesmaci entitást.
     *
     * @return Visszaadja a létrehozott jegesmacit.
     */
    public PolarBear createPolarBear() {
        PolarBear pb = new PolarBear();
        addPolarBear(pb);
        return pb;
    }

    /**
     * Létrehoz egy cellát.
     *
     * @param snow        A cella hómennyisége.
     * @param weightLimit A cella teherbírása.
     * @return A létrehozott cellát adja vissza.
     */
    public Tile createTile(int snow, int weightLimit) {
        Tile t = new Tile();
        t.setSnow(snow);
        if (weightLimit == -1) {
            weightLimit = 999;
        }
        if (weightLimit == 0) {
            t.setChillWaterStrategy(new Sea());
        } else {
            t.setChillWaterStrategy(new DryLand());
        }
        t.setWeightLimit(weightLimit);
        t.setShelter(new BareIce());
        addTile(t);
        return t;
    }

    public List<Tile> getIceField() {
        return iceField;
    }

    public List<PolarBear> getBears() {
        return bears;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Tile getTile(int index) {
        return iceField.get(index);
    }

    public PolarBear getBear(int index) {
        return bears.get(index);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public List<Tile> getTiles() {
        return iceField;
    }
}
