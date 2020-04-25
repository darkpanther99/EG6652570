package proto;

import proto.model.GameObserver;
import proto.model.Tile;

public class MessagePrinter implements GameObserver {


    private Proto proto;
    public MessagePrinter(Proto p) {
        proto = p;
    }


    /**
     * Game Over üzenet kiírása, majd proto leállítás.
     */
    @Override
    public void gameOver() {
        System.out.println("Game Over!");
        proto.stop();

    }
    /**
     * Victory üzenet kiírása, majd proto leállítás.
     */
    @Override
    public void victory() {
        System.out.println("Victory!");
        proto.stop();
    }
    /**
     * Egy mező teherbírásának kiírása.
     * @param t: A megvizsgálandó mező
     */
    @Override
    public void explore(Tile t) {
        // FIXME(Mark): Majd ha Gabor megirta
        // System.out.printf(t.getWeightLimit());

    }
}
