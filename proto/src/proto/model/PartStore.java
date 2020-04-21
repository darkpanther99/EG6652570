package proto.model;

public class PartStore {
    private int count = 0;
    public void gain(int n) {
        count += n;
    }

    public void gain(PartStore ps) {
        throw new RuntimeException();
    }
}
