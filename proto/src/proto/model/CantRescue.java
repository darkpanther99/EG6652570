package proto.model;

public class CantRescue implements RescueStrategy {
    public void rescue(Tile water, Tile land) {
        throw new RuntimeException();
    }
}
