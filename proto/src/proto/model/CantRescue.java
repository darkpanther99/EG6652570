package proto.model;

public class CantRescue implements RescueStrategy {
    public void Rescue(Tile water, Tile land) {
        throw new RuntimeException();
    }
}
