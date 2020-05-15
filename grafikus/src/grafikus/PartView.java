package grafikus;

import grafikus.model.Part;

import java.awt.*;

/**
 * Egy alkatrész grafikus megjelenítésére szolgál.
 */
public class PartView extends Part {
    private final Image image;

    /**
     * @param img A megjelenített textúra.
     */
    public PartView(Image img) {
        super();
        image = img;
    }

    public Image getImage() {
        return image;
    }

}
