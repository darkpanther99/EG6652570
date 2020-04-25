package proto;

import proto.model.*;

public class StormCommand implements Command {
    @Override
    public void execute(Proto state) {
        for(Tile t : state.game.tiles) {
            t.chillStorm();
        }
    }

    @Override
    public String toString() {
        return "storm";
    }
}
