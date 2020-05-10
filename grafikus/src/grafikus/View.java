package grafikus;

import grafikus.model.Game;
import grafikus.model.GameObserver;
import grafikus.model.Tile;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class View extends JPanel implements GameObserver {
    private ArrayList<TileView> tiles;
    private boolean isStorm;
    private TileClickListener tcl;
    private int width;
    private int height;
    View(int w, int h) {
        super();
        width = 640;
        height = 448;
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
        //setMinimumSize(d);
        //setMaximumSize(d);
        tiles = new ArrayList<>();
        setLayout(new GridLayout(height/64,width/64, 0, 0));
        setBorder(new EmptyBorder(0, 0, 0, 0));

        // NOTE(Mark): Teszt
        for (int i = 0; i < (width/64)*(height/64); i++) {
            Tile t = new Tile();
            t.setSnow(new Random().nextInt(5 + 1));
            tiles.add(new TileView(t,tcl));
            add(tiles.get(tiles.size()-1));
        }


        isStorm = false;


    }

    public void update() {
        for (TileView tv : tiles) {
            tv.update();

        }
        if (isStorm) {
            //TODO(Mark)
        }
        repaint(getVisibleRect());
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
