package proto;

// Ezzel az osztállyal sokkal több munka lesz, mint a többivel!

import proto.model.*;

import java.util.ArrayList;
import java.util.List;

public class QueryCommand implements Command {
    private Proto state;

    @Override
    public void execute(Proto state) {
        throw new RuntimeException();
    }

    @Override
    public String toString() {
        return "query";
    }

    private List<Command> makeCommands(Game game) {
        List<Command> result = new ArrayList<Command>();
        for (Tile t : game.getIceField()) {
            result.add(makeTileCommand(t));
            if (!(t.getShelter() instanceof BareIce)) {
                result.add(makeBuildingCommand(t));
            }
            if (!(t.getItem() instanceof Empty)) {
                result.add(makeItemCommand(t.getItem().getClass().getSimpleName().toLowerCase(), -1));
            }
            for (Entity e : t.getOccupants()) {
                result.add(makeEntityCommand(e));
                if (e instanceof Player) {
                    Player p = (Player) e;
                    result.add(makePlayerCommand(p));
                    result.addAll(listPlayerEquippedItems(p));
                    // TODO(Mark): add "equip all" command to result;
                    for (Item i : p.getInventory()) {
                        result.add(makeItemCommand(i.getClass().getSimpleName().toString().toLowerCase(), -1));
                    }
                }
            }
        }
        for (Tile t : game.getIceField()) {
            result.add(makeSelectTileCommand(t, game));
            result.add(makeConnectCommand(t, game));
        }

        return result;
    }

    private List<ItemCommand> listPlayerEquippedItems(Player p) {
        List<ItemCommand> result = new ArrayList<ItemCommand>();
        if (p.getBuildStrategy().getCount() > 0) {
            result.add(makeItemCommand("tentkit", p.getBuildStrategy().getCount()));
        }
        if (p.getFoodStore().getCount() > 0) {
            result.add(makeItemCommand("food", p.getFoodStore().getCount()));
        }
        if (p.getPartStore().getCount() > 0) {
            result.add(makeItemCommand("part", p.getPartStore().getCount()));
        }
        if (p.getRescueStrategy() instanceof RopeRescue) {
            result.add(makeItemCommand("rope", -1));
        }
        if (p.getWaterResistanceStrategy() instanceof ScubaWearing) {
            result.add(makeItemCommand("scubagear", -1));
        }
        if (p.getDigStrategy() instanceof ShovelDig) {
            result.add(makeItemCommand("shovel", -1));
        }
        if (p.getDigStrategy() instanceof BreakingShovelDig) {
            BreakingShovelDig bsd = (BreakingShovelDig) (p.getDigStrategy());
            result.add(makeItemCommand("breakingshovel", bsd.getDurability()));
        }

        return result;
    }

    private TileCommand makeTileCommand(Tile t) {
        return new TileCommand(t.getSnow(), t.getWeightLimit());
    }

    private BuildingCommand makeBuildingCommand(Tile t) {
        return new BuildingCommand(
                (t.getShelter() instanceof Tent) ? "tent" : (t.getShelter() instanceof Igloo) ? "igloo" : ""
        );
    }

    private ConnectCommand makeConnectCommand(List<Integer> i) {
        return new ConnectCommand(i);
    }

    private ConnectCommand makeConnectCommand(Tile t, Game game) {
        return new ConnectCommand(t, game);
    }


    private SelectCommand makeSelectTileCommand(Tile t, Game game) {
        int index = -2;
        for (int i = 0; i < game.getIceField().size(); i++) {
            if (game.getIceField().get(i) == t) {
                index = i;
                i = game.getIceField().size();
            }
        }
        return new SelectCommand("tile", index);
    }

    private EntityCommand makeEntityCommand(Entity e) {
        if (e instanceof Eskimo)
            return new EntityCommand("eskikmo", ((Eskimo) e).getBodyTemp(), ((Eskimo) e).getEnergy());
        else if (e instanceof PolarExplorer)
            return new EntityCommand("polarexplorer", ((Eskimo) e).getBodyTemp(), ((Eskimo) e).getEnergy());
        else return new EntityCommand("polarbear");
    }

    private Command makePlayerCommand(Player p) {
        return makeEntityCommand(p);
    }


    private ItemCommand makeItemCommand(String i, int c) {
        ItemCommand ic = new ItemCommand(i);
        ic.count = c;
        return ic;
    }


}
