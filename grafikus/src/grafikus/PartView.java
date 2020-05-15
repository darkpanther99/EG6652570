package grafikus;

import grafikus.model.Part;

import java.awt.*;

public class PartView extends Part {
    private final Image image;

    public PartView(Image img) {
        super();
        image = img;

    }

    public Image getImage() {
        return image;
    }

}
