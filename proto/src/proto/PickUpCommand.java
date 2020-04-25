package proto;

public class PickUpCommand implements Command {
    @Override
    public void execute(Proto state) {
        state.selectedPlayer.pickUp();
    }

    @Override
    public String toString() {
        return "pickup";
    }
}
