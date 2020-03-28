package skeleton.model;

import skeleton.Logger;

public class FoodStore {
	private int count = 0;
	public void Feed(Player p) {
	}
	
	public void DecrementCount() {
	}
	
	public void Gain() {
		Logger.logMethodCall(this);
		Logger.logMethodReturn();
	}
}
