package proto;

import proto.model.*;

public class EquipCommand implements Command {
    /**
     * Az inventory index, amivel felruházzuk a játékost
     * -1, ha mindegyikkel felruházzuk
     */
    private int index;

    /**
     * Konstruktor
     * @param index Az inventory index, amivel felruházzuk a játékost. -1, ha mindegyikkel felruházzuk
     */
    public EquipCommand(int index) {
        this.index = index;
    }

    /**
     * Konstruktor
     * index = -1
     */
    public EquipCommand() {
        this(-1);
    }

    /**
     * Lefuttatja a parancsot, ami felruházza a kijelölt játékost.
     * @param state
     * @throws ProtoException Ha nincs kiválasztott játékos, kivételt dob
     */
    @Override
    public void execute(Proto state) throws ProtoException {
        try {
            if (index > -1) {
                state.getSelectedPlayer().equip(index);
            } else {
                for (int i = 0; i < state.getSelectedPlayer().getInventory().size(); i++) {
                    state.getSelectedPlayer().equip(i);
                }
            }
        } catch(NullPointerException e) {
            throw new ProtoException("Nincs jatekos kivalasztva", e.getCause());
        }
    }

    @Override
    public String toString() {
        if (index > -1) return "equip " + index;
        else return "equip all";
    }
}
