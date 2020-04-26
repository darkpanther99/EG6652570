package proto;

import proto.model.Igloo;
import proto.model.Tent;

public class BuildingCommand implements Command {
    private String type;
    public BuildingCommand(String t) {
        type = t;
    }

    @Override
    public void execute(Proto state) throws ProtoException {
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