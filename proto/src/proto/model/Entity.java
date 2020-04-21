package proto.model;

public class Entity {
    private Tile currentTile;
    public void step(int direction) {
        throw new RuntimeException();
    }

    public void placeOn(Tile t) {
        throw new RuntimeException();
    }

    public void chill() {
       return;
    }

    public void resistWater() {
        return;
    }

    public void bearAttack() {
        return;
    }
}
