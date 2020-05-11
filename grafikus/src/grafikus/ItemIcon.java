package grafikus;

import grafikus.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ItemIcon extends JPanel implements MouseListener {

    enum Type {
        ITEM,
        FOOD_STORE,
        PART_STORE,
        TENTKIT_STORE,
    }

    public Type type;

    public Item item = null;
    public boolean isEquipped = false;
    public FoodStore foodStore = null;
    public PartStore partStore = null;
    public BuildStrategy tentkitStore = null;


    public Controller controller;

    private ItemIcon(Controller controller) {
        super();
        this.controller = controller;

        Dimension d = new Dimension(InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE);
        setPreferredSize(d);
        setMinimumSize(d);
    }

    public ItemIcon(Controller controller, BuildStrategy tentkitStore) {
        this(controller);

        type = Type.TENTKIT_STORE;
        this.tentkitStore = tentkitStore;
    }

    public ItemIcon(Controller controller, PartStore partStore) {
        this(controller);

        type = Type.PART_STORE;
        this.partStore = partStore;
    }

    public ItemIcon(Controller controller, FoodStore foodStore) {
        this(controller);

        type = Type.FOOD_STORE;
        this.foodStore = foodStore;
    }

    public ItemIcon(Controller controller, Item item, boolean isEquipped) {
        this(controller);

        type = Type.ITEM;

        this.item = item;
        this.isEquipped = isEquipped;
        addMouseListener(this);
    }

    public void equip() {
        if(isEquipped || type != Type.ITEM) return;

        Player p = controller.selectedPlayer;
        int i = p.getInventory().indexOf(item);
        p.equip(i);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(type == Type.ITEM) {
            g.drawImage(ResourceManager.itemSlot, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);

            Image img = null;
            if (item instanceof Shovel)  img = ResourceManager.shovel;
            else if (item instanceof BreakingShovel) img = ResourceManager.breakingShovel;
            else if (item instanceof Rope)  img = ResourceManager.rope;
            else if (item instanceof TentKit) img = ResourceManager.tentkit;
            else img = ResourceManager.imageEntity;

            g.drawImage(img, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);
        } else if(type == Type.FOOD_STORE) {
            g.drawImage(ResourceManager.foodSlot, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);
            int count = foodStore.getCount();
            if(count > 0) {
                g.drawImage(ResourceManager.food, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);
            }
        } else if(type == Type.PART_STORE) {
            g.drawImage(ResourceManager.pewpewSlot, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);
            // TODO(boti): count
        } else if(type == Type.TENTKIT_STORE) {
            g.drawImage(ResourceManager.tentkitSlot, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);
            // TODO(boti): count
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        equip();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
