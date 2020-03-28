package skeleton.model;

import static skeleton.Logger.*;

public class PartStore {
    private int count = 0;

    public void Gain(int n) {
        logMethodCall(this);
        this.setCount(this.getCount() + n);
        logMethodReturn();
    }

    public void Gain(PartStore ps) {
        logMethodCall(this, ps);
        if (ps != this) {
            this.Gain(ps.getCount());
            ps.setCount(0);
        }
        logMethodReturn();
    }

    public void setCount(int count) {
        logMethodCall(this);
        this.count = count;
        logMethodReturn();
    }

    public int getCount() {
        logMethodCall(this);
        logMethodReturn(count);
        return count;
    }
}
