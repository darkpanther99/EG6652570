package proto.model;

public class Part implements Item {
    /**
     * A játékos tárolójába kerül egy darab a rakétapisztolyból.
     *
     * @param p játékos
     */
    public void giveTo(Player p) {
        p.getPartStore().gain(1);
        p.removeFromInventory(this);
    }
}
