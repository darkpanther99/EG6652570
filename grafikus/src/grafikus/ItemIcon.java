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
        controller.update();
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
            if (item instanceof Shovel) {
                setToolTipText("Ásó, amivel kétszer lehet ásni energiavesztés nélkül.");
                img = ResourceManager.shovel;
                if (((Shovel) item).getInstance() == controller.selectedPlayer.getDigStrategy()) {
                    g.drawImage(ResourceManager.equippedItem, 0, 0, InventoryMenu.ITEM_SIZE, InventoryMenu.ITEM_SIZE, null);
                }
            } else if (item instanceof BreakingShovel) {
                setToolTipText("Ásó, amivel kétszer lehet ásni energiavesztés nélkül, viszont három használat után eltörik");
                img = ResourceManager.breakingShovel;
                if (((BreakingShovel) item).getInstance() == controller.selectedPlayer.getDigStrategy()) {
                    String str = ((BreakingShovelDig) (controller.selectedPlayer.getDigStrategy())).getDurability() + "x";
                    FontMetrics metrics = getFontMetrics(this.getFont());
                    int w = metrics.stringWidth(str);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setColor(Color.WHITE);
                    g2.drawString(str, (InventoryMenu.ITEM_SIZE - w) / 2, metrics.getHeight() + 92);
                    g.drawImage(ResourceManager.equippedItem, 0, 0, InventoryMenu.ITEM_SIZE, InventoryMenu.ITEM_SIZE, null);
                }
            } else if (item instanceof Rope) {
                setToolTipText("Kötél, amivel ki lehet menteni a vízbe esett játékostársakat.");
                img = ResourceManager.rope;
            } else if (item instanceof TentKit) {
                setToolTipText("Sátor, ideiglenes menedékhely a vihar elől.");
                img = ResourceManager.tentKit;
            } else if (item instanceof ScubaGear) {
                setToolTipText("Búvárruha, amivel hosszú ideig ki lehet bírni a fagyos vízben.");
                img = ResourceManager.scubaGear;
            } else img = ResourceManager.imageEntity;

            int size = InventoryMenu.ITEM_SIZE / 3;
            int xOffs = (InventoryMenu.ITEM_SIZE - size) / 2;
            int yOffs = (InventoryMenu.ITEM_SIZE - size) / 2 + 12;
            g.drawImage(img, xOffs, yOffs, size, size, null);
        } else if (type == Type.FOOD_STORE) {
            setToolTipText("Élelem, visszatölthető vele a testhő.");
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
            setToolTipText("A jelzőpisztoly alkatrészei, a játék megnyeréséhet össze kell gyűjteni mind a hármat.");
            g.drawImage(ResourceManager.flareGunSlot, 0, 0, InventoryMenu.ITEM_SIZE, InventoryMenu.ITEM_SIZE, null);
            if (partStore.getCount() > 0) {
                g.drawImage(ResourceManager.flareGun, 33, 22, 62, 62, null);
                if (partStore.getCount() > 1) {
                    g.drawImage(ResourceManager.flareLight, 20, 86, 44, 44, null);
                    if (partStore.getCount() > 2) {
                        g.drawImage(ResourceManager.flare, 63, 81, 45, 58, null);
                    }
                }
            }
        } else if (type == Type.TENTKIT_STORE) {
            setToolTipText("Sátor, ideiglenes menedékhely a vihar elől.");
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
