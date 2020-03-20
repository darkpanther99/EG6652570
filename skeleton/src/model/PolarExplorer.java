package model;

public class PolarExplorer extends Player {
	public int Examine(int direction) {
		if(energy > 0){
			int w = currentTile.NeighborAt(direction).getWeightLimit();
			DecrementEnergy();
			return w;
		}
		return -1;
	}
}
