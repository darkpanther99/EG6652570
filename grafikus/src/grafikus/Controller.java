package grafikus;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    Controller() {
        JFrame mainFrame = new JFrame("GfxSkicc");
        View view = new View(800, 600);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(view);
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
        if (e.getKeyChar() == 'p') {
            ResourceManager.soundBackground.play();
        }
        if (e.getKeyChar() == 's') {
            ResourceManager.soundBackground.stop();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
