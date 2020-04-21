package proto.model;

public interface GameObserver {
    void GameOver();
    void Victory();
    void Explore(Tile t);
}
