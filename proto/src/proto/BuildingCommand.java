package proto;

import proto.model.Igloo;
import proto.model.Tent;

/**
 * Épület definíciós parancs.
 */
public class BuildingCommand implements Command {

    /**
     * Az épület típusa
     */
    private final String type;

    public BuildingCommand(String t) {
        type = t;
    }

    /**
     * A kiválasztott mezőre épít egy épületet.
     * @param state
     * @throws ProtoException
     */
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

    /**
     * Így jelenik meg a parancs a konzolon.
     * @return A parancs String
     */
    @Override
    public String toString() {
        return "building " + type;
    }
}