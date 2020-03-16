package model;

public class BareIce implements ChillStormStrategy {
	public void Chill(Tile t) {
		for (Player p : t.GetOccupants()) {
			p.Chill();
		}
	}
}
