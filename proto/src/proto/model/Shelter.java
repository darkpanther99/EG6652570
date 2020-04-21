package proto.model;

public abstract class Shelter {
    public void chillStorm(Tile t) {
        throw new RuntimeException();
    }

    public void bearAttack(Tile t) {
        throw new RuntimeException();
    }

    // Shelter.break ütközik a break; kulcsszóval...
    public void ruin(Tile t) {
        throw new RuntimeException();
    }
}
