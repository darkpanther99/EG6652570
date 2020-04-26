package proto;

public class EatCommand implements Command {
    @Override
    public void execute(Proto state) throws ProtoException {
        state.getSelectedPlayer().eatFood();
    }

    @Override
    public String toString() {
        return "eat";
    }
}
