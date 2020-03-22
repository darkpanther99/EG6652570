package skeleton.model;

import java.util.ArrayList;

public class Sea implements ChillWaterStrategy {
	public void Chill(Tile t) {
		ArrayList<Player> occupants = t.getOccupants();
		
		for(Player p : occupants) {
			p.ResistWater();
		}
	}
}
