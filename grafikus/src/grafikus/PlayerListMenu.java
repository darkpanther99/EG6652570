package grafikus;

import grafikus.model.Player;

import javax.swing.*;

public class PlayerListMenu extends JPanel implements PlayerSelectListener{
    public static final int PLAYERICONSIZE = 64;
    public Controller controller;

    public PlayerListMenu(Controller controller) {
        this.controller = controller;

    }

    public void update(){

    }

    public void select(Player p){

    }

    public void deselect(Player p){

    }
}
