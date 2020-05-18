package grafikus;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.MissingResourceException;

/**
 * Betölti a játék grafikájához szükséges erőforrásokat.
 */
public class ResourceManager {

    // Texturak

    public static Image canStep = null;

    public static Image storm = null;
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
    public static Image[] explorer = new Image[3];
    public static Image[] eskimo = new Image[3];
    public static Image emptyPlayerSlot = null;
    public static Image playerSlot = null;
    public static Image selectedPlayer = null;
    public static Image selectedEskimo = null;
    public static Image selectedExplorer = null;
    public static Image selectedScuba = null;

    public static Image shovel = null;
    public static Image breakingShovel = null;
    public static Image tentKit = null;
    public static Image flare = null;
    public static Image flareGun = null;
    public static Image flareLight = null;
    public static Image food = null;
    public static Image scubaGear = null;
    public static Image rope = null;
    public static Image equippedItem = null;

    public static Image[] eskimoPlayer = new Image[3];
    public static Image[] explorerPlayer = new Image[3];
    public static Image polarBear = null;

    public static Image igloo = null;
    public static Image tent = null;

    public static Image buttonSlot = null;
    public static Image itemSlot = null;
    public static Image foodSlot = null;
    public static Image flareGunSlot = null;
    public static Image tentKitSlot = null;
    public static Image winner = null;

    public static Image scubaGearPlayer = null;

    // Hangok
    public static Sound soundBackground = new Sound();

    /*
     * Mindent betölt.
     */
    static {
        try {

            equippedItem = ImageIO.read(getResource("png/equipped_item.png"));

            canStep = ImageIO.read(getResource("png/canstep.png"));
            storm = ImageIO.read(getResource("png/vihar.png"));
            flagSafe = ImageIO.read(getResource("png/zaszlobiztonsagos.png"));
            flagNotSafe = ImageIO.read(getResource("png/zaszloveszely.png"));

            // Player
            for (int i = 1; i <= 3; i++) {
                eskimoPlayer[i - 1] = ImageIO.read(getResource("png/eskimo" + i + ".png"));
                explorerPlayer[i - 1] = ImageIO.read(getResource("png/explorer" + i + ".png"));
                eskimo[i - 1] = ImageIO.read(getResource("png/eskimo" + i + "_playericon.png"));
                explorer[i - 1] = ImageIO.read(getResource("png/explorer" + i + "_playericon.png"));
            }
            polarBear = ImageIO.read(getResource("png/jegesmedve.png"));

            // Shelter
            igloo = ImageIO.read(getResource("png/iglu.png"));
            tent = ImageIO.read(getResource("png/sator.png"));

            // Items
            itemSlot = ImageIO.read(getResource("png/itemslot.png"));
            foodSlot = ImageIO.read(getResource("png/foodslot.png"));
            flareGunSlot = ImageIO.read(getResource("png/pewpewslot.png"));
            tentKitSlot = ImageIO.read(getResource("png/tentkitslot.png"));
            winner = ImageIO.read(getResource("png/winner.png"));

            breakingShovel = ImageIO.read(getResource("png/törékenyásó.png"));
            shovel = ImageIO.read(getResource("png/törhetetlenásó.png"));
            tentKit = ImageIO.read(getResource("png/tentkit.png"));
            flare = ImageIO.read(getResource("png/patron.png"));
            flareGun = ImageIO.read(getResource("png/flaregun.png"));
            flareLight = ImageIO.read(getResource("png/jelzőfény.png"));
            food = ImageIO.read(getResource("png/food.png"));
            scubaGear = ImageIO.read(getResource("png/scuba.png"));
            scubaGearPlayer = ImageIO.read(getResource("png/buvarruha.png"));
            rope = ImageIO.read(getResource("png/rope.png"));

            imageIce = ImageIO.read(getResource("png/jégtile.png"));
            imageLeaves = ImageIO.read(getResource("res/oak_leaves.png"));
            imageSea = ImageIO.read(getResource("res/water.png"));
            imageEntity = ImageIO.read(getResource("res/entity.png"));

            emptyPlayerSlot = ImageIO.read(getResource("png/empty_player_slot.png"));
            playerSlot = ImageIO.read(getResource("png/player_slot.png"));
            selectedPlayer = ImageIO.read(getResource("png/active player.png"));
            selectedEskimo = ImageIO.read(getResource("png/activeplayer_eskimo.png"));
            selectedExplorer = ImageIO.read(getResource("png/activeplayer_Explorer.png"));
            selectedScuba = ImageIO.read(getResource("png/activeplayer_scuba.png"));
            //Image snow = ImageIO.read(getResource("res/snow.png"));

            waterSide = ImageIO.read(getResource("png/Víz_side.png"));
            waterCorner = ImageIO.read(getResource("png/víz_corner.png"));

            Image hole = ImageIO.read(getResource("png/bezskadtjeg.png"));

            imageSnow[0] = hole;
            for (int i = 1; i <= 5; i++) {
                Image snow = ImageIO.read(getResource("png/hó" + i + ".png"));
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
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException debug) {
            debug.printStackTrace();
        }
    }

    /**
     * Segédfüggvény.
     */
    private static URL getResource(String path) throws MissingResourceException {
        URL u = Thread.currentThread().getContextClassLoader().getResource(path);
        if (u == null) throw new MissingResourceException("Missing resource: " + path,
                Thread.currentThread().getContextClassLoader().getName(), path);
        return u;
    }
}
