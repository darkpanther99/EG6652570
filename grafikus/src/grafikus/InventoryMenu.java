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
public class InventoryMenu extends JPanel {
    /**
     * Az ikon négyzet mérete.
     */
    public static final int ITEM_SIZE = 128;

    private final Controller controller;

    /**
     * @param controller Megkapja a vezérlőt, mint dependency injection.
     */
    public InventoryMenu(Controller controller) {
        this.controller = controller;
        setPreferredSize(new Dimension(ITEM_SIZE, 0));

        this.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));
    }

    /**
     * Frissíti a megjelenő tárgyakat.
     */
    public void update() {
        this.removeAll();

        Player player = controller.selectedPlayer;
        if (player != null) {

            ItemIcon partIcon = new ItemIcon(controller, player.getPartStore());
            this.add(partIcon);

            ItemIcon foodIcon = new ItemIcon(controller, player.getFoodStore());
            this.add(foodIcon);

            ItemIcon tentkitIcon = new ItemIcon(controller, player.getBuildStrategy());
            this.add(tentkitIcon);

            List<Item> inventory = controller.selectedPlayer.getInventory();
            for (Item item : inventory) {
                if (item instanceof Empty) {
                    continue;
                }
                // TODO(boti): isEquipped
                ItemIcon icon = new ItemIcon(controller, item, false);
                this.add(icon);
            }
        }

        this.revalidate();
        this.repaint();
    }

    /**
     * Kereteket rajzol az ItemIconok köré.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int height = getHeight();

        for (int y = getComponentCount() * ITEM_SIZE; y < height; y += ITEM_SIZE) {
            g.drawImage(ResourceManager.itemSlot, 0, y, ITEM_SIZE, ITEM_SIZE, null);
        }

        paintChildren(g);
    }
}
