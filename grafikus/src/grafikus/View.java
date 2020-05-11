package grafikus;

import grafikus.mapgen.MapGen;
import grafikus.model.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class View extends JScrollPane implements GameObserver {
    private ArrayList<TileView> tiles;
    private int rows;
    private int cols;
    private boolean isStorm;
    private TileClickListener tcl;
    private JPanel tilePanel;
    Controller controller;
    View(Controller c, int rows, int cols) {
        super();
        this.rows = rows;
        this.cols = cols;
        controller = c;
        tilePanel = new JPanel();
        int width = 10*TileView.s_TileSize;
        int height = 7*TileView.s_TileSize;
        Dimension d = new Dimension(width, height);

        //setMaximumSize(new Dimension(rows*TileView.s_TileSize, rows*TileView.s_TileSize));
        setMaximumSize(new Dimension(d));
        setPreferredSize((rows*TileView.s_TileSize > 10*TileView.s_TileSize || cols*TileView.s_TileSize > 7*TileView.s_TileSize) ? new Dimension(d) : new Dimension(rows*TileView.s_TileSize,cols*TileView.s_TileSize));
        //setMinimumSize(new Dimension(d));

        final boolean hideScrollbar = true;
        if(hideScrollbar) {
            // https://stackoverflow.com/a/47896823
            JScrollBar vScrollBar = new JScrollBar(JScrollBar.VERTICAL) {
                public boolean isVisible() { return true; }
            };
            setVerticalScrollBar(vScrollBar);
            setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            JScrollBar hScrollBar = new JScrollBar(JScrollBar.HORIZONTAL) {
                public boolean isVisible() { return true; }
            };
            setHorizontalScrollBar(hScrollBar);
            setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        }

        getVerticalScrollBar().setUnitIncrement(16);
        getHorizontalScrollBar().setUnitIncrement(16);

        tiles = new ArrayList<>();
        GridLayout gl = new GridLayout(rows,cols, 0, 0);
        tilePanel.setLayout(gl);
        tilePanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        Game g = controller.game;
        for (Tile t : g.getTiles()) {
            tiles.add(new TileView(t,c));
            tilePanel.add(tiles.get(tiles.size()-1));
        }
        add(tilePanel);
        setViewportView(tilePanel);
        setBorder(BorderFactory.createEmptyBorder());

        isStorm = false;


    }

    public void update() {
        for (TileView tv : tiles) {
            tv.update();

        }
        if (isStorm) {
            //TODO(Mark)
        }

        repaint();
    }


    public void addTileClickedListener(TileClickListener tcl) {
        this.tcl = tcl;
    }

    @Override
    public void gameOver() {

    }

    @Override
    public void victory() {

    }

    @Override
    public void explore(Tile tile) {
        for (TileView tv : tiles) {
            if (tv.getTile() == tile) {
                tv.explore();
            }
        }
    }

}
