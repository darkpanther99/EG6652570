package proto;

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
        if (index > -1) {
            state.getSelectedPlayer().equip(index);
        } else {
            for (int i = 0; i < state.getSelectedPlayer().getInventory().size(); i++) {
                state.getSelectedPlayer().equip(i);
            }
        }
    }

    @Override
    public String toString() {
        if (index > -1) return "equip " + index;
        else return "equip all";
    }
}
