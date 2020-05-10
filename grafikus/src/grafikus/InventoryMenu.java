package grafikus;

import grafikus.model.*;

import java.util.*;

import javax.swing.*;
import java.awt.Dimension;

public class InventoryMenu extends JPanel {
    public static final int ITEMSIZE = 64;

    private Controller controller;

    public InventoryMenu(Controller controller) {
        this.controller = controller;
        setPreferredSize(new Dimension(ITEMSIZE, 0));

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void update() {
        this.removeAll();

        if(controller.selectedPlayer != null) {
            List<Item> inventory = controller.selectedPlayer.getInventory();
            for(Item item : inventory) {
                // TODO(boti): isEquipped
                ItemIcon icon = new ItemIcon(item, controller, false);
                this.add(icon);
            }
        }
    }
}
