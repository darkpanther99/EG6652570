package proto;

import proto.model.Player;
import proto.model.PolarBear;
import proto.model.PolarExplorer;

public class EntityCommand implements Command {
    String type;
    int playerBodyHeat;
    int playerEnergy;

    public EntityCommand(String t) {
        type = t;
        playerBodyHeat = -1;
        playerEnergy = -1;
    }
    public EntityCommand(String t, int pb) {
        type = t;
        playerBodyHeat = pb;
        playerEnergy = -1;
    }
    public EntityCommand(String t, int pb, int pe) {
        type = t;
        playerBodyHeat = pb;
        playerEnergy = pe;
    }

    @Override
    public void execute(Proto state) throws ProtoException {
        if (type.equals("eskimo") || type.equals("polarexplorer")) {
            Player p;
            if (type.equals("eskimo")) {
                p = state.game.createEskimo();
            }
            else {
                p = state.game.createPolarExplorer();
            }
            if (playerEnergy > -1) {
                p.setEnergy(playerEnergy);
            }
            if (playerBodyHeat > -1) {
                p.setBodyTemp(playerBodyHeat);
            }
            p.placeOn(state.getSelectedTile());
            state.selectPlayer(p);
        } else {
            PolarBear b = state.game.createPolarBear();
            b.placeOn(state.getSelectedTile());
            state.selectBear(b);

        }
    }

    @Override
    public String toString() {
        if (type.contentEquals("eskimo") || type.contentEquals("polarexplorer")) {
            if (playerBodyHeat > -1) {
                if (playerEnergy > -1) {
                    return "entity " + type + " " + playerBodyHeat + " " + playerEnergy;
                }
                else return "entity " + type + " " + playerBodyHeat;
            }
            else return "entity " + type;
        }
        else return "entity polarbear";
    }
}
