package grafikus;

import grafikus.model.Game;
import grafikus.model.GameObserver;
import grafikus.model.Tile;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * View komponens.
 * Megjeleníti a pálya négyzetrácsot.
 */
public class View extends JScrollPane implements GameObserver, TileClickListener {
    private final Controller controller;
    /**
     * A cellanégyzet mérete.
     */
    public static final int TILE_SIZE = 128;

    /**
     * A tartalmazott TileView-k.
     */
    private final ArrayList<TileView> tiles;
    private final int rows;
    private final int cols;
    private TileClickListener tcl;
    private final JPanel tilePanel;

    /**
     * @param c    Megkapja a vezérlőt, mint dependency injection.
     * @param rows A modell négyzetrács sorai.
     * @param cols A modell négyzetrács oszlopai
     */
    View(Controller c, int rows, int cols) {
        super();
        this.rows = rows;
        this.cols = cols;
        controller = c;
        tilePanel = new JPanel();
        int width = 10 * TILE_SIZE;
        int height = 7 * TILE_SIZE;
        Dimension d = new Dimension(width, height);

        //setMaximumSize(new Dimension(rows*TileView.s_TileSize, rows*TileView.s_TileSize));
        setMaximumSize(new Dimension(d));
        setPreferredSize((rows * TILE_SIZE > 10 * TILE_SIZE || cols * TILE_SIZE > 7 * TILE_SIZE) ? new Dimension(d)
                : new Dimension(rows * TILE_SIZE, cols * TILE_SIZE));
        //setMinimumSize(new Dimension(d));

        // https://stackoverflow.com/a/47896823
        JScrollBar vScrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            public boolean isVisible() {
                return true;
            }
        };
        setVerticalScrollBar(vScrollBar);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        JScrollBar hScrollBar = new JScrollBar(JScrollBar.HORIZONTAL) {
            public boolean isVisible() {
                return true;
            }
        };
        setHorizontalScrollBar(hScrollBar);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        getVerticalScrollBar().setUnitIncrement(16);
        getHorizontalScrollBar().setUnitIncrement(16);

        tiles = new ArrayList<>();
        GridLayout gl = new GridLayout(rows, cols, 0, 0);
        tilePanel.setLayout(gl);
        tilePanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        Game g = controller.game;
        for (Tile t : g.getTiles()) {
            TileView tv = new TileView(t, c);
            tv.addTileClickListener(this);
            tiles.add(tv);
            tilePanel.add(tiles.get(tiles.size() - 1));
        }
        add(tilePanel);
        setViewportView(tilePanel);
        setBorder(BorderFactory.createEmptyBorder());
    }

    public void update() {
        for (TileView tv : tiles) {
            tv.update();
        }
        repaint();
    }

    /**
     * Feliratkozás
     */
    public void addTileClickedListener(TileClickListener tcl) {
        this.tcl = tcl;
    }

    /**
     * Továbbítjuk a feliratkozónak
     */
    public void tileClick(Tile t) {
        if (this.tcl != null)
            this.tcl.tileClick(t);
    }

    /**
     * Nem használjuk.
     */
    @Override
    public void gameOver() {

    }

    /**
     * Nem használjuk.
     */
    @Override
    public void victory() {

    }

    public List<TileView> getTileViews() {
        return tiles;
    }

    /**
     * A játékban egy sarkkutató felderítette egy cellát
     * Teszünk rá egy jelző zászlót.
     */
    @Override
    public void explore(Tile tile) {
        for (TileView tv : tiles) {
            if (tv.getTile() == tile) {
                tv.explore();
            }
        }
    }

}
