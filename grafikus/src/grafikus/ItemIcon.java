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

                int size = 50;
                int xOffs = (InventoryMenu.ITEMSIZE - size) / 2;
                int yOffs = (InventoryMenu.ITEMSIZE - size) / 2 + 10;
                g.drawImage(ResourceManager.food, xOffs, yOffs, size, size, null);

                String str = count + "x";
                FontMetrics metrics = getFontMetrics(this.getFont());
                int w = metrics.stringWidth(str);

                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(Color.WHITE);
                g2.drawString(str, (InventoryMenu.ITEMSIZE - w) / 2, metrics.getHeight() + 92);
            }
        } else if(type == Type.PART_STORE) {
            g.drawImage(ResourceManager.pewpewSlot, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);

            int xOffs = 0;
            int yOffs = 0;
            int w = 1;
            int h = 1;

            if(partStore.getCount() > 0) {
                xOffs = 36;
                yOffs = 33;
                w = 55;
                h = 37;
                g.drawImage(ResourceManager.flareGun, xOffs, yOffs, w, h, null);

                if(partStore.getCount() > 1) {
                    xOffs = 32;
                    yOffs = 98;
                    w = 20;
                    h = 20;
                    g.drawImage(ResourceManager.flareLight, xOffs, yOffs, w, h, null);
                }
                if(partStore.getCount() > 2) {
                    xOffs = 80;
                    yOffs = 98;
                    w = 12;
                    h = 20;
                    g.drawImage(ResourceManager.flare, xOffs, yOffs, w, h, null);
                }
            }

        } else if(type == Type.TENTKIT_STORE) {
            g.drawImage(ResourceManager.tentkitSlot, 0, 0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);

            if(tentkitStore.getCount() > 0) {
                int size = 64;
                int xOffs = (InventoryMenu.ITEMSIZE - size) / 2;
                int yOffs = (InventoryMenu.ITEMSIZE - size) / 2 + 12;
                g.drawImage(ResourceManager.tentkit, xOffs, yOffs, size, size, null);


                String str = tentkitStore.getCount() + "x";
                FontMetrics metrics = getFontMetrics(this.getFont());
                int w = metrics.stringWidth(str);

                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(Color.WHITE);
                g2.drawString(str, (InventoryMenu.ITEMSIZE - w) / 2, metrics.getHeight() + 92);
            }
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
