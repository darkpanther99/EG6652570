package grafikus;

import grafikus.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Egy játékost reprezentáló UI elem a PlayerListMenuben.
 */
public class PlayerIcon extends JPanel implements MouseListener {
    private final Controller controller;
    private PlayerSelectListener psl;
    public final Player player;
    public boolean isSelected = false;

    /**
     * @param controller Megkapja a vezérlőt, mint dependency injection.
     * @param player     A játékos.
     * @param isSelected Éppen ki van-e választva?
     */
    public PlayerIcon(Controller controller, Player player, boolean isSelected) {
        super();

        Dimension d = new Dimension(PlayerListMenu.PLAYER_ICON_SIZE, PlayerListMenu.PLAYER_ICON_SIZE);
        setPreferredSize(d);
        setMinimumSize(d);

        this.controller = controller;
        this.player = player;
        this.isSelected = isSelected;
        addMouseListener(this);
    }

    /**
     * Frissíti a kirajzolt számokat.
     */
    public void update() {
        repaint();
    }

    /**
     * Feliratkozás a PlayerSelect eseményre.
     */
    public void addPlayerSelectListener(PlayerSelectListener psl) {
        this.psl = psl;
    }

    /**
     * A megfelelő ikon kirajzolása.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(ResourceManager.playerSlot, 0, 0, PlayerListMenu.PLAYER_ICON_SIZE, PlayerListMenu.PLAYER_ICON_SIZE, null);
        if (player instanceof EskimoView) {
            g.drawImage(((EskimoView) player).iconImage,
                    PlayerListMenu.PLAYER_ICON_SIZE / 4 + PlayerListMenu.PLAYER_ICON_SIZE / 9,
                    PlayerListMenu.PLAYER_ICON_SIZE / 4 - PlayerListMenu.PLAYER_ICON_SIZE / 11,
                    PlayerListMenu.PLAYER_ICON_SIZE / 4,
                    PlayerListMenu.PLAYER_ICON_SIZE / 4,
                    null);
        }
        if (player instanceof ExplorerView) {
            g.drawImage(((ExplorerView) player).iconImage,
                    PlayerListMenu.PLAYER_ICON_SIZE / 4 + PlayerListMenu.PLAYER_ICON_SIZE / 9,
                    PlayerListMenu.PLAYER_ICON_SIZE / 4 - PlayerListMenu.PLAYER_ICON_SIZE / 11,
                    PlayerListMenu.PLAYER_ICON_SIZE / 4,
                    PlayerListMenu.PLAYER_ICON_SIZE / 4,
                    null);
        }
        if (isSelected) {
            g.drawImage(ResourceManager.selectedPlayer,
                    0,
                    0,
                    PlayerListMenu.PLAYER_ICON_SIZE,
                    PlayerListMenu.PLAYER_ICON_SIZE,
                    null);
        }

        int hp = Math.max(0, Math.min(5, player.getBodyTemp()));
        int energy = Math.max(0, Math.min(5, player.getEnergy()));
        g.drawImage(ResourceManager.imageHP[hp],
                PlayerListMenu.PLAYER_ICON_SIZE / 4,
                PlayerListMenu.PLAYER_ICON_SIZE / 2 + 10,
                PlayerListMenu.PLAYER_ICON_SIZE / 2,
                12,
                null);

        g.drawImage(ResourceManager.imageEnergy[energy],
                PlayerListMenu.PLAYER_ICON_SIZE / 4,
                PlayerListMenu.PLAYER_ICON_SIZE / 2 + 25,
                PlayerListMenu.PLAYER_ICON_SIZE / 2,
                12,
                null);

    }

    /**
     * Klikkelés hatására ki lesz választva.
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        psl.select(this.player);
    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    /**
     * Nem használjuk.
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
