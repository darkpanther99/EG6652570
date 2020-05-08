package grafikus.model;

public class PartStore {
    /**
     * Tárolja hány darab alkatrész van belole a játékosnál
     */
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Megno az alkatrészek száma, ami a játékosnál van.
     *
     * @param n db al nő
     */
    public void gain(int n) {
        count += n;
    }

    public void gain(PartStore ps) {
        if (ps != this) {
            this.gain(ps.getCount());
            ps.setCount(0);
        }
    }
}
