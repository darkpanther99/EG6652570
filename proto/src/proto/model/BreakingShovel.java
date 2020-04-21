package proto.model;

public class BreakingShovel implements Item {
    private BreakingShovelDig instance;
    public void giveTo(Player p) {
        throw new RuntimeException();
    }
}
