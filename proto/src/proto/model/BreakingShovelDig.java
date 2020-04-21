package proto.model;

public class BreakingShovelDig implements DigStrategy {
    private boolean lastUsed;
    private int durability;
    public boolean dig(Tile t) {
        throw new RuntimeException();
    }
}
