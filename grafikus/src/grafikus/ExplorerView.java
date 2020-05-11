package grafikus;

import grafikus.model.*;

import java.awt.*;

public class ExplorerView extends PolarExplorer {

    private static int explorerCount = 0;

    public Image playerImage;
    public Image iconImage;

    public ExplorerView(Game g) {
        super(g);

        iconImage = ResourceManager.explorer[explorerCount % 3];
        playerImage = ResourceManager.explorerPlayer[explorerCount % 3];

        explorerCount++;
    }
}
