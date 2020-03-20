package model;

public class Eskimo extends Player {
	public void BuildIgloo() {
		Igloo c = new Igloo();
		currentTile.setChillStormStrategy(c);
	}
}
