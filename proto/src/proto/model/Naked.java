package proto.model;

public class Naked implements WaterResistanceStrategy {
    public void chill(Player p) {
        throw new RuntimeException();
    }
}
