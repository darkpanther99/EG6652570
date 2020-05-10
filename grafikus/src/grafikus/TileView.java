package grafikus;

import grafikus.model.Entity;
import grafikus.model.Item;
import grafikus.model.Shelter;
import grafikus.model.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class TileView extends JPanel implements MouseListener {
    private Tile tile;
    private boolean isExplored;
    static private int s_TileSize = 64;
    private TileClickListener tcl;
    private int x, y;
    public TileView(Tile t, TileClickListener tcl) {
        tile = t;
        this.tcl = tcl;
        isExplored = false;
    }

    public void update() {
        repaint(getVisibleRect());
    }



    @Override
    public void paint(Graphics g) {
        Image tileImage;
        if (tile.getSnow() > 0) {
            tileImage = ResourceManager.imageSnow[tile.getSnow() - 1];
        } else {
            tileImage = tile.getWeightLimit() > 0 ? ResourceManager.imageIce : ResourceManager.imageSea;
        }

        g.drawImage(tileImage, x * s_TileSize, y * s_TileSize, s_TileSize, s_TileSize, null);

        int occupantCount = tile.getOccupants().size();
        if (occupantCount > 0) {
            // occupant szamatol fuggoen valtoztatjuk a cella felosztasat
            // 1 -> 1*1
            // 2-4 -> 2*2
            // 5-9 -> 3*3
            // etc.
            // NOTE(Mark): Koszi Boti <3
            int horizontalCount = (int) Math.ceil(Math.sqrt((double) occupantCount));

            int entitySize = s_TileSize / horizontalCount;

            // itt az entity-ken loopolnank vegig
            // TODO(Mark): Meg nincs a resource managerben entity img tomb, jelenleg marad ez
            for (int i = 0; i < occupantCount; i++) {
                int xOffset = x * s_TileSize + (i % horizontalCount) * entitySize;
                int yOffset = y * s_TileSize + (i / horizontalCount) * entitySize;

                Image entityImage = ResourceManager.imageEntity; // ez majd az entitybol jon
                g.drawImage(entityImage, xOffset, yOffset, entitySize, entitySize, null);
            }

        }
    }

    public void explore() {
        isExplored = true;
    }

    public Tile getTile() {
        return tile;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tcl.tileClick(tile);
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