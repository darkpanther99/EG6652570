package grafikus;

import grafikus.model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerListMenu extends JPanel implements PlayerSelectListener{
    public static final int PLAYERICONSIZE = 128;
    public Controller controller;
    public ArrayList<PlayerIcon> iconlist;

    public PlayerListMenu(Controller controller) {
        super();

        this.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));

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

        Dimension d = new Dimension(PLAYERICONSIZE, 0);
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

        int height = getHeight();
        for(int y = iconlist.size()*PLAYERICONSIZE; y < height; y += PLAYERICONSIZE) {
            g.drawImage(ResourceManager.emptyPlayerSlot, 0, y, PLAYERICONSIZE, PLAYERICONSIZE, null);
        }

        paintChildren(g);
    }
}
