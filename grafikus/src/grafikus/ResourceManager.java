package grafikus;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

/**
 * Resource manager
 * init fuggvenyben betolti az osszes fajlt, ami kellhet, es tarolja oket
 */
public class ResourceManager {

    // Texturak
    public static Image imageIce = null;
    public static Image imageLeaves = null;
    public static Image imageSea = null;
    public static Image imageEntity = null;
    public static Image[] imageSnow = new Image[5]; // minden horeteghez egy textura

    // Hangok
    public static Sound soundBackground = new Sound();

    // Betolt egy kepet
    private static Image loadImage(String path) throws IOException {
        return ImageIO.read(Thread.currentThread().getContextClassLoader().getResource(path));
    }

    // Betolt mindent
    public static void init() {
        try {
            imageIce = loadImage("res/ice.png");
            imageLeaves = loadImage("res/oak_leaves.png");
            imageSea = loadImage("res/water.png");
            imageEntity = loadImage("res/entity.png");

            Image snow = loadImage("res/snow.png");
            for (int i = 0; i < 5; i++) {
                imageSnow[i] = snow;
            }

            soundBackground.load("res/mus.wav");
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException | RuntimeException e) {
            e.printStackTrace();
        }
    }

}
