package grafikus;

import grafikus.model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A játékosokat megjelenítő UI elem.
 */
public class PlayerListMenu extends JPanel {
    private final Controller controller;
    /**
     * A tartalmazott PlayerIcon komponensek.
     */
    private final java.util.List<PlayerIcon> iconList;
    /**
     * Az ikon négyzet mérete.
     */
    public static final int PLAYERICONSIZE = 128;

    /**
     * @param controller Megkapja a vezérlőt, mint dependency injection.
     */
    public PlayerListMenu(Controller controller) {
        super();

        this.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));

        this.controller = controller;
        this.iconList = new ArrayList<>();

        for (Player p : controller.game.getPlayers()) {
            PlayerIcon pi = new PlayerIcon(controller, p, false);
            pi.addPlayerSelectListener(controller);
            if (controller.selectedPlayer == p) {
                pi.isSelected = true;
            }
            iconList.add(pi);
            this.add(pi);
        }

        Dimension d = new Dimension(PLAYERICONSIZE, 0);
        setPreferredSize(d);
        setMinimumSize(d);
    }

    /**
     * Frissíti a PlayerIconokat.
     */
    public void update() {
        for (PlayerIcon pi : iconList) {
            pi.isSelected = pi.player == controller.selectedPlayer;
            pi.update();
        }
    }

    /**
     * Keretet rajzol a PlayerIconok köré.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int height = getHeight();
        for (int y = iconList.size() * PLAYERICONSIZE; y < height; y += PLAYERICONSIZE) {
            g.drawImage(ResourceManager.emptyPlayerSlot, 0, y, PLAYERICONSIZE, PLAYERICONSIZE, null);
        }

        paintChildren(g);
    }
}
