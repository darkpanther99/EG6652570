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
    public void execute(Proto state) {
        if(index  > -1) {
            state.selectedPlayer.equip(index);
        } else {
            for(int i = 0; i < state.selectedPlayer.getInventory().size(); i++) {
                state.selectedPlayer.equip(i);
            }
        }
    }

    @Override
    public String toString() {
        if(index > -1) return "equip " + index;
        else return "equip all";
    }
}
