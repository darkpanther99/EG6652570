package model;

public class Rope implements Item {
	public void GiveTo(Player p) {
		p.SetRescueStrategy(new RopeRescue());
	}
}
