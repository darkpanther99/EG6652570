package proto.model;

public class PartStore {
    private int count = 0;
    public void Gain(int n) {
        count += n;
    }

    public void Gain(PartStore ps) {
        throw new RuntimeException();
    }
}
