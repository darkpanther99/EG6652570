package proto.model;

public class Tent extends Shelter {
    public void ChillStorm(Tile t) {
        return;
    }

    public void Break(Tile t) {
        throw new RuntimeException();
    }
}
