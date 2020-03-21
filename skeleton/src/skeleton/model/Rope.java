package skeleton.model;

import skeleton.Logger;

public class Rope implements Item {
	public void GiveTo(Player p) {
		Logger.logMethodCall(this, p);
		p.SetRescueStrategy(new RopeRescue());
		Logger.logMethodReturn();
	}
}
