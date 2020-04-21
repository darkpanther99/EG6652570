package proto.model;

public class BreakingShovel implements Item {
    private BreakingShovelDig instance;
    public void GiveTo(Player p) {
        throw new RuntimeException();
    }
}
