package skeleton.model;

import skeleton.Logger;

public class PartStore {
    private int count = 0;

    public void Gain(int n) {
        Logger.logMethodCall(this);
        this.setCount(this.getCount() + n);
        Logger.logMethodReturn();
    }

    public void Gain(PartStore ps) {
        Logger.logMethodCall(this, ps);
        if (ps != this) {
            this.Gain(ps.getCount());
            ps.setCount(0);
        }
        Logger.logMethodReturn();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
