package skeleton.model;

import skeleton.Logger;

public class Rope implements Item {
	public void GiveTo(Player p) {
		Logger.logMethodCall(this, p);
		p.setRescueStrategy(new RopeRescue());
		Logger.logMethodReturn();
	}
}
