package model;

public class Part implements Item {
	public void GiveTo(Player p) {
		p.GetPartStore().Gain(1);
		p.RemoveFromInventory(this);
	}
}
