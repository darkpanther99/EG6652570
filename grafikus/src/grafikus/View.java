package grafikus;

import grafikus.model.Game;
import grafikus.model.GameObserver;
import grafikus.model.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

public class View extends JScrollPane implements GameObserver, MouseListener {
    // cellak merete, ezt a gorgovel lehetne valtoztatni
    // meg ugyanigy lehetne itt egy xOffset, yOffset, amivel pedig lehet mozgatni a nezetet
    // >Ezek a parameterek amugy majd floatok kellenek, hogy legyenek, es csak a vegen konvertalodnak intte
    private ArrayList<TileView> tiles;
    private boolean isStorm;
    private TileClickListener tcl;
    private Game game;
    private int width;
    private int height;
    View(int w, int h) {
        super();
        tiles = new ArrayList<>();
        isStorm = false;
        width = w;
        height = h;

    }

    public void update() {
        for (TileView tv : tiles) {
            tv.update();
        }
        if (isStorm) {
            //TODO(Mark)
        }
    }

    public void addTileClickedListener(TileClickListener tcl) {
        this.tcl = tcl;
        // NOTE(Mark): Ez mi a fasz??
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

    @Override
    public void mouseClicked(MouseEvent e) {
        tcl.tileClick(null);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
