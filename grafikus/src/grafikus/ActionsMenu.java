package grafikus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;

public class ActionsMenu extends JPanel implements ActionListener {

    class MenuButton extends JButton {
        public MenuButton(String text) {
            super(text);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.drawImage(ResourceManager.buttonSlot, 0, 0, getWidth(), getHeight(), null);
            FontMetrics metrics = getFontMetrics(getFont());

            g2.setColor(Color.BLACK);
            g2.drawString(getText(), 0, getHeight() / 2 + metrics.getHeight() / 4);
        }
    }

    private static final String AC_DIG = "dig";
    private static final String AC_BUILD = "build";
    private static final String AC_RESCUE = "rescue";
    private static final String AC_ASSEMBLE = "assemble";
    private static final String AC_EXIT = "exit";
    private static final String AC_NEXT_TURN = "next_turn";
    private static final String AC_EAT = "eat";

    private Controller controller;

    private MenuButton digButton;
    private MenuButton buildButton;
    private MenuButton rescueButton;
    private MenuButton assembleButton;
    private MenuButton exitButton;
    private MenuButton newTurnButton;
    private MenuButton eatButton;


    public ActionsMenu(Controller controller) {
        this.controller = controller;

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        digButton = new MenuButton("Dig");
        digButton.setActionCommand(AC_DIG);
        digButton.addActionListener(this);
        this.add(digButton);

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

        exitButton = new MenuButton("Exit");
        exitButton.setActionCommand(AC_EXIT);
        exitButton.addActionListener(this);
        this.add(exitButton);

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

    public void doBuild() {
        controller.selectedPlayer.build();
    }

    public void doEat() {
        controller.selectedPlayer.eatFood();;
    }

    public void doRescue() {
        // TODO
        controller.selectedPlayer.rescueTeammate(0);
    }

    public void doAssemble() {
        controller.selectedPlayer.assembleFlare();
    }

    public void exit() {
        // TODO
    }

    public void nextTurn() {
        controller.nextTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().contentEquals(AC_DIG)) {
            doDig();
        } else if(e.getActionCommand().contentEquals(AC_BUILD)) {
            doBuild();
        } else if(e.getActionCommand().contentEquals(AC_RESCUE)) {
            doRescue();
        } else if(e.getActionCommand().contentEquals(AC_ASSEMBLE)) {
            doAssemble();
        } else if(e.getActionCommand().contentEquals(AC_EXIT)) {
            exit();
        } else if(e.getActionCommand().contentEquals(AC_NEXT_TURN)) {
            nextTurn();
        } else if(e.getActionCommand().contentEquals(AC_EAT)) {
            doEat();
        }

        controller.update();
    }
}
