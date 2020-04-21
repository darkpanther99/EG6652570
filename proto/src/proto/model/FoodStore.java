package proto.model;

public class FoodStore {
    private int count = 0;
    public void Feed(Player p) {
        throw new RuntimeException();
    }

    private void DecrementCount() {
        count--;
    }

    public void Gain() {
        count++;
    }
}
