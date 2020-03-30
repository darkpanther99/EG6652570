package skeleton.model;

import static skeleton.Logger.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

// TODO: írdmámeg a javadocot

public class Tile {
    private int snow;
    private final HashMap<Integer, Tile> neighborTiles = new HashMap<>();
    private ChillStormStrategy chillStormStrategy;
    private ChillWaterStrategy chillWaterStrategy;
    private Item item;
    private Collection<Player> occupants = new ArrayList<>();
    private int weightLimit;

    public Tile() {
        setDisplayName(neighborTiles, "neighborTiles");
        setDisplayName(occupants, "occupants");
    }

    public int getWeightLimit() {
        logMethodCall(this);
        logMethodReturn(weightLimit);
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        logMethodCall(this);
        this.weightLimit = weightLimit;
        logMethodReturn();
    }

    public void setSnow(int snow) {
        logMethodCall(this, snow);
        this.snow = snow;
        logMethodReturn();
    }

    public Tile neighborAt(int direction) {
        logMethodCall(this);
        Tile t = neighborTiles.get(direction);
        logMethodReturn(t);
        return t;
    }

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

    private Item getItem() {
        logMethodCall(this);
        logMethodReturn(item);
        return item;
    }

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


    public void DecrementSnow() {
        logMethodCall(this);
        if (snow > 0) snow--;
        logMethodReturn();
    }


    private void Add(Player p) {
        logMethodCall(this, p);
        occupants.add(p);
        logMethodReturn();
    }

    private void Remove(Player p) {
        logMethodCall(this, p);
        occupants.remove(p);
        logMethodReturn();
    }

    private boolean isBroken() {
        //return occupants.size() >= weightLimit;
        if (weightLimit >= 999) return false; // hack: ha stabil a jég akkor nem kell prompt
        if (weightLimit == 0) return true;
        return !prompt("Elbír még egy játékost?");
    }

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

    public void StepOff(Player p) {
        logMethodCall(this, p);
        Remove(p);
        logMethodReturn();
    }

    public void ChillStorm() {
        logMethodCall(this);
        chillStormStrategy.Chill(this);
        logMethodReturn();
    }

    public void ChillWater() {
        logMethodCall(this);
        chillWaterStrategy.Chill(this);
        logMethodReturn();
    }

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
