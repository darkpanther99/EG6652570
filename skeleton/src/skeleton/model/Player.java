package skeleton.model;

import skeleton.Logger;

public abstract class Player {
    protected int bodyTemp;
    protected int energy;
    protected Game game;
    protected DigStrategy digStrategy;
    protected RescueStrategy rescueStrategy;
    protected WaterResistanceStrategy waterResistanceStrategy;
    protected FoodStore foodStore;
    protected PartStore partStore;
    protected Item inventory;
    protected Tile currentTile;

    public void DecrementEnergy() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn();
    }

    public void IncrementBodyTemp() {
    }

    public void Chill() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn();
    }

    public void PickUp() {
    }

    public void Equip(int inventorySlot) {
    }

    public void PlaceOn(Tile t) {
        Logger.logMethodCall(this, t);
        Logger.logMethodReturn();
    }

    public void Step(int direction) {
    }

    public void ResistWater() {
    }

    public void EatFood() {
    }

    public void ToFoodStore() {
    }

    public void Dig() {
    }

    public void RescueTeammate(int direction) {
    }

    public void AssembleFlare() {
    }

    public void RemoveFromInventory(Part p) {
        Logger.logMethodCall(this, p);
        Logger.logMethodReturn();
    }

    public void SetEnergy(int n) {
        Logger.logMethodCall(this);
        Logger.logMethodReturn();
    }

    public void SetRescueStrategy(RescueStrategy rs) {
        Logger.logMethodCall(this, rs);
        Logger.logMethodReturn();
    }

    public void SetWaterResistanceStrategy(WaterResistanceStrategy wrs) {
        Logger.logMethodCall(this, wrs);
        Logger.logMethodReturn();
    }

    public PartStore GetPartStore() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(partStore);
        return partStore;
    }
}
