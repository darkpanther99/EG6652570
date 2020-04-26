package proto;

import proto.model.Entity;

public class StepCommand implements Command {
    private final int direction;

    public StepCommand(int direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Proto state) throws ProtoException {
        Entity e;
        if (state.hasSelectedPlayer())
            e = state.getSelectedPlayer();
        else if (state.hasSelectedBear())
            e = state.getSelectedBear();
        else throw new ProtoException("Player or bear must be selected");
        if (e.getCurrentTile().getNeighbors().containsKey(direction))
            e.step(direction);
        else throw new ProtoException("Invalid step direction.");
    }

    @Override
    public String toString() {
        return "step " + direction;
    }
}
