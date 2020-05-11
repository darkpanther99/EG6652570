package grafikus;

import grafikus.model.*;

import java.awt.*;

public class EskimoView extends Eskimo {

    private static int eskimoCount = 0;

    public Image playerImage;
    public Image iconImage;

    public EskimoView(Game g) {
        super(g);

        iconImage = ResourceManager.eskimo[eskimoCount % 3];
        playerImage = ResourceManager.eskimoPlayer[eskimoCount % 3];

        eskimoCount++;
    }
}
