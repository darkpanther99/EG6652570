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
        if(type.contentEquals("tile")) state.selectTile(state.game.tiles[index]);
        else if(type.contentEquals("polarbear")) state.selectBear(state.game.bears[index]);
        else if(type.contentEquals("player")) state.selectPlayer(state.game.players[index]);
        else {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "select " + type + " " + index;
    }
}
