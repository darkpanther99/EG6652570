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

public class View extends JPanel implements GameObserver {
    private ArrayList<TileView> tiles;
    private boolean isStorm;
    private TileClickListener tcl;
    private JPanel tilePanel;
    Controller controller;
    View(Controller c) {
        super();
        controller = c;
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        tilePanel = new JPanel();
        int width = 640*2;
        int height = 448*2;
        Dimension d = new Dimension(width, height);
        tilePanel.setPreferredSize(d);
        tilePanel.setMinimumSize(d);
        tilePanel.setMaximumSize(d);
        tiles = new ArrayList<>();
        GridLayout gl = new GridLayout(height/TileView.s_TileSize,width/TileView.s_TileSize, 0, 0);
        tilePanel.setLayout(gl);
        tilePanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        Game g = controller.game;
        MapGen.generateMap(g);
        for (Tile t : g.getTiles()) {
            tiles.add(new TileView(t,c));
            tilePanel.add(tiles.get(tiles.size()-1));
        }
        add(tilePanel);
        /*
        // NOTE(Mark): Teszt
        for (int i = 0; i < (width/TileView.s_TileSize)*(height/TileView.s_TileSize); i++) {
            Tile t = new Tile();
            t.setSnow(new Random().nextInt(5+1));
            if (t.getSnow() == 0) {
                t.setWeightLimit(new Random().nextInt(2 + 1));
            }
            else t.setWeightLimit(3);
            if (i == 0) {
                t.setItem(new Shovel());
                t.setShelter(new Tent());
                t.setSnow(0);
                t.setWeightLimit(1);
            }
            tiles.add(new TileView(t,tcl));
            tilePanel.add(tiles.get(tiles.size()-1));
        }
        add(tilePanel);
 */


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
