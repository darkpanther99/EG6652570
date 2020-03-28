package skeleton.model;

public class Shovel implements Item {
	public void GiveTo(Player p) {
		p.setDigStrategy(new ShovelDig());
	}
}
