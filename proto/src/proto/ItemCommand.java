package proto;

import proto.model.*;

public class ItemCommand implements Command {
    private String type;
    public int count;
    public int durability;

    public ItemCommand(String type, int count, int durability) {
        this.type = type;
        this.count = count;
        this.durability = durability;
    }

    public ItemCommand(String type, int count) {
        this(type, count, -1);
    }

    public ItemCommand(String type) {
        this(type, 1);
    }

    @Override
    public void execute(Proto state) throws ProtoException {
        if (!state.hasSelectedPlayer() && state.hasSelectedTile() && count > 1) {
            throw new ProtoException("Mezonek csak 1 itemet lehet adni");
        }

        for (int i = 0; i < count; i++) {
            Item item = null;
            if (type.contentEquals("empty")) item = new Empty();
            else if (type.contentEquals("food")) item = new Food();
            else if (type.contentEquals("part")) item = new Part();
            else if (type.contentEquals("scubagear")) item = new ScubaGear();
            else if (type.contentEquals("rope")) item = new Rope();
            else if (type.contentEquals("tentkit")) item = new TentKit();
            else if (type.contentEquals("shovel")) {
                if (durability > -1) item = new BreakingShovel(durability);
                else item = new Shovel();
            } else {
                throw new ProtoException("Rossz item tipus");
            }

            if (state.hasSelectedPlayer()) {
                state.getSelectedPlayer().addToInventory(item);
                //item.giveTo(state.getSelectedPlayer()); // ez nem való ide
            } else if (state.hasSelectedTile()) {
                state.getSelectedTile().setItem(item);
            } else {
                throw new ProtoException("Nincs mezo/jatekos kivalasztva");
            }
        }
    }

    @Override
    public String toString() {
        if(count <= 0) return "";

        StringBuilder b = new StringBuilder();
        b.append("item " + type);

        if(count > 1) {
            b.append(" " + count);
        }

        if(type.contentEquals("shovel") && durability > -1) {
            b.append(" durability " + durability);
        }

        return b.toString();
    }
}
