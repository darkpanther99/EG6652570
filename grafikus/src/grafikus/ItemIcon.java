package grafikus;

import grafikus.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Az InventoryMenu egy tárgyát megjelenítő UI elem.
 */
public class ItemIcon extends JPanel implements MouseListener {
    private final Controller controller;

    /**
     * Ilyen tárgyat jelenít meg.
     */
    private enum Type {
        /**
         * Nem consumable tárgy.
         */
        ITEM,
        /**
         * étel
         */
        FOOD_STORE,
        /**
         * alkatrész
         */
        PART_STORE,
        /**
         * sátor
         */
        TENTKIT_STORE,
    }
    private Type type;

    // A tárgy modellbeli állapotához tartozó segédváltozók.
    private Item item = null;
    private boolean isEquipped = false;
    private FoodStore foodStore = null;
    private PartStore partStore = null;
    private BuildStrategy tentkitStore = null;
    /**
     * @param controller Megkapja a vezérlőt mint dependency injection.
     */
    private ItemIcon(Controller controller) {
        super();
        this.controller = controller;

        Dimension d = new Dimension(InventoryMenu.ITEM_SIZE, InventoryMenu.ITEM_SIZE);
        setPreferredSize(d);
        setMinimumSize(d);
        addMouseListener(this);
    }

    /**
     * Sátrat reprezentál.
     *
     * @param controller Megkapja a vezérlőt mint dependency injection.
     */
    public ItemIcon(Controller controller, BuildStrategy tentkitStore) {
        this(controller);

        type = Type.TENTKIT_STORE;
        this.tentkitStore = tentkitStore;
    }

    /**
     * Alkatrészt reprezentál.
     *
     * @param controller Megkapja a vezérlőt mint dependency injection.
     */
    public ItemIcon(Controller controller, PartStore partStore) {
        this(controller);

        type = Type.PART_STORE;
        this.partStore = partStore;
    }

    /**
     * Ételt reprezentál.
     *
     * @param controller Megkapja a vezérlőt mint dependency injection.
     */
    public ItemIcon(Controller controller, FoodStore foodStore) {
        this(controller);

        type = Type.FOOD_STORE;
        this.foodStore = foodStore;
    }

    /**
     * Nem consumable tárgyat reprezentál.
     *
     * @param controller Megkapja a vezérlőt mint dependency injection.
     */
    public ItemIcon(Controller controller, Item item, boolean isEquipped) {
        this(controller);

        type = Type.ITEM;

        this.item = item;
        this.isEquipped = isEquipped;
        addMouseListener(this);
    }

    /**
     * A játékos kézbe veszi a nem consumable tárgyat.
     */
    public void equip() {
        if (isEquipped || type != Type.ITEM) return;

        Player p = controller.selectedPlayer;
        int i = p.getInventory().indexOf(item);
        p.equip(i);
        controller.update(false, true, false, true);
    }

    /**
     * A megfelelő ikon kirajzolása.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (type == Type.ITEM) {
            g.drawImage(ResourceManager.itemSlot, 0, 0, InventoryMenu.ITEM_SIZE, InventoryMenu.ITEM_SIZE, null);

            Image img;
            if (item instanceof Shovel) img = ResourceManager.shovel;
            else if (item instanceof BreakingShovel) img = ResourceManager.breakingShovel;
            else if (item instanceof Rope) img = ResourceManager.rope;
            else if (item instanceof TentKit) img = ResourceManager.tentKit;
            else if (item instanceof ScubaGear) img = ResourceManager.scubaGear;
            else img = ResourceManager.imageEntity;

            int size = InventoryMenu.ITEM_SIZE / 3;
            int xOffs = (InventoryMenu.ITEM_SIZE - size) / 2;
            int yOffs = (InventoryMenu.ITEM_SIZE - size) / 2 + 12;
            g.drawImage(img, xOffs, yOffs, size, size, null);
        } else if (type == Type.FOOD_STORE) {
            g.drawImage(ResourceManager.foodSlot, 0, 0, InventoryMenu.ITEM_SIZE, InventoryMenu.ITEM_SIZE, null);
            int count = foodStore.getCount();
            if (count > 0) {

                int size = 50;
                int xOffs = (InventoryMenu.ITEM_SIZE - size) / 2;
                int yOffs = (InventoryMenu.ITEM_SIZE - size) / 2 + 10;
                g.drawImage(ResourceManager.food, xOffs, yOffs, size, size, null);

                String str = count + "x";
                FontMetrics metrics = getFontMetrics(this.getFont());
                int w = metrics.stringWidth(str);

                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.drawString(str, (InventoryMenu.ITEM_SIZE - w) / 2, metrics.getHeight() + 92);
            }
        } else if (type == Type.PART_STORE) {
            g.drawImage(ResourceManager.flareGunSlot, 0, 0, InventoryMenu.ITEM_SIZE, InventoryMenu.ITEM_SIZE, null);

            int xOffs;
            int yOffs;
            int w;
            int h;

            if (partStore.getCount() > 0) {
                xOffs = 36;
                yOffs = 33;
                w = 55;
                h = 37;
                g.drawImage(ResourceManager.flareGun, xOffs, yOffs, w, h, null);

                if (partStore.getCount() > 1) {
                    xOffs = 32;
                    yOffs = 98;
                    w = 20;
                    h = 20;
                    g.drawImage(ResourceManager.flareLight, xOffs, yOffs, w, h, null);
                }
                if (partStore.getCount() > 2) {
                    xOffs = 80;
                    yOffs = 98;
                    w = 12;
                    h = 20;
                    g.drawImage(ResourceManager.flare, xOffs, yOffs, w, h, null);
                }
            }

        } else if (type == Type.TENTKIT_STORE) {
            g.drawImage(ResourceManager.tentKitSlot, 0, 0, InventoryMenu.ITEM_SIZE, InventoryMenu.ITEM_SIZE, null);

            if (tentkitStore.getCount() > 0) {
                int size = 64;
                int xOffs = (InventoryMenu.ITEM_SIZE - size) / 2;
                int yOffs = (InventoryMenu.ITEM_SIZE - size) / 2 + 12;
                g.drawImage(ResourceManager.tentKit, xOffs, yOffs, size, size, null);


                String str = tentkitStore.getCount() + "x";
                FontMetrics metrics = getFontMetrics(this.getFont());
                int w = metrics.stringWidth(str);

                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.drawString(str, (InventoryMenu.ITEM_SIZE - w) / 2, metrics.getHeight() + 92);
            }
        }
    }

    /**
     * Klikk katására equip lesz.
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        equip();
    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
