package proto.model;

import java.util.List;

public abstract class Player extends Entity {
    private int bodyTemp;
    private int energy;
    private Game game;
    private DigStrategy digStrategy;
    private RescueStrategy rescueStrategy;
    private WaterResistanceStrategy waterResistanceStrategy;
    private FoodStore foodStore;
    private PartStore partStore;
    private List<Item> inventory;
    private BuildStrategy buildStrategy;

    public void Step(int direction) {
        throw new RuntimeException();
    }

    public void ResistWater() {
        throw new RuntimeException();
    }

    public void Chill() {
        throw new RuntimeException();
    }

    public void BearAttack() {
        throw new RuntimeException();
    }

    public void DecrementEnergy() {
        throw new RuntimeException();
    }

    public void IncrementBodyTemp() {
        throw new RuntimeException();
    }

    public void PickUp() {
        throw new RuntimeException();
    }

    private void AddToInventory(Item i) {
        throw new RuntimeException();
    }

    private void RemoveFromInventory(Item i) {
        throw new RuntimeException();
    }

    public void Equip(int inventorySlot) {
        throw new RuntimeException();
    }

    public void ToFoodStore() {
        throw new RuntimeException();
    }

    public void EatFood() {
        throw new RuntimeException();
    }

    public void Dig() {
        throw new RuntimeException();
    }

    public void Build() {
        throw new RuntimeException();
    }

    public void RescueTeammate(int direction) {
        throw new RuntimeException();
    }

    public void AssembleFlare() {
        throw new RuntimeException();
    }
}
