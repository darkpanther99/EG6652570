package proto.model;

public class ShovelDig implements DigStrategy {
    private boolean lastUsed;

    public boolean dig(Tile t) {
        throw new RuntimeException();
    }
}
