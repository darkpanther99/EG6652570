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
    public static Image[] imageSnow = new Image[6]; // minden horeteghez egy textura

    public static Image[] imageHP = new Image[6];
    public static Image[] imageEnergy = new Image[6];

    public static Image player = null;
    public static Image explorer = null;
    public static Image eskimo = null;
    public static Image emptyPlayerSlot = null;
    public static Image playerSlot = null;
    public static Image selectedPlayer = null;

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
            imageIce = ImageIO.read(getResource("png/jégtile.png"));
            imageLeaves = ImageIO.read(getResource("res/oak_leaves.png"));
            imageSea = ImageIO.read(getResource("res/water.png"));
            imageEntity = ImageIO.read(getResource("res/entity.png"));
            eskimo = ImageIO.read(getResource("png/eskimo1_playericon.png"));
            explorer = ImageIO.read(getResource("png/explorer1_playericon.png"));
            emptyPlayerSlot = ImageIO.read(getResource("png/empty_player_slot.png"));
            playerSlot = ImageIO.read(getResource("png/player_slot.png"));
            selectedPlayer = ImageIO.read(getResource("png/active player.png"));

            //Image snow = ImageIO.read(getResource("res/snow.png"));
            Image hole = ImageIO.read(getResource("png/bezskadtjeg.png"));
            imageSnow[0] = hole;
            for (int i = 1; i <= 5; i++) {
                Image snow = ImageIO.read(getResource("png/hó" + Integer.toString(i) + ".png"));
                imageSnow[i] = snow;
            }

            imageHP[0] = ImageIO.read(getResource("png/HP_Energí_0.png"));
            for (int i = 1; i < 6; i++) {
               imageHP[i] = ImageIO.read(getResource("png/HP" + i + ".png"));
            }

            imageEnergy[0] = ImageIO.read(getResource("png/HP_Energí_0.png"));
            for (int i = 1; i < 6; i++) {
                imageEnergy[i] = ImageIO.read(getResource("png/energy" + i + ".png"));
            }

            try (InputStream is = getResource("res/mus.wav").openStream()) {
                soundBackground.load(is);
            }
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

}
