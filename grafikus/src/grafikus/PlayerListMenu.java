package grafikus;

import grafikus.model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerListMenu extends JPanel implements PlayerSelectListener{
    public static final int PLAYERICONSIZE = 64;
    public Controller controller;
    public ArrayList<PlayerIcon> iconlist;

    public PlayerListMenu(Controller controller) {
        super();
        this.controller = controller;
        this.iconlist = new ArrayList<>();

        for (Player p : controller.game.getPlayers()) {
            PlayerIcon pi = new PlayerIcon(controller, p, false);
            pi.addPlayerSelectListener(this);
            if(controller.selectedPlayer == p){
                pi.isSelected = true;
            }
            iconlist.add(pi);
            this.add(pi);
        }

        Dimension d = new Dimension(100, Controller.SCREEN_HEIGHT);
        setPreferredSize(d);
        setMinimumSize(d);
    }

    public void update(){
        for (PlayerIcon pi : iconlist) {
            pi.isSelected = pi.player == controller.selectedPlayer;
            pi.update();
        }
    }

    public void select(Player p){
        controller.selectedPlayer = p;
        controller.update();
    }

    public void deselect(Player p){
        //TODO p = controller.getNextPlayer();
        // select(p);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(ResourceManager.emptyPlayerSlot, 0,0, 100, Controller.SCREEN_HEIGHT, null);
        paintChildren(g);
    }
}
