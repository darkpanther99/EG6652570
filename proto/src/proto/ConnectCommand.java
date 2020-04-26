package proto;

import proto.model.Game;
import proto.model.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConnectCommand implements Command {

    private final List<Integer> indices;

    public ConnectCommand(List<Integer> i) {
        indices = new ArrayList<>(i);
    }

    public ConnectCommand(Tile t, Game g) {
        indices = new ArrayList<>();
        Map<Integer, Tile> n = t.getNeighbors();
        for (Map.Entry<Integer, Tile> entry : n.entrySet()) {
            Tile tile = entry.getValue();
            for (int i = 0; i < g.getIceField().size(); i++) {
                if (g.getIceField().get(i) == tile) {
                    indices.add(i);
                    i = g.getIceField().size();

                }
            }
        }
    }

    @Override
    public void execute(Proto state) throws ProtoException {
        int j = 0;
        for (int i : indices) {
            state.getSelectedTile().addNeighbor(state.game.getIceField().get(i), j);
            j++;
        }
    }

    @Override
    public String toString() {
        if (!indices.isEmpty()) {
            StringBuilder res = new StringBuilder("connect");
            for (int i : indices) {
                res.append(" ").append(i);
            }
            return res.toString();

        }
        return "";
    }
}
