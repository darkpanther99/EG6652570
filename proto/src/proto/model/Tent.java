package proto.model;

public class Tent extends Shelter {
    public void chillStorm(Tile t) {
        return;
    }

    public void ruin(Tile t) {
        throw new RuntimeException();
    }
}
