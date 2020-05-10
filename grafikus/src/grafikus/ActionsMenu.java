package grafikus;

import javax.swing.*;
import java.awt.event.*;

public class ActionsMenu extends JPanel implements ActionListener {

    private static final String AC_DIG = "dig";
    private static final String AC_BUILD = "build";
    private static final String AC_RESCUE = "rescue";
    private static final String AC_ASSEMBLE = "assemble";
    private static final String AC_EXIT = "exit";
    private static final String AC_NEXT_TURN = "next_turn";

    private Controller controller;

    private JButton digButton;
    private JButton buildButton;
    private JButton rescueButton;
    private JButton assembleButton;
    private JButton exitButton;
    private JButton newTurnButton;



    public ActionsMenu(Controller controller) {
        this.controller = controller;

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        digButton = new JButton("Dig");
        digButton.setActionCommand(AC_DIG);
        digButton.addActionListener(this);
        this.add(digButton);

        buildButton = new JButton("Build");
        buildButton.setActionCommand(AC_BUILD);
        buildButton.addActionListener(this);
        this.add(buildButton);

        rescueButton = new JButton("Rescue");
        rescueButton.setActionCommand(AC_RESCUE);
        rescueButton.addActionListener(this);
        this.add(rescueButton);

        assembleButton = new JButton("Assemble");
        assembleButton.setActionCommand(AC_ASSEMBLE);
        assembleButton.addActionListener(this);
        this.add(assembleButton);

        exitButton = new JButton("Exit");
        exitButton.setActionCommand(AC_EXIT);
        exitButton.addActionListener(this);
        this.add(exitButton);

        newTurnButton = new JButton("Next turn");
        newTurnButton.setActionCommand(AC_NEXT_TURN);
        newTurnButton.addActionListener(this);
        this.add(newTurnButton);
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
        }
    }

    //public void paint
}
