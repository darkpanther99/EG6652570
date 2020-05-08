package grafikus;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.MissingResourceException;

public class ResourceManager {

    // Texturak
    public static Image imageIce = null;
    public static Image imageLeaves = null;
    public static Image imageSea = null;
    public static Image imageEntity = null;
    public static Image[] imageSnow = new Image[5]; // minden horeteghez egy textura

    // Hangok
    public static Sound soundBackground = new Sound();

    public static URL getResource(String path) {
        URL u = Thread.currentThread().getContextClassLoader().getResource(path);
        if (u == null) throw new MissingResourceException("Missing resource: " + path,
                Thread.currentThread().getContextClassLoader().getName(), path);
        return u;
    }

    // Betolt mindent
    static {
        try {
            imageIce = ImageIO.read(getResource("res/ice.png"));
            imageIce = ImageIO.read(getResource("res/ice.png"));
            imageLeaves = ImageIO.read(getResource("res/oak_leaves.png"));
            imageSea = ImageIO.read(getResource("res/water.png"));
            imageEntity = ImageIO.read(getResource("res/entity.png"));

            Image snow = ImageIO.read(getResource("res/snow.png"));
            for (int i = 0; i < 5; i++) {
                imageSnow[i] = snow;
            }

            try (InputStream is = getResource("res/mus.wav").openStream()) {
                soundBackground.load(is);
            }
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

}
