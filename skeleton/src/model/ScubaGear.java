package model;

public class ScubaGear implements Item {
	public void GiveTo(Player p) {
		p.SetWaterResistanceStrategy(new ScubaWearing());
	}
}
