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
        addMouseListener(this);
    }

    public void update(){
        repaint();
    }

    public void addPlayerSelectListener(PlayerSelectListener psl){
        this.psl = psl;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(ResourceManager.playerSlot, 0,0, PlayerListMenu.PLAYERICONSIZE, PlayerListMenu.PLAYERICONSIZE, null);
        if(player instanceof EskimoView) {
            g.drawImage(((EskimoView) player).iconImage,
                    PlayerListMenu.PLAYERICONSIZE / 4 + PlayerListMenu.PLAYERICONSIZE / 9,
                    PlayerListMenu.PLAYERICONSIZE / 4 - PlayerListMenu.PLAYERICONSIZE / 11,
                    PlayerListMenu.PLAYERICONSIZE / 4,
                    PlayerListMenu.PLAYERICONSIZE / 4,
                    null);
        }
        if(player instanceof ExplorerView){
            g.drawImage(((ExplorerView) player).iconImage,
                    PlayerListMenu.PLAYERICONSIZE / 4 + PlayerListMenu.PLAYERICONSIZE / 9,
                    PlayerListMenu.PLAYERICONSIZE / 4 - PlayerListMenu.PLAYERICONSIZE / 11,
                    PlayerListMenu.PLAYERICONSIZE / 4,
                    PlayerListMenu.PLAYERICONSIZE / 4,
                    null);
        }
        if(isSelected){
            g.drawImage(ResourceManager.selectedPlayer,
                    0,
                    0,
                    PlayerListMenu.PLAYERICONSIZE,
                    PlayerListMenu.PLAYERICONSIZE,
                    null);
        }

        int hp = Math.max(0, Math.min(5,player.getBodyTemp()));
        int energy = Math.max(0, Math.min(5, player.getEnergy()));
        g.drawImage(ResourceManager.imageHP[hp],
                PlayerListMenu.PLAYERICONSIZE/4,
                PlayerListMenu.PLAYERICONSIZE / 2 + 10,
                PlayerListMenu.PLAYERICONSIZE/2,
                12,
                null);

        g.drawImage(ResourceManager.imageEnergy[energy],
                PlayerListMenu.PLAYERICONSIZE/4,
                PlayerListMenu.PLAYERICONSIZE / 2 + 25,
                PlayerListMenu.PLAYERICONSIZE/2,
                12,
                null);

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
