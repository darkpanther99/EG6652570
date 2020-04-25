package proto;

public class StepCommand implements Command {
    private int direction;

    public StepCommand(int direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Proto state) {
        state.selectedPlayer.step(direction);
    }

    @Override
    public String toString() {
        return "step " + direction;
    }
}
