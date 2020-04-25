package proto;

public class SelectCommand implements Command {
    private String type;
    private int index;

    public SelectCommand(String type, int index) {
        this.type = type;
        this.index = index;
    }

    @Override
    public void execute(Proto state) {
        if (type.contentEquals("tile")) state.selectTile(state.game.getTile(index));
        else if (type.contentEquals("polarbear")) state.selectBear(state.game.getBear(index));
        else if (type.contentEquals("player")) state.selectPlayer(state.game.getPlayer(index));
        else {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "select " + type + " " + index;
    }
}
