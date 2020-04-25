package proto;

public class EatCommand implements Command {
    @Override
    public void execute(Proto state) throws Exception {
        state.getSelectedPlayer().eatFood();
    }

    @Override
    public String toString() {
        return "eat";
    }
}
