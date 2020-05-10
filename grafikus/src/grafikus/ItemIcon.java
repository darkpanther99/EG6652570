package grafikus;

import grafikus.model.Item;
import grafikus.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ItemIcon extends JPanel implements MouseListener {
    public Item item;
    public Controller controller;
    public boolean isEquipped;

    public ItemIcon(Item item, Controller controller, boolean isEquipped) {
        super();
        Dimension d = new Dimension(InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE);
        setPreferredSize(d);
        setMinimumSize(d);

        this.item = item;
        this.controller = controller;
        this.isEquipped = isEquipped;
        addMouseListener(this);
    }

    public void equip(){
        if(isEquipped) return;
        Player p = controller.selectedPlayer;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(ResourceManager.imageEntity, 0,0, InventoryMenu.ITEMSIZE, InventoryMenu.ITEMSIZE, null);
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
