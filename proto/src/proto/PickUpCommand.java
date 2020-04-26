package proto;

public class PickUpCommand implements Command {
    @Override
    public void execute(Proto state) throws ProtoException {
        try {
            state.getSelectedPlayer().pickUp();
        } catch(NullPointerException e) {
            throw new ProtoException("Nincs jatekos kivalasztva", e.getCause());
        }
    }

    @Override
    public String toString() {
        return "pickup";
    }
}
