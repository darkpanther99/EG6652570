package grafikus;

import grafikus.model.Empty;
import grafikus.model.Item;
import grafikus.model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * A játékos tárgyait mutató UI elem.
 */
public class InventoryMenu extends JScrollPane {
    /**
     * Az ikon négyzet mérete.
     */
    public static final int ITEM_SIZE = 128;

    private final Controller controller;
    private final JPanel content;

    /**
     * @param controller Megkapja a vezérlőt, mint dependency injection.
     */
    public InventoryMenu(Controller controller) {
        super();
        this.controller = controller;
        content = new JPanel() {
            /**
             * Üres kereteket rajzol a maradék helyre.
             */
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                int height = getHeight();
                for (int y = (getComponentCount() - 1) * ITEM_SIZE; y < height; y += ITEM_SIZE) {
                    g.drawImage(ResourceManager.itemSlot, 0, y, ITEM_SIZE, ITEM_SIZE, null);
                }
                paintChildren(g);
            }
        };
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
        setPreferredSize(new Dimension(ITEM_SIZE, 0));
        setBorder(BorderFactory.createEmptyBorder());
    }

    /**
     * Frissíti a megjelenő tárgyakat.
     */
    public void update() {
        content.removeAll();
        Player player = controller.selectedPlayer;
        if (player != null) {
            // külön slotok a consumable itemeknek
            ItemIcon partIcon = new ItemIcon(controller, player.getPartStore());
            content.add(partIcon);
            ItemIcon foodIcon = new ItemIcon(controller, player.getFoodStore());
            content.add(foodIcon);
            ItemIcon tentkitIcon = new ItemIcon(controller, player.getBuildStrategy());
            content.add(tentkitIcon);
            List<Item> inventory = controller.selectedPlayer.getInventory();

            int count = 3;
            for (Item item : inventory) {
                if (item instanceof Empty) continue;
                // nem itt vizsgáljuk, hogy equippelt-e
                ItemIcon icon = new ItemIcon(controller, item, false);
                content.add(icon);
                count++;
            }
            int extraSlots = Math.max(0, 10 - count); // 10 vagy több slotot rajzolunk
            Box.Filler glue = (Box.Filler) Box.createVerticalGlue();
            glue.changeShape(glue.getMinimumSize(),
                    new Dimension(0, ITEM_SIZE * extraSlots),
                    glue.getMaximumSize());
            content.add(glue);
        }
        content.revalidate();
        content.repaint();
    }
}
