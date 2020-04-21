package proto.model;

import java.util.Map;

public class Tile {
    private int snow;
    private int weightLimit;
    private Map<Integer, Tile> neighbors;
    private Shelter shelter;
    private ChillWaterStrategy chillWaterStrategy;
    private Item item;
    private Entity occupants;

    public Tile NeighborAt(int direction) {
        throw new RuntimeException();
    }

    public void DecrementSnow() {
        throw new RuntimeException();
    }

    public Item TakeItem() {
        throw new RuntimeException();
    }

    private void Add(Entity e) {
        throw new RuntimeException();
    }

    private void Remove(Entity e) {
        throw new RuntimeException();
    }

    public void StepOn(Entity e) {
        throw new RuntimeException();
    }

    public void StepOff(Entity e) {
        throw new RuntimeException();
    }

    public void ChillStorm() {
        throw new RuntimeException();
    }

    public void BreakShelter() {
        throw new RuntimeException();
    }

    public void BearAttack() {
        throw new RuntimeException();
    }

    public void ChillWater() {
        throw new RuntimeException();
    }
}
