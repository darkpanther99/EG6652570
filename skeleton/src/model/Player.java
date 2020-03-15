package model;

import java.util.Collection;

public abstract class Player {
	private int bodyTemp;
	private int energy;
	private Game game;
	private DigStrategy digStrategy;
	private RescueStrategy rescueStrategy;
	private WaterResistanceStrategy waterResistanceStrategy;
	private FoodStore foodStore;
	private PartStore partStore;
	private Collection<Item> inventory;

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
}
