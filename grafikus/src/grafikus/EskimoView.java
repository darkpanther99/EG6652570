package grafikus;

import grafikus.model.Eskimo;
import grafikus.model.Game;

import java.awt.*;

/**
 * Az eszkimó grafikus megjelenítésére szolgál.
 */
public class EskimoView extends Eskimo {

    /**
     * Igyekszik mindig másik textúrát választani, e statikus számláló szerint.
     */
    private static int eskimoCount = 0;

    // Ezek a képek jelennek meg az eszkimóhoz.
    public final Image playerImage;
    public final Image iconImage;

    public EskimoView(Game g) {
        super(g);

        iconImage = ResourceManager.eskimo[eskimoCount % ResourceManager.eskimo.length];
        playerImage = ResourceManager.eskimoPlayer[eskimoCount % ResourceManager.eskimoPlayer.length];

        eskimoCount++;
    }
}
