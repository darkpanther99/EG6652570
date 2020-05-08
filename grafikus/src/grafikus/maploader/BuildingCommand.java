package grafikus.maploader;

import grafikus.model.Igloo;
import grafikus.model.Tent;

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
     * @throws MapLoaderException
     */
    @Override
    public void execute(MapLoader state) throws MapLoaderException {
        if (!state.hasSelectedTile()) throw new MapLoaderException("There is no selected tile!");
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