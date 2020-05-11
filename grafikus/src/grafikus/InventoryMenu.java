package grafikus;

import grafikus.model.*;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class InventoryMenu extends JPanel {
    public static final int ITEMSIZE = 128;

    private Controller controller;

    public InventoryMenu(Controller controller) {
        this.controller = controller;
        setPreferredSize(new Dimension(ITEMSIZE, 0));

        this.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));
    }

    public void update() {
        this.removeAll();

        Player player = controller.selectedPlayer;
        if(player != null) {

            ItemIcon partIcon = new ItemIcon(controller, player.getPartStore());
            this.add(partIcon);

            ItemIcon foodIcon = new ItemIcon(controller, player.getFoodStore());
            this.add(foodIcon);

            List<Item> inventory = controller.selectedPlayer.getInventory();
            for(Item item : inventory) {
                // TODO(boti): isEquipped
                ItemIcon icon = new ItemIcon(controller, item, false);
                this.add(icon);
            }
        }

        this.revalidate();
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int height = getHeight();

        for(int y = getComponentCount()*ITEMSIZE; y < height; y += ITEMSIZE) {
            g.drawImage(ResourceManager.itemSlot, 0, y, ITEMSIZE, ITEMSIZE, null);
        }

        paintChildren(g);
    }
}
