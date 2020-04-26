package proto;

import proto.model.Tile;

public class TileCommand implements Command {
    private final int snow;
    private final int weightLimit;

    public TileCommand(int snow, int weightLimit) {
        this.snow = snow;
        this.weightLimit = weightLimit;
    }

    @Override
    public void execute(Proto state) {
        Tile t = state.game.createTile(snow, weightLimit);
        state.selectTile(t);
    }

    @Override
    public String toString() {
        return "tile " + snow + " " + ((weightLimit < 999) ? weightLimit : "*");
    }
}