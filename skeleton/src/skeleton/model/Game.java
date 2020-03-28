package skeleton.model;


import skeleton.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static skeleton.Logger.*;

/**
 * Játék vezérlő.
 */
public class Game {
    private Collection<Player> players = new ArrayList<>();
    private Collection<Tile> icefield = new ArrayList<>();

    public Game() {
        setDisplayName(players, "players");
        setDisplayName(icefield, "icefield");
    }

    /**
     * Új kör kezdődik a játékban.
     */
    public void Turn() {
        logMethodCall(this);
        for (Player p : players)
            p.setEnergy(4);
        for (Tile t : icefield)
            t.ChillWater();
        logMethodReturn();
    }

    /**
     * A játékosok nyertek.
     */
    public void Victory() {
        logMethodCall(this);
        logMethodReturn();
    }

    /**
     * A játékosok vesztettek.
     */
    public void GameOver() {
        logMethodCall(this);
        logMethodReturn();
    }

    /**
     * Amikor létrehozunk egy cellát, eltároljuk a kollekcióban.
     */
    private void AddTile(Tile t) {
        logMethodCall(this, t);
        icefield.add(t);
        logMethodReturn();
    }

    public Collection<Tile> getIcefield() {
        logMethodCall(this);
        logMethodReturn(icefield);
        return icefield;
    }

    /**
     * Amikor létrehozunk egy játékost, eltároljuk a kollekcióban.
     */
    private void AddPlayer(Player p) {
        logMethodCall(this, p);
        players.add(p);
        logMethodReturn();
    }

    public Collection<Player> getPlayers() {
        logMethodCall(this);
        logMethodReturn(players);
        return players;
    }

    /**
     * Sarkkutató játékos létrehozása.
     *
     * @return A létrehozott játékos.
     */
    public Player CreatePolarExplorer() {
        logMethodCall(this);
        Player p = new PolarExplorer();
        p.setBodyTemp(4);
        logConstructorCall(p, "polarExplorer");
        initPlayer(p);
        logMethodReturn(p);
        return p;
    }

    /**
     * Eszkimó játékos létrehozása.
     *
     * @return A létrehozott játékos.
     */
    public Player CreateEskimo() {
        logMethodCall(this);
        Player p = new Eskimo();
        logConstructorCall(p, "eskimo");
        p.setBodyTemp(5);
        initPlayer(p);
        logMethodReturn(p);
        return p;
    }

    /**
     * Helper függvény
     */
    private void initPlayer(Player p) {
        DigStrategy ds = new BareHands();
        logConstructorCall(ds, "bareHands");
        p.setDigStrategy(ds);
        RescueStrategy rs = new CantRescue();
        logConstructorCall(rs, "cantRescue");
        p.setRescueStrategy(rs);
        WaterResistanceStrategy ws = new Naked();
        logConstructorCall(ws, "naked");
        p.setWaterResistanceStrategy(ws);
        FoodStore fs = new FoodStore();
        logConstructorCall(fs, "fs");
        p.setFoodStore(fs);
        p.setGame(this);
        AddPlayer(p);
    }

    private static Random random = new Random();

    /**
     * Ezt a  függvényt most nem használjuk.
     * A teszt initekben csak zavarna, hogy random itemek generálódnak, amiket úgy is felülírunk.
     */
    private Item generateItem() {
        final int percentageEmpty = 68;
        final int percentageScuba = 8;
        final int percentageShovel = 8;
        final int percentageFood = 8;
        final int percentageRope = 8;
        int percentage = random.nextInt() % 100;
        Item result = null;
        if (percentage < percentageEmpty) {
            result = new Empty();
            logConstructorCall(result, "empty");
        } else if (percentage < percentageEmpty + percentageScuba) {
            result = new ScubaGear();
            logConstructorCall(result, "scubaGear");
        } else if (percentage < percentageEmpty + percentageScuba + percentageShovel) {
            result = new Shovel();
            logConstructorCall(result, "shovel");
        } else if (percentage < percentageEmpty + percentageScuba + percentageShovel + percentageFood) {
            result = new Food();
            logConstructorCall(result, "food");
        } else {
            result = new Rope();
            logConstructorCall(result, "rope");
        }
        return result;
    }

    /**
     * Jégtábla cella létrehozás.
     *
     * @return Jégtábla.
     */
    public Tile CreateIce() {
        logMethodCall(this);
        Tile t = new Tile();
        logConstructorCall(t, "ice");

        final int maxPlayerCount = 999;
        t.setWeightLimit(maxPlayerCount);
        t.setSnow(random.nextInt() % 10);
        //t.setItem(generateItem());
        Item empty = new Empty();
        logConstructorCall(empty, "empty");
        t.setItem(empty);
        ChillStormStrategy cs = new BareIce();
        logConstructorCall(cs, "bareIce");
        t.setChillStormStrategy(cs);
        ChillWaterStrategy cw = new DryLand();
        logConstructorCall(cw, "dryLand");
        t.setChillWaterStrategy(cw);

        logMethodReturn(t);
        return t;
    }


    /**
     * Instabil jégtábla cella létrehozás.
     *
     * @return Instabil jégtábla.
     */
    public Tile CreateUnstableIce() {
        logMethodCall(this);
        Tile t = new Tile();
        logConstructorCall(t, "unstableIce");

        t.setWeightLimit(0);
        t.setSnow(random.nextInt() % 5 + 1);
        //t.setItem(generateItem());
        Item empty = new Empty();
        logConstructorCall(empty, "empty");
        t.setItem(empty);
        ChillStormStrategy cs = new BareIce();
        logConstructorCall(cs, "bareIce");
        t.setChillStormStrategy(cs);
        ChillWaterStrategy cw = new DryLand();
        logConstructorCall(cw, "dryLand");
        t.setChillWaterStrategy(cw);

        logMethodReturn(t);
        return t;
    }

    /**
     * Tenger cella létrehozása.
     *
     * @return Tenger.
     */
    public Tile CreateSea() {
        logMethodCall(this);
        Tile t = new Tile();
        logConstructorCall(t, "sea");

        t.setWeightLimit(0);
        t.setSnow(0);
        Item empty = new Empty();
        logConstructorCall(empty, "empty");
        t.setItem(empty);
        ChillStormStrategy cs = new BareIce();
        logConstructorCall(cs, "bareIce");
        t.setChillStormStrategy(cs);
        ChillWaterStrategy cw = new Sea();
        logConstructorCall(cw, "sea");
        t.setChillWaterStrategy(cw);

        logMethodReturn(t);
        return t;
    }

    /**
     * Lyuk cella létrehozása.
     *
     * @return Lyuk.
     */
    public Tile CreateHole() {
        logMethodCall(this);
        Tile t = new Tile();
        logConstructorCall(t, "hole");

        t.setWeightLimit(0);
        t.setSnow(random.nextInt() % 5 + 1);
        Item empty = new Empty();
        logConstructorCall(empty, "empty");
        t.setItem(empty);
        ChillStormStrategy cs = new BareIce();
        logConstructorCall(cs, "bareIce");
        t.setChillStormStrategy(cs);
        ChillWaterStrategy cw = new Sea();
        logConstructorCall(cw, "sea");
        t.setChillWaterStrategy(cw);

        logMethodReturn(t);
        return t;
    }
}
