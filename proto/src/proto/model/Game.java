package proto.model;

import java.util.List;

public class Game {
    private List<Player> players;
    private List<Tile> iceField;
    private List<PolarBear> bears;
    private List<GameObserver> observers;

    public void turn() {
        throw new RuntimeException();
    }

    public void victory() {
        throw new RuntimeException();
    }

    public void gameOver() {
        throw new RuntimeException();
    }

    private void addTile(Tile t) {
        iceField.add(t);
    }

    private void addPlayer(Player p) {
        players.add(p);
    }

    public void addPolarBear(PolarBear pb) {
        bears.add(pb);
    }

    public PolarExplorer createPolarExplorer() {
        throw new RuntimeException();
    }

    public Eskimo createEskimo() {
        throw new RuntimeException();
    }

    public PolarBear createPolarBear() {
        throw new RuntimeException();
    }

    public Tile createTile(int snow, int weightLimit) {
        throw new RuntimeException();
    }
}
