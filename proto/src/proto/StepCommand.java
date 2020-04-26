package proto;

public class StepCommand implements Command {
    private int direction;

    public StepCommand(int direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Proto state) throws ProtoException {
        try {
            state.getSelectedPlayer().step(direction);
        } catch(NullPointerException e) {
            throw new ProtoException("Nincs jatekos kivalasztva", e.getCause());
        }
    }

    @Override
    public String toString() {
        return "step " + direction;
    }
}
