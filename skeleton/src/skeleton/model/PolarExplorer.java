package skeleton.model;

import skeleton.Logger;

public class PolarExplorer extends Player {
	public int Examine(int direction) {
		Logger.logMethodCall(this, direction);
		if(energy > 0){
			int w = currentTile.NeighborAt(direction).getWeightLimit();
			DecrementEnergy();
			Logger.logMethodReturn(w);
			return w;
		}
		Logger.logMethodReturn(-1);
		return -1;
	}
}
