package skeleton.model;

import skeleton.Logger;

import java.util.ArrayList;

public class Tile {
    private int snow;
    public Tile neighborTiles;
    private ChillStormStrategy chillStormStrategy;
    private ChillWaterStrategy chillWaterStrategy;
    private Item item;
    private ArrayList<Player> occupants;
    private int weightLimit;


    public int getWeightLimit() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(weightLimit);
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        Logger.logMethodCall(this);
        Logger.logMethodReturn();
        this.weightLimit = weightLimit;
    }

    public int getSnow() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(snow);
        return snow;
    }

    public void setSnow(int snow) {
        Logger.logMethodCall(this, snow);
        Logger.logMethodReturn();
        this.snow = snow;
    }

    public Tile getNeighborTiles() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(neighborTiles);
        return neighborTiles;
    }

    public void setNeighborTiles(Tile neighborTiles) {
        Logger.logMethodCall(this, neighborTiles);
        Logger.logMethodReturn();
        this.neighborTiles = neighborTiles;
    }

    public ChillStormStrategy getChillStormStrategy() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(chillStormStrategy);
        return chillStormStrategy;
    }

    public void setChillStormStrategy(ChillStormStrategy chillStormStrategy) {
        Logger.logMethodCall(this, chillStormStrategy);
        Logger.logMethodReturn();
        this.chillStormStrategy = chillStormStrategy;
    }

    public ChillWaterStrategy getChillWaterStrategy() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(chillWaterStrategy);
        return chillWaterStrategy;
    }

    public void setChillWaterStrategy(ChillWaterStrategy chillWaterStrategy) {
        Logger.logMethodCall(this, chillWaterStrategy);
        Logger.logMethodReturn();
        this.chillWaterStrategy = chillWaterStrategy;
    }

    public Item getItem() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(item);
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ArrayList<Player> getOccupants() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(occupants);
        return occupants;
    }

    public void setOccupants(ArrayList<Player> occupants) {
        Logger.logMethodCall(this, occupants);
        Logger.logMethodReturn();
        this.occupants = occupants;
    }


    public Tile neighborAt(int direction) {
        return null;
    }

    public void DecrementSnow() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn();
        if(snow > 0) snow--;
    }


    private void Add(Player p) {
        Logger.logMethodCall(this, p);
        Logger.logMethodReturn();
        occupants.add(p);
    }

    private void Remove(Player p) {
        Logger.logMethodCall(this, p);
        Logger.logMethodReturn();
        occupants.remove(p);
    }

    public void StepOn(Player p) {
        Logger.logMethodCall(this, p);
        Logger.logMethodReturn();
        occupants.add(p);
        if(!Logger.prompt("Elbírja az Plazyer aki rálép?")){ // occupants.size() >= weightLimit
            setSnow(0);
            setWeightLimit(0);
            setItem(new Empty());
            setChillStormStrategy(new BareIce());
            setChillWaterStrategy(new Sea());
            ChillWater();
        }
    }

    public void StepOff(Player p) {
        Logger.logMethodCall(this, p);
        Logger.logMethodReturn();
        occupants.remove(p);
    }

    public void ChillStorm() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn();
        chillStormStrategy.Chill(this);
    }

    public void ChillWater() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn();
        chillWaterStrategy.Chill(this);
    }

    public Item TakeItem() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(getItem());
        return getItem();
    }
}
