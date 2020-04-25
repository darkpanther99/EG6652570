package proto;

public class TurnCommand implements Command {
    @Override
    public void execute(Proto state) {
        state.game.turn();
    }

    @Override
    public String toString() {
        return "turn";
    }
}