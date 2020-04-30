import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GfxSkicc implements KeyListener {

    class Canvas extends JPanel /*implements MouseInputListener*/ {
        private int width;
        private int height;

        // cellak merete, ezt a gorgovel lehetne valtoztatni
        // meg ugyanigy lehetne itt egy xOffset, yOffset, amivel pedig lehet mozgatni a nezetet
        // >Ezek a parameterek amugy majd floatok kellenek, hogy legyenek, es csak a vegen konvertalodnak intte
        private static final int tileSize = 64;

        Canvas(int w, int h)  {
            super();
            width = w;
            height = h;

            Dimension d = new Dimension(width, height);
            setPreferredSize(d);
            setMinimumSize(d);
        }

        private Tile getTile(int x, int y) {
            int weightLimit = x == 0 ? 0 : 10;
            int snow = x == 1 ? 0 : Math.min(x - 1, 5);

            int occupants = y;
            return new Tile(snow, weightLimit, occupants);
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D)g; // @NOTE(boti): ez elviekben mindig safe
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, width, height);

            // itt az x, y koordinatak majd magabol a map definiciobol jonnek
            // es csak a tile-okon kell vegig loopolni
            for(int y = 0; y < 9; y++) {
                for(int x = 0; x < 6; x++) {

                    Tile tile = getTile(x, y); // proceduralis tile

                    // tile parameteribol kitalaljuk, hogy melyik textura kell
                    Image tileImage = null;
                    if(tile.snow > 0) {
                        tileImage = ResourceManager.imageSnow[tile.snow - 1];
                    } else {
                        tileImage = tile.weightLimit > 0 ? ResourceManager.imageIce : ResourceManager.imageSea;
                    }

                    // kirajzoljuk a tile-t
                    g2.drawImage(tileImage, x*tileSize, y*tileSize, tileSize, tileSize, null);

                    // ide jonne a shelter rajzolas
                    /* g2.drawImage(...) */

                    // ide pedig az item rajzolas (ha snow == 0)
                    /* g2.drawImage(...) */

                    int occupantCount = tile.occupants;
                    if(occupantCount > 0) {
                        // occupant szamatol fuggoen valtoztatjuk a cella felosztasat
                        // 1 -> 1*1
                        // 2-4 -> 2*2
                        // 5-9 -> 3*3
                        // etc.
                        int horizontalCount = (int) Math.ceil(Math.sqrt((double) occupantCount));

                        int entitySize = tileSize / horizontalCount;

                        // itt az entity-ken loopolnank vegig
                        for(int i = 0; i < occupantCount; i++) {
                            int xOffset = x*tileSize + (i % horizontalCount) * entitySize;
                            int yOffset = y*tileSize + (i / horizontalCount) * entitySize;

                            Image entityImage = ResourceManager.imageEntity; // ez majd az entitybol jon
                            g2.drawImage(entityImage, xOffset, yOffset, entitySize, entitySize, null);
                        }
                    }
                }
            }

        }
    }

    GfxSkicc()  {
        ResourceManager.init();

        JFrame mainFrame = new JFrame("GfxSkicc");
        Canvas canvas = new Canvas(800, 600);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(canvas);
        mainFrame.pack();
        mainFrame.setVisible(true);

        mainFrame.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // sound system hasznalata gyakorlatilag ennyi, max meg egy loop-ot lehetne belerakni
        // ha akarunk hatterzenet
        if(e.getKeyChar() == 'p') {
            ResourceManager.soundBackground.play();
        }
        if(e.getKeyChar() == 's') {
            ResourceManager.soundBackground.stop();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static void main(String[] args) {
        new GfxSkicc();
    }
}
