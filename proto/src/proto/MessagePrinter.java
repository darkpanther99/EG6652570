package proto;

import proto.model.GameObserver;
import proto.model.Tile;

public class MessagePrinter implements GameObserver {
    @Override
    public void gameOver() {
        throw new RuntimeException();
    }

    @Override
    public void victory() {
        throw new RuntimeException();
    }

    @Override
    public void explore(Tile t) {
        throw new RuntimeException();
    }
}
