package proto.model;

public class BreakingShovelDig implements DigStrategy {
    private boolean lastUsed;
    private int durability;
    public boolean Dig(Tile t) {
        throw new RuntimeException();
    }
}
