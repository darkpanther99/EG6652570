package proto;

import proto.model.*;

public class ItemCommand implements Command {
    private String type;
    public int count = 1;
    public int durability = -1;

    public ItemCommand(String type) {
        this.type = type;
    }

    @Override
    public void execute(Proto state) {
        if(state.selectedTile != null && count > 1) {
            throw new RuntimeException();
        }

        if(state.selectedTile == null && state.selectedPlayer == null) {
            throw new RuntimeException();
        }

        Item item;
        for(int i = 0; i < count; i++) {
            if(type.contentEquals("empty")) item = new Empty();
            else if(type.contentEquals("food")) item = new Food();
            else if(type.contentEquals("part")) item = new Part();
            else if(type.contentEquals("scubagear")) item = new ScubaGear();
            else if(type.contentEquals("rope")) item = new Rope();
            else if(type.contentEquals("tentkit")) item = new TentKit();
            else if(type.contentEquals("shovel")) {
                if(durability > -1) item = new BreakingShovel(durability);
                else item = new Shovel();
            } else {
                throw new RuntimeException();
            }
        }

        if(state.selectedTile != null) {
            state.selectedTile.setItem(item);
        }
        if(state.selectedPlayer != null) {
            state.selectedPlayer.addToInventory(item);
        }
    }

    @Override
    public String toString() {
        if(count > 1) {
            if(type.contentEquals("shovel") && durability > -1) {
                return "item shovel " + count + " durability " + durability;
            } else {
                return "item " + type + " " + count;
            }
        } else {
            if(type.contentEquals("shovel") && durability > -1) {
                return "item shovel durability " + durability;
            } else {
                return "item " + type;
            }
        }
    }
}
