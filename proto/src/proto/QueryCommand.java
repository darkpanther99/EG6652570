package proto;

// Ezzel az osztállyal sokkal több munka lesz, mint a többivel!

import proto.model.*;

import java.util.ArrayList;
import java.util.List;

public class QueryCommand implements Command {
    private Proto state;

    @Override
    public void execute(Proto state) {
        List<Command> commands = new ArrayList<>(makeCommands(state.game));
        for (Command c : commands) {
            if (c.toString().length() > 0)
                System.out.println(c.toString());
        }
    }

    @Override
    public String toString() {
        return "query";
    }

    private List<Command> makeCommands(Game game) {
        List<Command> result = new ArrayList<Command>();
        for (Tile t : game.getIceField()) {
            result.add(makeTileCommand(t));
            //result.add(makeSelectTileCommand(t, game));

            if (!(t.getShelter() instanceof BareIce)) {
                result.add(makeBuildingCommand(t));
            }
            if (!(t.getItem() instanceof Empty)) {
                result.add(makeItemCommand(t.getItem(), 1));
            }
            for (Entity e : t.getOccupants()) {
                result.add(makeEntityCommand(e));
                if (e instanceof Player) {
                    Player p = (Player) e;
                    listPlayerItems(p, result);
                }
            }

        }
        for (Tile t : game.getIceField()) {
            if (t.getNeighbors().size() > 0) {
                result.add(makeSelectTileCommand(t, game));
                result.add(makeConnectCommand(t, game));
            }
        }

        return result;
    }

    private void listPlayerItems(Player p, List<Command> result) {
        if (p.getBuildStrategy() != null && p.getBuildStrategy().getCount() > 0) {
            result.add(new ItemCommand("tentkit", p.getBuildStrategy().getCount()));
        }
        if (p.getFoodStore().getCount() > 0) {
            result.add(new ItemCommand("food", p.getFoodStore().getCount()));
        }
        if (p.getPartStore().getCount() > 0) {
            result.add(new ItemCommand("part", p.getPartStore().getCount()));
        }

        boolean hasRope = false, hasShovel = false, hasScuba = false, hasBreakingShovel = false;

        if (p.getRescueStrategy() != null && p.getRescueStrategy() instanceof RopeRescue) {
            result.add(new ItemCommand("rope"));
            hasRope = true;
        }
        if (p.getWaterResistanceStrategy() != null && p.getWaterResistanceStrategy() instanceof ScubaWearing) {
            result.add(new ItemCommand("scubagear"));
            hasScuba = true;
        }
        if (p.getDigStrategy() instanceof ShovelDig) {
            result.add(new ItemCommand("shovel"));
            hasShovel = true;
        }
        if (p.getDigStrategy() instanceof BreakingShovelDig) {
            BreakingShovelDig bsd = (BreakingShovelDig) (p.getDigStrategy());
            result.add(new ItemCommand("shovel", 1, bsd.getDurability()));
            hasBreakingShovel = true;
        }

        List<ItemCommand> inventoryCommands = new ArrayList<>();
        for (Item i : p.getInventory()) {
            if (i instanceof Rope && hasRope) {
                hasRope = false;
                continue;
            }
            if (i instanceof ScubaGear && hasScuba) {
                hasScuba = false;
                continue;
            }
            if (i instanceof Shovel && hasShovel) {
                hasShovel = false;
                continue;
            }
            if (i instanceof BreakingShovel && hasBreakingShovel) {
                hasBreakingShovel = false;
                continue;
            }
            if (!(i instanceof Food) && !(i instanceof TentKit) && !(i instanceof Part))
                inventoryCommands.add(makeItemCommand(i, 1));
        }

        if (inventoryCommands.size() > 0) {
            result.add(new EquipCommand());
            result.addAll(inventoryCommands);
        }
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
            return new EntityCommand("eskimo", ((Eskimo) e).getBodyTemp(), ((Eskimo) e).getEnergy());
        else if (e instanceof PolarExplorer)
            return new EntityCommand("polarexplorer", ((PolarExplorer) e).getBodyTemp(), ((PolarExplorer) e).getEnergy());
        else return new EntityCommand("polarbear");
    }

    private ItemCommand makeItemCommand(Item i, int c) {
        if (i instanceof BreakingShovel) {
            return new ItemCommand("shovel", c, ((BreakingShovel) i).getInstance().getDurability());
        }
        return new ItemCommand(i.getClass().getSimpleName().toLowerCase(), c);
    }
}
