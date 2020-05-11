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
    public static Image waterSide = null;
    public static Image waterCorner = null;

    public static Image flagSafe = null;
    public static Image flagNotSafe = null;

    public static Image[] imageHP = new Image[6];
    public static Image[] imageEnergy = new Image[6];

    public static Image player = null;
    public static Image explorer = null;
    public static Image eskimo = null;
    public static Image emptyPlayerSlot = null;
    public static Image playerSlot = null;
    public static Image selectedPlayer = null;

    public static Image shovel = null;
    public static Image breakingShovel = null;
    public static Image tentkit = null;
    public static Image flare = null;
    public static Image flareGun = null;
    public static Image flareLight = null;
    public static Image food = null;
    public static Image scubaGear = null;
    public static Image rope = null;

    public static Image eskimoPlayer = null;
    public static Image explorerPlayer = null;
    public static Image polarbear = null;

    public static Image igloo = null;
    public static Image tent = null;

    public static Image buttonSlot = null;
    public static Image itemSlot = null;
    public static Image foodSlot = null;
    public static Image pewpewSlot = null;
    public static Image tentkitSlot = null;

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


            flagSafe = ImageIO.read(getResource("png/zaszlobiztonsagos.png"));
            flagNotSafe = ImageIO.read(getResource("png/zaszloveszely.png"));

            // Player
            eskimoPlayer = ImageIO.read(getResource("png/eskimo1.png"));
            explorerPlayer = ImageIO.read(getResource("png/explorer1.png"));
            polarbear = ImageIO.read(getResource("png/jegesmedve.png"));

            // Shelter
            igloo = ImageIO.read(getResource("png/iglu.png"));
            tent = ImageIO.read(getResource("png/sator.png"));

            // Items
            itemSlot = ImageIO.read(getResource("png/itemslot.png"));
            foodSlot = ImageIO.read(getResource("png/foodslot.png"));
            pewpewSlot = ImageIO.read(getResource("png/pewpewslot.png"));
            tentkitSlot = ImageIO.read(getResource("png/tentkitslot.png"));

            breakingShovel = ImageIO.read(getResource("png/törékenyásó.png"));
            shovel = ImageIO.read(getResource("png/törhetetlenásó.png"));
            tentkit = ImageIO.read(getResource("png/tentkit.png"));
            flare = ImageIO.read(getResource("png/patron.png"));
            flareGun = ImageIO.read(getResource("png/flaregun.png"));
            flareLight = ImageIO.read(getResource("png/jelzőfény.png"));
            food = ImageIO.read(getResource("png/food.png"));
            scubaGear = ImageIO.read(getResource("res/oak_leaves.png"));
            rope = ImageIO.read(getResource("res/oak_leaves.png"));

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

            waterSide = ImageIO.read(getResource("png/Víz_side.png"));
            waterCorner = ImageIO.read(getResource("png/víz_corner.png"));

            Image hole = ImageIO.read(getResource("png/bezskadtjeg.png"));

            imageSnow[0] = hole;
            for (int i = 1; i <= 5; i++) {
                Image snow = ImageIO.read(getResource("png/hó" + Integer.toString(i) + ".png"));
                imageSnow[i] = snow;
            }
            // UI
            buttonSlot = ImageIO.read(getResource("png/buttonslot.png"));

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
