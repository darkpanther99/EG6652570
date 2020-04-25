package proto;

public class TileCommand implements Command {
    private int snow;
    private int weightLimit;

    public TileCommand(int snow, int weightLimit) {
        this.snow = snow;
        this.weightLimit = weightLimit;
    }

    @Override
    public void execute(Proto state) {
        state.createTile(snow, weightLimit);
        state.selectTile(state.game.tiles.size() - 1);
    }

    @Override
    public String toString() {
        return "tile " + snow + " " + weightLimit;
    }
}
