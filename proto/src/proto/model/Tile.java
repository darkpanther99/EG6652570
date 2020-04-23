package proto.model;

import java.util.List;
import java.util.Map;

public class Tile {
    private int snow;
    private int weightLimit;
    private Map<Integer, Tile> neighbors;
    private Shelter shelter;
    private ChillWaterStrategy chillWaterStrategy;
    private Item item;
    private List<Entity> occupants;

    public Tile neighborAt(int direction) {
        throw new RuntimeException();
    }

    public void decrementSnow() {
        throw new RuntimeException();
    }

    public Item takeItem() {
        throw new RuntimeException();
    }

    private void add(Entity e) {
        throw new RuntimeException();
    }

    private void remove(Entity e) {
        throw new RuntimeException();
    }

    public void stepOn(Entity e) {
        throw new RuntimeException();
    }

    public void stepOff(Entity e) {
        throw new RuntimeException();
    }

    public void chillStorm() {
        throw new RuntimeException();
    }

    // Tile.breakShelter
    public void ruinShelter() {
        throw new RuntimeException();
    }

    public void bearAttack() {
        throw new RuntimeException();
    }

    public void chillWater() {
        throw new RuntimeException();
    }

    public List<Entity> getOccupants() {
        return occupants;
    }

    public void setShelter(Shelter s) {
        shelter = s;
    }

    public Tile getNeighbor(int direction) {
        return neighbors.get(direction);
    }
    
    public void setSnow(int n) {
    	snow=n;
    }
    
    public void setWeightLimit(int n) {
    	weightLimit=n;
    }
    
    public void setChillWaterStrategy(ChillWaterStrategy cws) {
    	chillWaterStrategy=cws;
    }
}
