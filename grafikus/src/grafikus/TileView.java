package grafikus;

import grafikus.model.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class TileView extends JPanel implements MouseListener {
    private Tile tile;
    private boolean isExplored;
    static public int s_TileSize = 128;
    private TileClickListener tcl;
    public TileView(Tile t, TileClickListener tcl) {
        super();
        addMouseListener(this);
        tile = t;
        this.tcl = tcl;
        isExplored = false;

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        Dimension d = new Dimension(s_TileSize, s_TileSize);
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        setBorder(new EmptyBorder(0, 0, 0, 0));

    }

    public void update() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform old = g2d.getTransform();

        Image tileImage = null;
        if (tile.getSnow() > 0) {
            tileImage = ResourceManager.imageSnow[tile.getSnow()];
        } else if (tile.getSnow() == 0) {
            tileImage = tile.getWeightLimit() > 0 ? ResourceManager.imageIce : ResourceManager.imageSnow[0];

        } else if (tile.getSnow() >= -4) {
            tileImage = ResourceManager.waterSide;
            switch (tile.getSnow()) {
                case -1: // Fent
                    g2d.translate(s_TileSize, 0);
                    g2d.scale(-1, 1);
                    g2d.translate(0, s_TileSize);
                    g2d.rotate(Math.toRadians(-90));
                    break;
                case -2: // Lent
                    g2d.translate(s_TileSize, 0);
                    g2d.scale(-1, 1);
                    g2d.translate(s_TileSize, 0);
                    g2d.rotate(Math.toRadians(90));
                    break;
                case -3: // Balra
                    g2d.translate(s_TileSize, s_TileSize);
                    g2d.rotate(Math.toRadians(180));
                    break;
                case -4: // Jobbra
                    break;
            }
        } else {
            tileImage = ResourceManager.waterCorner;
            switch (tile.getSnow()) {
                case -5: // Fent bal
                    g2d.translate(s_TileSize, 0);
                    g2d.scale(-1, 1);
                    break;
                case -6: // Fent jobb
                    break;
                case -7: // Lent jobb
                    g2d.translate(0, s_TileSize);
                    g2d.scale(1, -1);
                    break;
                case -8: // Lent bal
                    g2d.translate(s_TileSize, s_TileSize);
                    g2d.scale(-1, -1);
                    break;

            }
        }
        g2d.drawImage(ResourceManager.imageIce, 0, 0, s_TileSize, s_TileSize, null);
        g2d.drawImage(tileImage, 0, 0, s_TileSize, s_TileSize, null);
        //g2d.setTransform(old);


        Shelter shelter = tile.getShelter();
        if (shelter != null) {
            if (shelter instanceof Tent) {
                g.drawImage(ResourceManager.tent, 0,0,s_TileSize, s_TileSize,null);
            }
            if (shelter instanceof Igloo) {
                g.drawImage(ResourceManager.igloo, 0,0,s_TileSize, s_TileSize,null);
            }
        }


        Item item = tile.getItem();
        if (item != null && tile.getSnow() == 0) {
            if (item instanceof Shovel) {
                g.drawImage(ResourceManager.shovel, 0,0,s_TileSize, s_TileSize,null);
            }
            if (item instanceof BreakingShovel) {
                g.drawImage(ResourceManager.breakingShovel, 0,0,s_TileSize, s_TileSize,null);
            }
            if (item instanceof TentKit) {
                g.drawImage(ResourceManager.tentkit, 0,0,s_TileSize, s_TileSize,null);
            }
            if (item instanceof Part) {
                g.drawImage(ResourceManager.flare, 0,0,s_TileSize, s_TileSize,null);
            }
            if (item instanceof Food) {
                g.drawImage(ResourceManager.food, 0,0,s_TileSize, s_TileSize,null);
            }
            if (item instanceof ScubaGear) {
                g.drawImage(ResourceManager.scubaGear, 0,0,s_TileSize, s_TileSize,null);
            }
            if (item instanceof Rope) {
                g.drawImage(ResourceManager.rope, 0,0,s_TileSize, s_TileSize,null);
            }
        }


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
                int xOffset = (i % horizontalCount) * entitySize;
                int yOffset = (i / horizontalCount) * entitySize;

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
        if (tcl != null) tcl.tileClick(tile);
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
