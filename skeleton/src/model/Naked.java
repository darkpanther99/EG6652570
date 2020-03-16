package model;

public class Naked implements WaterResistanceStrategy {
	public void Chill(Player p) {
		p.SetEnergy(0);
		p.Chill();
	}
}
