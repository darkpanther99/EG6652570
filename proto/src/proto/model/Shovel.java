package proto.model;

public class Shovel implements Item {
    private ShovelDig instance;

    public void giveTo(Player p) {
        throw new RuntimeException();
    }
}
