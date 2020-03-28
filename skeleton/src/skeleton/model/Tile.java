package skeleton.model;

import static skeleton.Logger.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Tile {
    private int snow;
    private HashMap<Integer, Tile> neighborTiles = new HashMap<>();
    private ChillStormStrategy chillStormStrategy;
    private ChillWaterStrategy chillWaterStrategy;
    private Item item;
    private ArrayList<Player> occupants;
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

    public int getSnow() {
        logMethodCall(this);
        logMethodReturn(snow);
        return snow;
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

    public ChillStormStrategy getChillStormStrategy() {
        logMethodCall(this);
        logMethodReturn(chillStormStrategy);
        return chillStormStrategy;
    }

    public void setChillStormStrategy(ChillStormStrategy chillStormStrategy) {
        logMethodCall(this, chillStormStrategy);
        this.chillStormStrategy = chillStormStrategy;
        logMethodReturn();
    }

    public ChillWaterStrategy getChillWaterStrategy() {
        logMethodCall(this);
        logMethodReturn(chillWaterStrategy);
        return chillWaterStrategy;
    }

    public void setChillWaterStrategy(ChillWaterStrategy chillWaterStrategy) {
        logMethodCall(this, chillWaterStrategy);
        this.chillWaterStrategy = chillWaterStrategy;
        logMethodReturn();
    }

    public Item getItem() {
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

    public void setOccupants(ArrayList<Player> occupants) {
        logMethodCall(this, occupants);
        this.occupants = occupants;
        logMethodReturn();
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
        return !prompt("Elbír még egy játékost?");
    }

    public void StepOn(Player p) {
        logMethodCall(this, p);
        Add(p);
        if (isBroken()) {
            setSnow(0);
            setWeightLimit(0);
            setItem(new Empty());
            setChillStormStrategy(new BareIce());
            setChillWaterStrategy(new Sea());
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
