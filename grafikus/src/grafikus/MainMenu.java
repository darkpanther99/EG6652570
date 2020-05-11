package grafikus;

import grafikus.mapgen.MapGen;
import grafikus.model.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Dimension;

public class MainMenu extends JFrame implements WindowListener, ChangeListener, ActionListener, GameObserver {

    private static final String AC_NEW_GAME = "NewGame";

    private Controller controller;
    private int numEskimos = 3;
    private int numExplorers = 3;

    private JSpinner eskimoSpinner;
    private JSpinner explorerSpinner;

    public MainMenu() {
        setMinimumSize(new Dimension(400, 200));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.LINE_AXIS));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));

        eskimoSpinner = new JSpinner();
        eskimoSpinner.setValue(numEskimos);
        eskimoSpinner.addChangeListener(this);
        explorerSpinner = new JSpinner();
        explorerSpinner.setValue(numExplorers);
        explorerSpinner.addChangeListener(this);



        leftPanel.add(new JLabel("Eszkimók száma"));
        rightPanel.add(eskimoSpinner);
        leftPanel.add(new JLabel("Sarkkutatók száma"));
        rightPanel.add(explorerSpinner);

        menuPanel.add(leftPanel);
        menuPanel.add(rightPanel);

        mainPanel.add(menuPanel);

        JButton buttonNewGame = new JButton("New Game");
        buttonNewGame.setActionCommand(AC_NEW_GAME);
        buttonNewGame.addActionListener(this);
        mainPanel.add(buttonNewGame);

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    public Game createGame() {
        return new Game();
    }

    Controller createController(Game game) {
        this.controller = new Controller(game);
        return controller;
    }

    @Override
    public void victory() {
        controller.dispatchEvent(new WindowEvent(controller, WindowEvent.WINDOW_CLOSING));
        JOptionPane.showMessageDialog(this, "You're winner!");
    }

    @Override
    public void gameOver() {
        controller.dispatchEvent(new WindowEvent(controller, WindowEvent.WINDOW_CLOSING));
        JOptionPane.showMessageDialog(this, "A player die, game over!");
    }

    @Override
    public void explore(Tile t) {
        // Empty
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().contentEquals(AC_NEW_GAME)) {
            Game game = createGame();
            game.subscribe(this);

            for(int i = 0; i < numEskimos; i++) {
                game.createEskimo();
            }

            for(int i = 0; i < numExplorers; i++) {
                game.createPolarExplorer();
            }

            game.createPolarBear();

            MapGen.generateMap(game);

            createController(game);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        numEskimos = (Integer)eskimoSpinner.getValue();
        numExplorers = (Integer)explorerSpinner.getValue();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }
}
