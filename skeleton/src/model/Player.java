package model;

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
	}
	
	public void IncrementBodyTemp() {
	}
	
	public void Chill() {
	}
	
	public void PickUp() {
	}
	
	public void Equip(int inventorySlot) {
	}
	
	public void PlaceOn(Tile t) {
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

	}
	public void SetEnergy(int n) {

	}
	public void SetRescueStrategy(RescueStrategy rs) {

	}
	public void SetWaterResistanceStrategy(WaterResistanceStrategy wrs) {

	}
	public PartStore GetPartStore() {
		return partStore;
	}
}
