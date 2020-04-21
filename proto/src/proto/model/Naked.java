package proto.model;

public class Naked implements WaterResistanceStrategy {
    public void Chill(Player p) {
        throw new RuntimeException();
    }
}
