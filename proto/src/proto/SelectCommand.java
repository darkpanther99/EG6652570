package proto;

public class SelectCommand implements Command {
    private final String type;
    private final int index;

    public SelectCommand(String type, int index) {
        this.type = type;
        this.index = index;
    }

    @Override
    public void execute(Proto state) throws ProtoException {
        try {
            if (type.contentEquals("tile")) state.selectTile(state.game.getTile(index));
            else if (type.contentEquals("polarbear")) state.selectBear(state.game.getBear(index));
            else if (type.contentEquals("player")) state.selectPlayer(state.game.getPlayer(index));
            else {
                throw new ProtoException("Sanity check failed");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ProtoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public String toString() {
        return "select " + type + " " + index;
    }
}
