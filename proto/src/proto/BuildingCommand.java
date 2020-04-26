package proto;

import proto.model.Igloo;
import proto.model.Tent;

public class BuildingCommand implements Command {
    private final String type;

    public BuildingCommand(String t) {
        type = t;
    }

    @Override
    public void execute(Proto state) throws ProtoException {
        if (!state.hasSelectedTile()) throw new ProtoException("There is no selected tile!");
        if (type.equals("igloo")) {
            state.getSelectedTile().setShelter(new Igloo());
        }
        if (type.equals("tent")) {
            state.getSelectedTile().setShelter(new Tent());
        }

    }

    @Override
    public String toString() {
        return "building " + type;
    }
}