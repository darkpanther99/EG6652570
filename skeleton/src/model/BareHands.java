package model;

public class BareHands implements DigStrategy {
	
	public boolean Dig(Tile t) {
		t.DecrementSnow();
		return true;
	}
	
}
