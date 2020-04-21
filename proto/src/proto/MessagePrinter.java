package proto;

import proto.model.GameObserver;
import proto.model.Tile;

public class MessagePrinter implements GameObserver {
    @Override
    public void GameOver() {
        throw new RuntimeException();
    }

    @Override
    public void Victory() {
        throw new RuntimeException();
    }

    @Override
    public void Explore(Tile t) {
        throw new RuntimeException();
    }
}
