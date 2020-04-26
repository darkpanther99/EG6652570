package proto;

public class BuildCommand implements Command {
    @Override
    public void execute(Proto state) throws ProtoException {
        if (!state.hasSelectedPlayer()) throw new ProtoException("There is no selected player!");
        state.getSelectedPlayer().build();
    }

    @Override
    public String toString() {
        return "build";
    }
}
