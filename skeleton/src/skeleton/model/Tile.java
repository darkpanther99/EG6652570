package skeleton.model;

import static skeleton.Logger.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Jégmező osztály, azokat a tábla elemeket modellezi amiből a játék pálya áll.
 */
public class Tile {
    /**
     * A táblán lévő hó mennyiségét jelenti.
     */
    private int snow;
    /**
     * A táblát körül vevő másik táblák listája, egy táblának tetszőleges számú szomszédja lehet.
     */
    private final HashMap<Integer, Tile> neighborTiles = new HashMap<>();
    /**
     * A tábla tulajdonsága, hogy hogyan viselkedik hóvihar esetén.
     */
    private ChillStormStrategy chillStormStrategy;
    /**
     * A tábla tulajdonsága, hogy hogyan viselkedik, ha vízben van aki rajta áll.
     */
    private ChillWaterStrategy chillWaterStrategy;
    /**
     * A táblán található tárgy.
     */
    private Item item;
    /**
     * A mezőn álló játékosok listája.
     */
    private Collection<Player> occupants = new ArrayList<>();
    /**
     * A tábla teherbírása
     */
    private int weightLimit;

    /**
     * Constructor
     */
    public Tile() {
        setDisplayName(neighborTiles, "neighborTiles");
        setDisplayName(occupants, "occupants");
    }

    /**
     * Visszaadja a teherbírást.
     */
    public int getWeightLimit() {
        logMethodCall(this);
        logMethodReturn(weightLimit);
        return weightLimit;
    }

    /**
     * Beállítja a tábla teherbírását.
     *
     * @param weightLimit az új teherbírás.
     */
    public void setWeightLimit(int weightLimit) {
        logMethodCall(this);
        this.weightLimit = weightLimit;
        logMethodReturn();
    }

    /**
     * Beállítja a tábla hómennyiségét.
     *
     * @param snow az új hó menniség.
     */
    public void setSnow(int snow) {
        logMethodCall(this, snow);
        this.snow = snow;
        logMethodReturn();
    }

    /**
     * Visszaadja a tábla adott irányba lévő szomszédját
     *
     * @param direction a tábla adott irányba lévő szomszédja.
     */
    public Tile neighborAt(int direction) {
        logMethodCall(this);
        Tile t = neighborTiles.get(direction);
        logMethodReturn(t);
        return t;
    }

    /**
     * Beállítja a tábla szomszédját egy adott irányból.
     *
     * @param direction az új energia szint.
     * @param neighbor Szomszéd akit beállít.
     */
    public void setNeighborAt(int direction, Tile neighbor) {
        logMethodCall(this, neighborTiles);
        neighborTiles.put(direction, neighbor);
        logMethodReturn();
    }

    public void setChillStormStrategy(ChillStormStrategy chillStormStrategy) {
        logMethodCall(this, chillStormStrategy);
        this.chillStormStrategy = chillStormStrategy;
        logMethodReturn();
    }

    public void setChillWaterStrategy(ChillWaterStrategy chillWaterStrategy) {
        logMethodCall(this, chillWaterStrategy);
        this.chillWaterStrategy = chillWaterStrategy;
        logMethodReturn();
    }

    /**
     * Visszaadja a rajta lévő tárgyat.
     */
    private Item getItem() {
        logMethodCall(this);
        logMethodReturn(item);
        return item;
    }

    /**
     * Beállítja a rajta lévő tárgyat.
     *
     * @param item az új tárgy.
     */
    public void setItem(Item item) {
        logMethodCall(this, item);
        this.item = item;
        logMethodReturn();
    }

    public Collection<Player> getOccupants() {
        logMethodCall(this);
        logMethodReturn(occupants);
        return occupants;
    }

    /**
     * Csökkenti táblán lévő hó mennyiséget.
     */
    public void DecrementSnow() {
        logMethodCall(this);
        if (snow > 0) snow--;
        logMethodReturn();
    }

    /**
     * Hozzáad egy játékost a táblán állókhoz.
     *
     * @param p az új játékos akit hozzáadunk.
     */
    private void Add(Player p) {
        logMethodCall(this, p);
        occupants.add(p);
        logMethodReturn();
    }

    /**
     * Levesz egy játékost a tábláról.
     *
     * @param p a játékos akit leveszünk.
     */
    private void Remove(Player p) {
        logMethodCall(this, p);
        occupants.remove(p);
        logMethodReturn();
    }

    /**
     * Teszteléshez kell
     * Visszaadja, hogy törött-e a tábla.
     */
    private boolean isBroken() {
        //return occupants.size() >= weightLimit;
        if (weightLimit >= 999) return false; // hack: ha stabil a jég akkor nem kell prompt
        if (weightLimit == 0) return true;
        return !prompt("Elbír még egy játékost?");
    }

    /**
     * Rálépteti a játékost a táblára, figyeli hogy elbírja-e még.
     *
     * @param p az új játékos.
     */
    public void StepOn(Player p) {
        logMethodCall(this, p);
        Add(p);
        if (isBroken()) {
            setSnow(0);
            setWeightLimit(0);
            Item empty = new Empty();
            logConstructorCall(empty, "empty");
            setItem(empty);
            ChillStormStrategy cs = new BareIce();
            logConstructorCall(cs, "chillStormStrategy");
            setChillStormStrategy(cs);
            ChillWaterStrategy cw = new Sea();
            logConstructorCall(cw, "sea");
            setChillWaterStrategy(cw);
            ChillWater();
        }
        logMethodReturn();
    }

    /**
     * Lelépteti a játékost a tábláról.
     *
     * @param p az új játékos.
     */
    public void StepOff(Player p) {
        logMethodCall(this, p);
        Remove(p);
        logMethodReturn();
    }

    /**
     * Hóbihar, a táblán lévők hűtése.
     */
    public void ChillStorm() {
        logMethodCall(this);
        chillStormStrategy.Chill(this);
        logMethodReturn();
    }
    /**
     * Vízben lévők hűtése.
     * A táblán vízben lévőkre hat.
     */
    public void ChillWater() {
        logMethodCall(this);
        chillWaterStrategy.Chill(this);
        logMethodReturn();
    }

    /**
     * Elveszi a táblán lévő tárgyat és visszaadja azt.
     * Beállítja a táblát üresre.
     */
    public Item TakeItem() {
        logMethodCall(this);
        Item i = getItem();
        Item empty = new Empty();
        logConstructorCall(empty, "empty");
        setItem(empty);
        logMethodReturn(i);
        return i;
    }
}
