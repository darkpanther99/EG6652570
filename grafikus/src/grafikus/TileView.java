package grafikus;

import grafikus.model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

/**
 * Egy cellát reprezentáló UI elem a View-ban.
 */
public class TileView extends JPanel implements MouseListener {
    private final Controller controller;
    public boolean isStorm = false;

    /**
     * A reprezentált cella.
     */
    private final Tile tile;

    /**
     * Számon tartja, hogy fel van-e derítve sarkkutató által.
     */
    private boolean isExplored;

    /**
     * @param t A cella.
     * @param c Megkapja a vezérlőt, mint dependency injection.
     */
    public TileView(Tile t, Controller c) {
        super();
        addMouseListener(this);
        tile = t;
        controller = c;
        isExplored = false;

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        Dimension d = new Dimension(View.TILE_SIZE, View.TILE_SIZE);
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    /**
     * Frissíti a grafikát.
     */
    public void update() {
        repaint();
    }

    private boolean isCorner(Tile t, int n1, int n2) {
        return (t.getSnow() == 0 && t.getWeightLimit() == 0
                && tile.getNeighbor(n1) != null && tile.getNeighbor(n2) != null
                && tile.getNeighbor(n1).getSnow() == 0 && tile.getNeighbor(n1).getWeightLimit() == 0
                && tile.getNeighbor(n2).getSnow() == 0 && tile.getNeighbor(n2).getWeightLimit() == 0) &&
                (tile.getNeighbor((n1 + 2 >= 4) ? n1 - 2 : n1 + 2) == null
                        && tile.getNeighbor((n2 + 2 >= 4) ? n2 - 2 : n2 + 2) == null);
    }

    private boolean isSide(Tile t, String side) {
        int n1, n2, n3;
        switch (side) {
            case "left":
                n1 = 0;
                n2 = 2;
                n3 = 1;
                break;
            case "right":
                n1 = 0;
                n2 = 2;
                n3 = 3;
                break;
            case "top":
                n1 = 1;
                n2 = 3;
                n3 = 2;
                break;
            case "bottom":
                n1 = 1;
                n2 = 3;
                n3 = 0;
                break;
            default:
                return false;
        }
        return (t.getSnow() == 0 && t.getWeightLimit() == 0 && t.getNeighbor(n1) != null
                && t.getNeighbor(n3) != null && t.getNeighbor(n2) != null
                && t.getNeighbor(n1).getSnow() == 0 && t.getNeighbor(n1).getWeightLimit() == 0
                && t.getNeighbor(n2).getSnow() == 0 && t.getNeighbor(n2).getWeightLimit() == 0
                && (tile.getNeighbor((n3 + 2 >= 4) ? n3 - 2 : n3 + 2) == null));
    }

    /**
     * A cella, és minden rajta lévő dolog rajzolása.
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform old = g2d.getTransform();

        Image tileImage = null;
        if (tile.getSnow() > 0) {
            tileImage = ResourceManager.imageSnow[tile.getSnow()];
        } else if (tile.getSnow() == 0) {
            tileImage = tile.getWeightLimit() > 0 ? ResourceManager.imageIce : ResourceManager.imageSnow[0];

        }

        if (isCorner(tile, 1, 2)) {
            tileImage = ResourceManager.waterCorner;
            g2d.translate(View.TILE_SIZE, 0);
            g2d.scale(-1, 1);
        }
        if (isCorner(tile, 0, 3)) {
            tileImage = ResourceManager.waterCorner;
            g2d.translate(0, View.TILE_SIZE);
            g2d.scale(1, -1);
        }
        if (isCorner(tile, 0, 1)) {
            tileImage = ResourceManager.waterCorner;
            g2d.translate(View.TILE_SIZE, View.TILE_SIZE);
            g2d.scale(-1, -1);
        }
        if (isCorner(tile, 2, 3)) {
            tileImage = ResourceManager.waterCorner;
        }
        if (isSide(tile, "left")) {
            tileImage = ResourceManager.waterSide;
            g2d.translate(View.TILE_SIZE, View.TILE_SIZE);
            g2d.rotate(Math.toRadians(180));
        }
        if (isSide(tile, "right")) {
            tileImage = ResourceManager.waterSide;
        }
        if (isSide(tile, "top")) {
            tileImage = ResourceManager.waterSide;
            g2d.translate(View.TILE_SIZE, 0);
            g2d.scale(-1, 1);
            g2d.translate(0, View.TILE_SIZE);
            g2d.rotate(Math.toRadians(-90));
        }
        if (isSide(tile, "bottom")) {
            tileImage = ResourceManager.waterSide;
            g2d.translate(View.TILE_SIZE, 0);
            g2d.scale(-1, 1);
            g2d.translate(View.TILE_SIZE, 0);
            g2d.rotate(Math.toRadians(90));
        }

        g2d.drawImage(ResourceManager.imageIce, 0, 0, View.TILE_SIZE, View.TILE_SIZE, null);
        g2d.drawImage(tileImage, 0, 0, View.TILE_SIZE, View.TILE_SIZE, null);
        g2d.setTransform(old);


        Shelter shelter = tile.getShelter();
        if (shelter != null) {
            if (shelter instanceof Tent) {
                g.drawImage(ResourceManager.tent, 0, 0, View.TILE_SIZE, View.TILE_SIZE, null);
            }
            if (shelter instanceof Igloo) {
                g.drawImage(ResourceManager.igloo, 0, 0, View.TILE_SIZE, View.TILE_SIZE, null);
            }
        }


        Item item = tile.getItem();
        if (item != null && tile.getSnow() == 0) {
            int itemSize = (int) (View.TILE_SIZE * 0.8);
            if (item instanceof Shovel) {
                g.drawImage(ResourceManager.shovel, 0, 0, itemSize, itemSize, null);
            }
            if (item instanceof BreakingShovel) {
                g.drawImage(ResourceManager.breakingShovel, 0, 0, itemSize, itemSize, null);
            }
            if (item instanceof TentKit) {
                g.drawImage(ResourceManager.tentKit, 0, 0, itemSize, itemSize, null);
            }
            if (item instanceof Food) {
                g.drawImage(ResourceManager.food, 0, 0, itemSize, itemSize, null);
            }
            if (item instanceof ScubaGear) {
                g.drawImage(ResourceManager.scubaGear, 0, 0, itemSize, itemSize, null);
            }
            if (item instanceof Rope) {
                g.drawImage(ResourceManager.rope, 0, 0, itemSize, itemSize, null);
            }
            if (item instanceof PartView) {
                itemSize *= 0.7;
                g.drawImage(((PartView) item).getImage(), 0, 0, itemSize, itemSize, null);
            }
        }
        if (isExplored) {
            if (tile.getWeightLimit() >= controller.game.getPlayers().size()) {
                g.drawImage(ResourceManager.flagSafe, View.TILE_SIZE / 10, 0,
                        (int) (View.TILE_SIZE * 0.5), (int) (View.TILE_SIZE * 0.5), null);
            } else {

                g.drawImage(ResourceManager.flagNotSafe, View.TILE_SIZE / 10, 0,
                        (int) (View.TILE_SIZE * 0.5), (int) (View.TILE_SIZE * 0.5), null);
                g.setColor(new Color(1f, 0f, 0f, 0f));
                g.fillRect(0, 0, 900, 900);
                g.setFont(new Font("TimesRoman", Font.PLAIN, View.TILE_SIZE / 5));
                g.setColor(Color.white);  // Here
                g.drawString(Integer.toString(tile.getWeightLimit()), View.TILE_SIZE / 5, View.TILE_SIZE / 5);
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
            int horizontalCount = (int) Math.ceil(Math.sqrt(occupantCount));

            int entitySize = View.TILE_SIZE / horizontalCount;

            // itt az entity-ken loopolnank vegig
            // TODO(Mark): Meg nincs a resource managerben entity img tomb, jelenleg marad ez
            for (int i = 0; i < occupantCount; i++) {
                Image entityImage = ResourceManager.imageEntity; // ez majd az entitybol jon
                boolean tallBoi = false;
                if (tile.getOccupants().get(i) instanceof EskimoView) {
                    tallBoi = true;
                    entityImage = ((EskimoView) tile.getOccupants().get(i)).playerImage;
                }
                if (tile.getOccupants().get(i) instanceof ExplorerView) {
                    tallBoi = true;
                    entityImage = ((ExplorerView) tile.getOccupants().get(i)).playerImage;
                }

                if (tile.getOccupants().get(i) instanceof PolarBear) {
                    entityImage = ResourceManager.polarBear;
                }

                int xOffset = (i % horizontalCount) * entitySize;
                int yOffset = (i / horizontalCount) * entitySize;
                g.drawImage(entityImage, xOffset, yOffset,
                        (tallBoi) ? (int) (entitySize / 1.8) : entitySize, entitySize, null);
                if (tile.getOccupants().get(i) instanceof Player && ((Player) tile.getOccupants().get(i)).getWaterResistanceStrategy() instanceof ScubaWearing)
                    g.drawImage(ResourceManager.scubaGearPlayer, xOffset, yOffset,
                            (tallBoi) ? (int) (entitySize / 1.8) : entitySize, entitySize, null);
                if (tile.getOccupants().get(i) == controller.selectedPlayer) {
                    g2d.drawImage(ResourceManager.selectedPlayer,
                            (xOffset - 35 / horizontalCount), yOffset - 35 / horizontalCount,
                            (int) (entitySize / 1.8) * 2, (int) (entitySize * 2.6), null);
                    // NOTE(Mark): Akit zavar, hogy ez így néz ki, az csináljon egy új textúrát szélek nélkül
                    g2d.setTransform(old);
                }
            }

        }
        if (isStorm) {
            g.drawImage(ResourceManager.storm, 0, 0, View.TILE_SIZE, View.TILE_SIZE, null);
            isStorm = false;
        }
    }

    /**
     * A játékban fel lett derítve ez a cella.
     */
    public void explore() {
        isExplored = true;
    }

    public Tile getTile() {
        return tile;
    }

    /**
     * Továbbítás a TileClick eseménynek.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        controller.tileClick(tile);
    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
