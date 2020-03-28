package skeleton.model;

import static skeleton.Logger.*;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Player {
    protected int bodyTemp;
    protected int energy;
    protected Game game;
    protected DigStrategy digStrategy;
    protected RescueStrategy rescueStrategy;
    protected WaterResistanceStrategy waterResistanceStrategy;
    protected FoodStore foodStore;
    protected PartStore partStore;
    protected Collection<Item> inventory = new ArrayList<Item>();
    protected Tile currentTile;

    Player() {
        setDisplayName(inventory, "inventory");
    }

    public int getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(int bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public DigStrategy getDigStrategy() {
        return digStrategy;
    }

    public void setDigStrategy(DigStrategy digStrategy) {
        this.digStrategy = digStrategy;
    }

    public RescueStrategy getRescueStrategy() {
        return rescueStrategy;
    }

    public void setRescueStrategy(RescueStrategy rescueStrategy) {
        this.rescueStrategy = rescueStrategy;
    }

    public WaterResistanceStrategy getWaterResistanceStrategy() {
        return waterResistanceStrategy;
    }

    public void setWaterResistanceStrategy(WaterResistanceStrategy waterResistanceStrategy) {
        this.waterResistanceStrategy = waterResistanceStrategy;
    }

    public FoodStore getFoodStore() {
        logMethodCall(this);
        logMethodReturn(foodStore);
        return foodStore;
    }

    public void setFoodStore(FoodStore foodStore) {
        this.foodStore = foodStore;
    }

    public PartStore getPartStore() {
        return partStore;
    }

    public void setPartStore(PartStore partStore) {
        this.partStore = partStore;
    }

    public Collection<Item> getInventory() {
        return inventory;
    }

    public void setInventory(Collection<Item> inventory) {
        this.inventory = inventory;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public void AddToInventory(Item i) {
        logMethodCall(this, i);
        logMethodReturn();
        inventory.add(i);
    }

    public void DecrementEnergy() {
        logMethodCall(this);
        logMethodReturn();

        if (energy > 0) energy--;
    }

    public void IncrementBodyTemp() {
        bodyTemp++;
    }

    public void DecrementBodyTemp() {
        bodyTemp--;
    }

    public void Chill() {
        logMethodCall(this);
        logMethodReturn();

        DecrementBodyTemp();
        if (bodyTemp <= 0) {
            game.GameOver();
        }
    }

    public void PickUp() {
        logMethodCall(this);
        if (!prompt("Van elég energiája?", true)) {
            logMethodReturn();
            return;
        }
        DecrementEnergy();
        Item i = currentTile.TakeItem();
        AddToInventory(i);
        i.GiveTo(this);
        logMethodReturn();
    }

    public void Equip(int inventorySlot) {
        // @TODO(boti)
    }

    public void PlaceOn(Tile t) {
        logMethodCall(this, t);
        logMethodReturn();
        currentTile = t;
    }

    public void Step(int direction) {
        logMethodCall(this, direction);
        if (energy <= 0) return; // TODO Prompt

        DecrementEnergy();
        currentTile.StepOff(this);
        currentTile = currentTile.neighborAt(direction);
        currentTile.StepOn(this);
        logMethodReturn();
    }

    public void ResistWater() {
        waterResistanceStrategy.Chill(this);
    }

    public void EatFood() {
        foodStore.Feed(this);
    }

    public void ToFoodStore() {
    }

    public void Dig() {
        if (energy <= 0) return;

        if (digStrategy.Dig(currentTile)) {
            DecrementEnergy();
        }
    }

    public void RescueTeammate(int direction) {
        if (energy <= 0) return;

        DecrementEnergy();

        Tile neighbor = currentTile.neighborAt(direction);
        rescueStrategy.Rescue(neighbor, currentTile);
    }

    public void AssembleFlare() {
    }

    public void RemoveFromInventory(Item p) {
        logMethodCall(this, p);
        inventory.remove(p);
        logMethodReturn();
    }
}
