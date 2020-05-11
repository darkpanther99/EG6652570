package grafikus;

import grafikus.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.util.Map;

public class ActionsMenu extends JPanel implements ActionListener {

    class MenuButton extends JButton {
        public MenuButton(String text) {
            super(text);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.DARK_GRAY);
            g2.fillRect(0, 0, getWidth(), getHeight());

            FontMetrics metrics = getFontMetrics(getFont());

            int x = (getWidth() - metrics.stringWidth(getText())) / 2;
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g2.setColor(Color.BLACK);
            g2.drawString(getText(), x, y);
        }
    }

    private static final String AC_DIG = "dig";
    private static final String AC_PICK_UP = "pick_up";
    private static final String AC_BUILD = "build";
    private static final String AC_RESCUE = "rescue";
    private static final String AC_ASSEMBLE = "assemble";
    private static final String AC_NEXT_TURN = "next_turn";
    private static final String AC_EAT = "eat";

    private Controller controller;

    private MenuButton digButton;
    private MenuButton pickupButton;
    private MenuButton buildButton;
    private MenuButton rescueButton;
    private MenuButton assembleButton;
    private MenuButton newTurnButton;
    private MenuButton eatButton;


    public ActionsMenu(Controller controller) {
        this.controller = controller;

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 16));

        digButton = new MenuButton("Dig");
        digButton.setActionCommand(AC_DIG);
        digButton.addActionListener(this);
        this.add(digButton);

        pickupButton = new MenuButton("Pick up");
        pickupButton.setActionCommand(AC_PICK_UP);
        pickupButton.addActionListener(this);
        this.add(pickupButton);

        buildButton = new MenuButton("Build");
        buildButton.setActionCommand(AC_BUILD);
        buildButton.addActionListener(this);
        this.add(buildButton);

        rescueButton = new MenuButton("Rescue");
        rescueButton.setActionCommand(AC_RESCUE);
        rescueButton.addActionListener(this);
        this.add(rescueButton);

        assembleButton = new MenuButton("Assemble");
        assembleButton.setActionCommand(AC_ASSEMBLE);
        assembleButton.addActionListener(this);
        this.add(assembleButton);

        newTurnButton = new MenuButton("Next turn");
        newTurnButton.setActionCommand(AC_NEXT_TURN);
        newTurnButton.addActionListener(this);
        this.add(newTurnButton);

        eatButton = new MenuButton("Eat");
        eatButton.setActionCommand(AC_EAT);
        eatButton.addActionListener(this);
        this.add(eatButton);
    }

    public void update() {
        this.repaint();
    }

    public void doDig() {
        controller.selectedPlayer.dig();
    }

    public void doPickUp() {
        // NOTE(boti): ez is a rajzolashoz kell, kicsit hacky.
        Tile t = controller.selectedPlayer.getCurrentTile();
        if(t.getItem() instanceof Part) {
            controller.foundParts++;
        }

        controller.selectedPlayer.pickUp();
    }

    public void doBuild() {
        controller.selectedPlayer.build();
    }

    public void doEat() {
        controller.selectedPlayer.eatFood();;
    }

    public void doRescue() {
        // TODO
        for (int i = 0; i < 4; i++) {
            if (controller.selectedPlayer.getCurrentTile().getNeighbor(i) != null) {
                Tile tmp = controller.selectedPlayer.getCurrentTile().getNeighbor(i);
                if (tmp.getWeightLimit() == 0 && tmp.getSnow() == 0) {
                    for (Entity e : tmp.getOccupants()) {
                        if (e instanceof Player)  {
                            controller.selectedPlayer.rescueTeammate(i);
                            i = 4;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void doAssemble() {
        controller.selectedPlayer.assembleFlare();
    }

    public void doNextTurn() {
        controller.nextTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().contentEquals(AC_DIG)) {
            doDig();
        } else if(e.getActionCommand().contentEquals(AC_PICK_UP)) {
            doPickUp();
        } else if(e.getActionCommand().contentEquals(AC_BUILD)) {
            doBuild();
        } else if(e.getActionCommand().contentEquals(AC_RESCUE)) {
            doRescue();
        } else if(e.getActionCommand().contentEquals(AC_ASSEMBLE)) {
            doAssemble();
        } else if(e.getActionCommand().contentEquals(AC_NEXT_TURN)) {
            doNextTurn();
        } else if(e.getActionCommand().contentEquals(AC_EAT)) {
            doEat();
        }

        controller.update();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawImage(ResourceManager.buttonSlot, 0, 0, getWidth(), getHeight(), null);

        paintChildren(g);
    }
}
