package grafikus;

import grafikus.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ItemIcon extends JPanel implements MouseListener {

    enum Type {
        UNDEFINED,
        FOODSTORE,
        PARTSTORE,
    }

    public Type type;

    public Item item = null;
    public boolean isEquipped = false;
    public FoodStore foodStore = null;
    public PartStore partStore = null;

    public Controller controller;

    private ItemIcon(Controller controller) {
        super();
        this.controller = controller;

        Dimension d = new Dimension(InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE);
        setPreferredSize(d);
        setMinimumSize(d);
    }


    public ItemIcon(Controller controller, PartStore partStore) {
        this(controller);

        type = Type.PARTSTORE;
        this.partStore = partStore;
    }

    public ItemIcon(Controller controller, FoodStore foodStore) {
        this(controller);

        type = Type.FOODSTORE;
        this.foodStore = foodStore;
    }

    public ItemIcon(Controller controller, Item item, boolean isEquipped) {
        this(controller);

        type = Type.UNDEFINED;

        this.item = item;
        this.isEquipped = isEquipped;
        addMouseListener(this);
    }

    public void equip(){
        if(isEquipped && type != Type.UNDEFINED) return;

        Player p = controller.selectedPlayer;
        int i = p.getInventory().indexOf(item);
        p.equip(i);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(type == Type.UNDEFINED) {
            g.drawImage(ResourceManager.itemSlot, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);

            Image img = null;
            if (item instanceof Shovel)  img = ResourceManager.shovel;
            else if (item instanceof BreakingShovel) img = ResourceManager.breakingShovel;
            else if (item instanceof Rope)  img = ResourceManager.rope;
            else if (item instanceof TentKit) img = ResourceManager.tentkit;
            else img = ResourceManager.imageEntity;

            g.drawImage(img, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);
        } else if(type == Type.FOODSTORE) {
            g.drawImage(ResourceManager.foodSlot, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);
            int count = foodStore.getCount();
            if(count > 0) {
                g.drawImage(ResourceManager.food, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);
            }
        } else if(type == Type.PARTSTORE) {
            g.drawImage(ResourceManager.pewpewSlot, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);
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
