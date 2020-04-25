package proto;

import proto.model.Tile;

public class StormCommand implements Command {
    @Override
    public void execute(Proto state) {
        for (Tile t : state.game.getTiles()) {
            t.chillStorm();
        }
    }

    @Override
    public String toString() {
        return "storm";
    }
}
