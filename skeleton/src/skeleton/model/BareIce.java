package skeleton.model;

public class BareIce implements ChillStormStrategy {
	public void Chill(Tile t) {
		for (Player p : t.getOccupants()) {
			p.Chill();
		}
	}
}
