package grafikus;

import grafikus.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayerIcon extends JPanel implements MouseListener {
    public Controller controller;
    public Player player;
    public PlayerSelectListener psl;
    public boolean isSelected = false;

    public PlayerIcon(Controller controller, Player player, boolean isSelected) {
        super();

        Dimension d = new Dimension(PlayerListMenu.PLAYERICONSIZE, PlayerListMenu.PLAYERICONSIZE + 40);
        setPreferredSize(d);
        setMinimumSize(d);

        this.controller = controller;
        this.player = player;
        this.isSelected = isSelected;
    }

    public void update(){
        if(player.getEnergy() <= 0) psl.deselect(this.player);
        repaint();
    }

    public void addPlayerSelectListener(PlayerSelectListener psl){
        this.psl = psl;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(ResourceManager.player, 0,0, PlayerListMenu.PLAYERICONSIZE, PlayerListMenu.PLAYERICONSIZE, null);
        g.drawImage(ResourceManager.imageHP[1], 0,PlayerListMenu.PLAYERICONSIZE + 5, PlayerListMenu.PLAYERICONSIZE, 10, null);
        g.drawImage(ResourceManager.imageEnergy[1], 0,PlayerListMenu.PLAYERICONSIZE + 20, PlayerListMenu.PLAYERICONSIZE, 10, null);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        psl.select(this.player);
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
