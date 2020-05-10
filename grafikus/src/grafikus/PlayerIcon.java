package grafikus;

import grafikus.model.Eskimo;
import grafikus.model.Player;
import grafikus.model.PolarExplorer;

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

        Dimension d = new Dimension(PlayerListMenu.PLAYERICONSIZE, PlayerListMenu.PLAYERICONSIZE);
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
        g.drawImage(ResourceManager.playerSlot, 0,0, PlayerListMenu.PLAYERICONSIZE, PlayerListMenu.PLAYERICONSIZE, null);
        if(player instanceof Eskimo){
            g.drawImage(ResourceManager.eskimo,
                    PlayerListMenu.PLAYERICONSIZE / 2 - 15,
                    PlayerListMenu.PLAYERICONSIZE / 2 - 30,
                    30,
                    30,
                    null);
        }
        if(player instanceof PolarExplorer){
            g.drawImage(ResourceManager.explorer,
                    PlayerListMenu.PLAYERICONSIZE / 2 - 15,
                    PlayerListMenu.PLAYERICONSIZE / 2 - 30,
                    30,
                    30,
                    null);
        }

        int hp = player.getBodyTemp();
        int energy = player.getEnergy();
        g.drawImage(ResourceManager.imageHP[hp],
                0,
                PlayerListMenu.PLAYERICONSIZE / 2 + 5,
                PlayerListMenu.PLAYERICONSIZE,
                10,
                null);

        g.drawImage(ResourceManager.imageEnergy[energy],
                0,
                PlayerListMenu.PLAYERICONSIZE / 2 + 20,
                PlayerListMenu.PLAYERICONSIZE,
                10,
                null);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        psl.select(this.player);
        System.out.print("debug click\n");
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
