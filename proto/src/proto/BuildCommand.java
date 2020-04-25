package proto;

public class BuildCommand implements Command {
    @Override
    public void execute(Proto state) throws Exception {
        state.getSelectedPlayer().build();
    }

    @Override
    public String toString() {
        return "build";
    }
}
