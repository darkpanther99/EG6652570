package grafikus;

import grafikus.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A játékos cselekvéseket kiválasztó UI elem.
 */
public class ActionsMenu extends JPanel implements ActionListener {
    private final Controller controller;

    // A különböző gombokhoz tartozó ActionCommandok kódjai:
    private static final String AC_STEP = "step";
    private static final String AC_EXAMINE = "examine";
    private static final String AC_RESCUE = "rescue";
    private static final String AC_DIG = "dig";
    private static final String AC_PICK_UP = "pick_up";
    private static final String AC_BUILD = "build";
    private static final String AC_ASSEMBLE = "assemble";
    private static final String AC_NEXT_TURN = "next_turn";
    private static final String AC_EAT = "eat";

    // A tartalmazott gombok:
    private final MenuButton stepButton;
    private final MenuButton examineButton;
    private final MenuButton rescueButton;
    private final MenuButton digButton;
    private final MenuButton pickupButton;
    private final MenuButton buildButton;
    private final MenuButton assembleButton;
    private final MenuButton newTurnButton;
    private final MenuButton eatButton;

    /**
     * @param controller Megkapja a vezérlőt, mint dependency injection.
     */
    public ActionsMenu(Controller controller) {
        this.controller = controller;

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 16));

        stepButton = new MenuButton("Step");
        stepButton.setActionCommand(AC_STEP);
        stepButton.addActionListener(this);
        this.add(stepButton);

        examineButton = new MenuButton("Examine");
        examineButton.setActionCommand(AC_EXAMINE);
        examineButton.addActionListener(this);
        this.add(examineButton);

        rescueButton = new MenuButton("Rescue");
        rescueButton.setActionCommand(AC_RESCUE);
        rescueButton.addActionListener(this);
        this.add(rescueButton);

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

    /**
     * Frissíti a megjelenített cselekvéseket.
     */
    public void update() {
        this.repaint();
    }

    /**
     * Ásás cselekvés.
     */
    private void doDig() {
        controller.selectedPlayer.dig();
    }

    /**
     * Tárgy felvétele cselekvés.
     */
    private void doPickUp() {
        // NOTE(boti): ez is a rajzoláshoz kell, kicsit hacky.
        Tile t = controller.selectedPlayer.getCurrentTile();
        if (t.getItem() instanceof Part) {
            controller.foundParts++;
        }

        controller.selectedPlayer.pickUp();
    }

    /**
     * Iglu/sátor építése cselekvés.
     */
    private void doBuild() {
        controller.selectedPlayer.build();
    }

    /**
     * Evés cselekvés.
     */
    private void doEat() {
        controller.selectedPlayer.eatFood();
    }

    /**
     * Lépés cselekvés.
     * A Controller választja ki, hogy hova lépünk.
     */
    private void doStep() {
        controller.mode = Controller.Mode.STEP;
    }

    /**
     * Felderítés cselekvés.
     * A Controller választja ki, hogy hol derítünk fel.
     */
    private void doExamine() {
        if (controller.mode == Controller.Mode.EXAMINE) controller.mode = Controller.Mode.STEP;
        else controller.mode = Controller.Mode.EXAMINE;
    }

    /**
     * Kimentés cselekvés.
     * A Controller választja ki, hogy honnan mentünk ki.
     */
    private void doRescue() {
        if (controller.mode == Controller.Mode.RESCUE) controller.mode = Controller.Mode.STEP;
        else controller.mode = Controller.Mode.RESCUE;
    }

    /**
     * Rakétapisztoly összeszerelése cselekvés.
     */
    private void doAssemble() {
        controller.selectedPlayer.assembleFlare();
    }

    /**
     * Új kör kezdése.
     */
    private void doNextTurn() {
        controller.nextTurn();
    }

    /**
     * A gombnyomás események kezelése.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contentEquals(AC_STEP)) {
            doStep();
        } else if (e.getActionCommand().contentEquals(AC_EXAMINE)) {
            doExamine();
        } else if (e.getActionCommand().contentEquals(AC_DIG)) {
            doDig();
        } else if (e.getActionCommand().contentEquals(AC_PICK_UP)) {
            doPickUp();
        } else if (e.getActionCommand().contentEquals(AC_BUILD)) {
            doBuild();
        } else if (e.getActionCommand().contentEquals(AC_RESCUE)) {
            doRescue();
        } else if (e.getActionCommand().contentEquals(AC_ASSEMBLE)) {
            doAssemble();
        } else if (e.getActionCommand().contentEquals(AC_NEXT_TURN)) {
            doNextTurn();
        } else if (e.getActionCommand().contentEquals(AC_EAT)) {
            doEat();
        }

        controller.update();
    }

    /**
     * Háttér rajzolása.
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawImage(ResourceManager.buttonSlot, 0, 0, getWidth(), getHeight(), null);

        paintChildren(g);
    }

    /**
     * Egyedi megjelenésű gomb.
     */
    private class MenuButton extends JButton {
        public MenuButton(String text) {
            super(text);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;

            boolean isEnabled = true;

            if(!getActionCommand().contentEquals(AC_NEXT_TURN) && controller.selectedPlayer.getEnergy() <= 0) {
                isEnabled = false;
            }

            if(getActionCommand().contentEquals(AC_EXAMINE) &&
                    controller.selectedPlayer instanceof Eskimo) {
                isEnabled = false;
            } else if(getActionCommand().contentEquals(AC_RESCUE) &&
                    controller.selectedPlayer.getRescueStrategy() instanceof CantRescue) {
                isEnabled = false;
            } else if(getActionCommand().contentEquals(AC_EAT) &&
                    controller.selectedPlayer.getFoodStore().getCount() <= 0) {
                isEnabled = false;
            } else if(getActionCommand().contentEquals(AC_BUILD) &&
                    controller.selectedPlayer instanceof PolarExplorer &&
                    controller.selectedPlayer.getBuildStrategy().getCount() <= 0) {
                isEnabled = false;
            }

            // Gomb hatter
            if(isEnabled) {
                g2.setColor(Color.LIGHT_GRAY);
            } else {
                g2.setColor(Color.DARK_GRAY);
            }
            g2.fillRect(0, 0, getWidth(), getHeight());

            // Mode
            if((getActionCommand().contentEquals(AC_STEP) && controller.mode == Controller.Mode.STEP) ||
               (getActionCommand().contentEquals(AC_EXAMINE) && controller.mode == Controller.Mode.EXAMINE) ||
               (getActionCommand().contentEquals(AC_RESCUE)) && controller.mode == Controller.Mode.RESCUE) {
                g2.setColor(Color.RED);
                g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            }

            // Szoveg
            FontMetrics metrics = getFontMetrics(getFont());

            int x = (getWidth() - metrics.stringWidth(getText())) / 2;
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g2.setColor(Color.BLACK);
            g2.drawString(getText(), x, y);
        }
    }
}
