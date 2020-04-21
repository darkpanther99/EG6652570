package proto.model;

public interface GameObserver {
    void gameOver();
    void victory();
    void explore(Tile t);
}
