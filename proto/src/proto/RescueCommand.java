package proto;

public class RescueCommand implements Command {
    private int direction;

    public RescueCommand(int direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Proto state) throws Exception {
        state.getSelectedPlayer().rescueTeammate(direction);
    }

    @Override
    public String toString() {
        return "rescue " + direction;
    }
}
