package proto;

public class AssembleCommand implements Command {
    @Override
    public void execute(Proto state) throws ProtoException {
        state.getSelectedPlayer().assembleFlare();
    }

    @Override
    public String toString() {
        return "assemble";

    }
}
