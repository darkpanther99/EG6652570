package proto;

public class AssembleCommand implements Command {
    @Override
    public void execute(Proto state) throws Exception {
        state.getSelectedPlayer().assembleFlare();
    }

    @Override
    public String toString() {
        return "assemble";

    }
}
