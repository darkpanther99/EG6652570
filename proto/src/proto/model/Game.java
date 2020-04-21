package proto.model;

import java.util.List;

public class Game {
    private List<Player> players;
    private List<Tile> iceField;
    private List<PolarBear> bears;
    private List<GameObserver> observers;

    public void Turn() {
        throw new RuntimeException();
    }

    public void Victory() {
        throw new RuntimeException();
    }

    public void GameOver() {
        throw new RuntimeException();
    }

    private void AddTile(Tile t) {
        throw new RuntimeException();
    }

    private void AddPlayer(Player p) {
        throw new RuntimeException();
    }

    public void AddPolarBear(PolarBear pb) {
        throw new RuntimeException();
    }

    public PolarExplorer CreatePolarExplorer() {
        throw new RuntimeException();
    }

    public Eskimo CreateEskimo() {
        throw new RuntimeException();
    }

    public PolarBear CreatePolarBear() {
        throw new RuntimeException();
    }

    public Tile CreateTile(int snow, int weightLimit) {
        throw new RuntimeException();
    }
}
