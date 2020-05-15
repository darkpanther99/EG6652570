package grafikus;

import grafikus.model.Eskimo;
import grafikus.model.Game;

import java.awt.*;

public class EskimoView extends Eskimo {

    private static int eskimoCount = 0;

    public final Image playerImage;
    public final Image iconImage;

    public EskimoView(Game g) {
        super(g);

        iconImage = ResourceManager.eskimo[eskimoCount % 3];
        playerImage = ResourceManager.eskimoPlayer[eskimoCount % 3];

        eskimoCount++;
    }
}
