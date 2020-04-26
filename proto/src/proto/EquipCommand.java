package proto;

import proto.model.*;

public class EquipCommand implements Command {
    private int index;

    public EquipCommand(int index) {
        this.index = index;
    }

    public EquipCommand() {
        this(-1);
    }

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
