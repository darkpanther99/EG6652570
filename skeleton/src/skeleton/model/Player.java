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
    	if(energy <= 0) return;
    	
    	currentTile.getItem().GiveTo(this);
    	// @Q(boti): -A player felelossege, hogy eltavolitsa az itemet a tile-rol?
    	//           -Lehet tobb item a tile-on?
    	currentTile.setItem(null);     	
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

    public void RemoveFromInventory(Part p) {
        Logger.logMethodCall(this, p);
        Logger.logMethodReturn();
    }

    public void SetEnergy(int n) {
        Logger.logMethodCall(this);
        Logger.logMethodReturn();
    }

    public void SetDigStrategy(DigStrategy ds) {
    	digStrategy = ds;
    }
    
    public void SetRescueStrategy(RescueStrategy rs) {
        Logger.logMethodCall(this, rs);
        Logger.logMethodReturn();
        
        rescueStrategy = rs;
    }

    public void SetWaterResistanceStrategy(WaterResistanceStrategy wrs) {
        Logger.logMethodCall(this, wrs);
        Logger.logMethodReturn();
        
        waterResistanceStrategy = wrs;
    }

    public PartStore GetPartStore() {
        Logger.logMethodCall(this);
        Logger.logMethodReturn(partStore);
        return partStore;
    }
}
