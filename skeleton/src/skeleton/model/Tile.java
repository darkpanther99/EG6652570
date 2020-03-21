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

    public int getWeightLimit() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(weightLimit);
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    private int weightLimit;

    public int getSnow() {
        return snow;
    }

    public void setSnow(int snow) {
        this.snow = snow;
    }

    public Tile getNeighborTiles() {
        return neighborTiles;
    }

    public void setNeighborTiles(Tile neighborTiles) {
        this.neighborTiles = neighborTiles;
    }

    public ChillStormStrategy getChillStormStrategy() {
        return chillStormStrategy;
    }

    public void setChillStormStrategy(ChillStormStrategy chillStormStrategy) {
        this.chillStormStrategy = chillStormStrategy;
    }

    public ChillWaterStrategy getChillWaterStrategy() {
        return chillWaterStrategy;
    }

    public void setChillWaterStrategy(ChillWaterStrategy chillWaterStrategy) {
        this.chillWaterStrategy = chillWaterStrategy;
    }

    public Item getItem() {
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
        this.occupants = occupants;
    }

    public int GetSnow() {
        return snow;
    }

    public ArrayList<Player> GetOccupants() {
        return occupants;
    }

    public Tile NeighborAt(int direction) {
        return null;
    }

    public void DecrementSnow() {
    }


    private void Add(Player p) {
    }

    private void Remove(Player p) {
    }

    public void StepOn(Player p) {
    }

    public void StepOff(Player p) {
    }

    public void ChillStorm() {
    }

    public void ChillWater() {
    }

    public Item TakeItem() {
        return null;
    }
}
