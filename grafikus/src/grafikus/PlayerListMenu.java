package grafikus;

import grafikus.model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A játékosokat megjelenítő UI elem.
 */
public class PlayerListMenu extends JScrollPane {
    private final Controller controller;
    /**
     * A tartalmazott PlayerIcon komponensek.
     */
    private final List<PlayerIcon> iconList;
    /**
     * Az ikon négyzet mérete.
     */
    public static final int PLAYER_ICON_SIZE = 128;

    /**
     * @param controller Megkapja a vezérlőt, mint dependency injection.
     */
    public PlayerListMenu(Controller controller) {
        super();
        this.controller = controller;
        this.iconList = new ArrayList<>();

        JPanel content = new JPanel() {
            /**
             * Üres kereteteket rajzol a maradék helyre.
             */
            @Override
            public void paint(Graphics g) {
                super.paint(g);

                int height = getHeight();
                for (int y = iconList.size() * PLAYER_ICON_SIZE; y < height; y += PLAYER_ICON_SIZE) {
                    g.drawImage(ResourceManager.emptyPlayerSlot, 0, y, PLAYER_ICON_SIZE, PLAYER_ICON_SIZE, null);
                }

                paintChildren(g);
            }
        };

        content.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        // https://stackoverflow.com/a/47896823
        JScrollBar vScrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            public boolean isVisible() {
                return true;
            }
        };
        setVerticalScrollBar(vScrollBar);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        getVerticalScrollBar().setUnitIncrement(20);

        add(content);
        setViewportView(content);
        setPreferredSize(new Dimension(PLAYER_ICON_SIZE, 0));
        setBorder(BorderFactory.createEmptyBorder());

        for (Player p : controller.game.getPlayers()) {
            PlayerIcon pi = new PlayerIcon(controller, p, false);
            pi.addPlayerSelectListener(controller);
            if (controller.selectedPlayer == p) {
                pi.isSelected = true;
            }
            iconList.add(pi);
            content.add(pi);
        }

        int extraSlots = Math.max(0, 10 - (iconList.size())); // 10 vagy több slotot rajzolunk
        Box.Filler glue = (Box.Filler) Box.createVerticalGlue();
        glue.changeShape(glue.getMinimumSize(),
                new Dimension(0, PLAYER_ICON_SIZE * extraSlots),
                glue.getMaximumSize());
        content.add(glue);
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
}
