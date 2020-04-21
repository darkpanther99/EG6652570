package proto.model;

public class FoodStore {
    private int count = 0;
    public void feed(Player p) {
        throw new RuntimeException();
    }

    private void decrementCount() {
        count--;
    }

    public void gain() {
        count++;
    }
}
