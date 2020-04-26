package proto;

public class RescueCommand implements Command {
    private final int direction;

    public RescueCommand(int direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Proto state) throws ProtoException {
        try {
            state.getSelectedPlayer().rescueTeammate(direction);
        } catch (NullPointerException e) {
            throw new ProtoException("Nincs jatekos kivalasztva", e.getCause());
        }
    }

    @Override
    public String toString() {
        return "rescue " + direction;
    }
}
