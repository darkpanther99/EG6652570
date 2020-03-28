package skeleton.model;

import skeleton.Logger;

public class Food implements Item {
	public void GiveTo(Player p) {
		Logger.logMethodCall(this, p);
		p.getFoodStore().Gain();
		p.RemoveFromInventory(this);
		Logger.logMethodReturn();
	}
}
