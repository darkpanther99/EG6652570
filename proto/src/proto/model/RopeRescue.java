package proto.model;

public class RopeRescue implements RescueStrategy {
    public void rescue(Tile water, Tile land) {
        throw new RuntimeException();
    }
}
