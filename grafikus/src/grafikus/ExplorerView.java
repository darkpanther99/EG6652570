package grafikus;

import grafikus.model.Game;
import grafikus.model.PolarExplorer;

import java.awt.*;

public class ExplorerView extends PolarExplorer {

    private static int explorerCount = 0;

    public final Image playerImage;
    public final Image iconImage;

    public ExplorerView(Game g) {
        super(g);

        iconImage = ResourceManager.explorer[explorerCount % 3];
        playerImage = ResourceManager.explorerPlayer[explorerCount % 3];

        explorerCount++;
    }
}
