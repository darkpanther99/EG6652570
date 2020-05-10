package grafikus;

import javax.swing.*;
import java.awt.event.*;

public class ActionsMenu extends JPanel implements ActionListener {

    private static final String AC_DIG = "dig";
    private static final String AC_BUILD = "build";
    private static final String AC_RESCUE = "rescue";
    private static final String AC_ASSEMBLE = "assemble";
    private static final String AC_EXIT = "exit";
    private static final String AC_NEW_TURN = "new_turn";

    private Controller controller;

    private JButton digButton;
    private JButton buildButton;
    private JButton rescueButton;
    private JButton assembleButton;
    private JButton exitButton;
    private JButton newTurnButton;


    public ActionsMenu(Controller controller) {
        this.controller = controller;

        digButton = new JButton();
        digButton.setActionCommand(AC_DIG);
        digButton.addActionListener(this);
        this.add(digButton);

        buildButton = new JButton();
        buildButton.setActionCommand(AC_BUILD);
        buildButton.addActionListener(this);
        this.add(buildButton);

        rescueButton = new JButton();
        rescueButton.setActionCommand(AC_RESCUE);
        rescueButton.addActionListener(this);
        this.add(rescueButton);

        assembleButton = new JButton();
        assembleButton.setActionCommand(AC_ASSEMBLE);
        assembleButton.addActionListener(this);
        this.add(assembleButton);

        exitButton = new JButton();
        exitButton.setActionCommand(AC_EXIT);
        exitButton.addActionListener(this);
        this.add(exitButton);

        newTurnButton = new JButton();
        newTurnButton.setActionCommand(AC_NEW_TURN);
        newTurnButton.addActionListener(this);
        this.add(newTurnButton);
    }

    public void update() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
