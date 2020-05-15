package grafikus;

import grafikus.model.Game;
import grafikus.model.GameObserver;
import grafikus.model.Tile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainMenu extends JFrame implements WindowListener, ChangeListener, ActionListener, GameObserver {

    private static final String AC_NEW_GAME = "NewGame";

    private Controller controller;
    private int numEskimos = 3;
    private int numExplorers = 3;
    private int numBears = 1;
    private int numRows = 7;
    private int numCols = 10;

    private final JSpinner eskimoSpinner;
    private final JSpinner explorerSpinner;
    private final JSpinner bearSpinner;
    private final JSpinner rowSpinner;
    private final JSpinner colSpinner;

    public MainMenu() {
        setMinimumSize(new Dimension(400, 200));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(20, 20));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 20, 10));

        mainPanel.add(new JLabel("Eszkimók száma:"));
        eskimoSpinner = new JSpinner();
        eskimoSpinner.setValue(numEskimos);
        eskimoSpinner.addChangeListener(this);
        mainPanel.add(eskimoSpinner);

        mainPanel.add(new JLabel("Sarkkutatók száma:"));
        explorerSpinner = new JSpinner();
        explorerSpinner.setValue(numExplorers);
        explorerSpinner.addChangeListener(this);
        mainPanel.add(explorerSpinner);

        mainPanel.add(new JLabel("Medvék száma:"));
        bearSpinner = new JSpinner();
        bearSpinner.setValue(numBears);
        bearSpinner.addChangeListener(this);
        mainPanel.add(bearSpinner);

        mainPanel.add(new JLabel("Sorok száma:"));
        rowSpinner = new JSpinner();
        rowSpinner.setValue(numRows);
        rowSpinner.addChangeListener(this);
        mainPanel.add(rowSpinner);

        mainPanel.add(new JLabel("Oszlopok száma:"));
        colSpinner = new JSpinner();
        colSpinner.setValue(numCols);
        colSpinner.addChangeListener(this);
        mainPanel.add(colSpinner);

        JButton buttonNewGame = new JButton("New Game");
        buttonNewGame.setActionCommand(AC_NEW_GAME);
        buttonNewGame.addActionListener(this);
        this.add(buttonNewGame, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.pack();
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenDim.width - getWidth()) / 2, (screenDim.height - getHeight()) / 2);
        this.setVisible(true);
    }

    public Game createGame() {
        return new Game();
    }

    Controller createController(Game game) {
        this.controller = new Controller(game, numRows, numCols);
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
        JOptionPane.showMessageDialog(this, "A player died, game over!");
    }

    @Override
    public void explore(Tile t) {
        // Empty
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contentEquals(AC_NEW_GAME)) {
            Game game = createGame();
            game.subscribe(this);

            // NOTE(boti):
            //  Bypass-oljuk a game create*() fv-nyeit, mert
            //  azok nem view-kat hoznak letre
            for (int i = 0; i < numEskimos; i++) {
                EskimoView eskimo = new EskimoView(game);
                game.getPlayers().add(eskimo);
            }

            for (int i = 0; i < numExplorers; i++) {
                ExplorerView explorer = new ExplorerView(game);
                game.getPlayers().add(explorer);
            }

            for (int i = 0; i < numBears; i++) {
                game.createPolarBear();
            }

            MapGen.generateMap(game, numRows, numCols);

            createController(game);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        numEskimos = (Integer) eskimoSpinner.getValue();
        numExplorers = (Integer) explorerSpinner.getValue();
        numBears = (Integer) bearSpinner.getValue();
        numRows = (Integer) rowSpinner.getValue();
        numCols = (Integer) colSpinner.getValue();
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
