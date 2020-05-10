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
            PlayerIcon pi = new PlayerIcon(controller, this, p, false);
            if(controller.selectedPlayer == p){
                pi.isSelected = true;
            }
            iconlist.add(pi);
        }

        Dimension d = new Dimension(100, Controller.SCREEN_HEIGHT);
        setPreferredSize(d);
        setMinimumSize(d);
    }

    public void update(){

    }

    public void select(Player p){
        controller.selectedPlayer = p;
        controller.update();
    }

    public void deselect(Player p){

    }
}
