package proto;

public class BuildCommand implements Command {
    @Override
    public void execute(Proto state) throws ProtoException {
        state.getSelectedPlayer().build();
    }

    @Override
    public String toString() {
        return "build";
    }
}
