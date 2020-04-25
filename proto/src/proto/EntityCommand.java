package proto;

public class EntityCommand implements Command {
    String type;
    int playerBodyHeat;
    int playerEnergy;

    public EntityCommand(String t) {
        type = t;
    }
    public EntityCommand(String t, int pb) {
        type = t;
        playerBodyHeat = pb;
    }
    public EntityCommand(String t, int pb, int pe) {
        type = t;
        playerBodyHeat = pb;
        playerEnergy = pe;
    }

    @Override
    public void execute(Proto state) {
        throw new RuntimeException();
    }

    @Override
    public String toString() {
        if (type.equals("eskimo") || type.equals("polarexplorer")) {
            if (playerBodyHeat > -1) {
                if (playerEnergy > -1) {
                    return "entity " + type + " " + playerBodyHeat + playerEnergy;
                }
                else return "entity " + type + " " + playerBodyHeat;
            }
            else return "entity " + type;
        }
        else return "polarbear";
    }
}
