package skeleton.model;

import skeleton.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Player {
    protected int bodyTemp;
    protected int energy;
    protected Game game;
    protected DigStrategy digStrategy;
    protected RescueStrategy rescueStrategy;
    protected WaterResistanceStrategy waterResistanceStrategy;
    protected FoodStore foodStore;
    protected PartStore partStore;
    protected Collection<Item> inventory = new ArrayList<Item>(); // TODO: @Boti ellenőrizd, hogy ez collection minden működésében
    protected Tile currentTile;

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
        Logger.logMethodCall(this);
        Logger.logMethodReturn(foodStore);
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

    public void AddToInventory(Item i){
        Logger.logMethodCall(this, i);
        Logger.logMethodReturn();
        inventory.add(i);
    }

    public void DecrementEnergy() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn();
        
        if(energy > 0) energy--;
    }

    public void IncrementBodyTemp() {
    	bodyTemp++;
    }
    
    public void DecrementBodyTemp()
    {
    	bodyTemp--;
    }
    
    public void Chill() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn();
        
        DecrementBodyTemp();
        if(bodyTemp <= 0) {
        	game.GameOver();
        }
    }

    public void PickUp() {
        Logger.logMethodCall(this);
    	if(!Logger.prompt("Van elég energiája?")) {
    	    Logger.logMethodReturn();
    	    return;
        }
    	DecrementEnergy();
    	AddToInventory(currentTile.TakeItem());

        currentTile.getItem().GiveTo(this);
    	// @Q(boti): -A player felelossege, hogy eltavolitsa az itemet a tile-rol?
    	//           -Lehet tobb item a tile-on?
    	currentTile.setItem(null);
        Logger.logMethodReturn();
    }

    public void Equip(int inventorySlot) {
    	// @TODO(boti)
    }

    public void PlaceOn(Tile t) {
        Logger.logMethodCall(this, t);
        Logger.logMethodReturn();
        
        // @BUG(boti): nem kell kivennunk magunkat a mostani tile-bol? (szekvencian nincs rajta)
        currentTile = t;
        t.StepOn(this);
    }

    public void Step(int direction) {
    	if(energy <= 0) return;
    	
    	DecrementEnergy();
    	currentTile.StepOff(this);
    	currentTile = currentTile.NeighborAt(direction);
    	currentTile.StepOn(this);
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
    	if(energy <= 0) return;
    	
		if(digStrategy.Dig(currentTile)) {
			DecrementEnergy();    		
    	}
    }

    public void RescueTeammate(int direction) {
    	if(energy <= 0) return;
    	
    	DecrementEnergy();
    	
    	Tile neighbor = currentTile.NeighborAt(direction);
    	rescueStrategy.Rescue(neighbor, currentTile);
    }

    public void AssembleFlare() {
    }

    public void RemoveFromInventory(Item p) {
        Logger.logMethodCall(this, p);
        inventory.remove(p);
        Logger.logMethodReturn();
    }
}
