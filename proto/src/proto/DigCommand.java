package proto;

public class DigCommand implements Command {
    @Override
    public void execute(Proto state) throws ProtoException {
        state.getSelectedPlayer().dig();
    }

    @Override
    public String toString() {
        return "dig";
    }
}
