package model;

import java.util.List;

public class Tile {
	private int snow;
	private int weightLimit;
	public List<Tile> neighborTiles;
	private ChillStormStrategy chillStormStrategy;
	private ChillWaterStrategy chillWaterStrategy;
	private Item item;

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
