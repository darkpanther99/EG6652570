package proto;

public class DigCommand implements Command {
    @Override
    public void execute(Proto state) throws Exception {
        state.getSelectedPlayer().dig();
    }

    @Override
    public String toString() {
        return "dig";
    }
}
