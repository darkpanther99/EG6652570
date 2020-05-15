package grafikus;

import grafikus.model.Game;
import grafikus.model.PolarExplorer;

import java.awt.*;

/**
 * A sarkkutató grafikus megjelenítésére szolgál.
 */
public class ExplorerView extends PolarExplorer {

    /**
     * Igyekszik mindig másik textúrát választani, e statikus számláló szerint.
     */
    private static int explorerCount = 0;

    // Ezek a képek jelennek meg a sarkkutatóhoz.
    public final Image playerImage;
    public final Image iconImage;

    public ExplorerView(Game g) {
        super(g);

        iconImage = ResourceManager.explorer[explorerCount % ResourceManager.explorer.length];
        playerImage = ResourceManager.explorerPlayer[explorerCount % ResourceManager.explorerPlayer.length];

        explorerCount++;
    }
}
