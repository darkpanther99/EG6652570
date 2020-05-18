package grafikus;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
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


    /*
     * Mindent betölt.
     */
    static {
        try {

            equippedItem = ImageIO.read(getResource("ui_equipped_itemslot.png"));

            canStep = ImageIO.read(getResource("tile_canstep.png"));
            storm = ImageIO.read(getResource("tile_storm.png"));
            flagSafe = ImageIO.read(getResource("tile_safe.png"));
            flagNotSafe = ImageIO.read(getResource("tile_danger.png"));

            // Player
            for (int i = 1; i <= 3; i++) {
                eskimoPlayer[i - 1] = ImageIO.read(getResource("entity_eskimo" + i + ".png"));
                explorerPlayer[i - 1] = ImageIO.read(getResource("entity_explorer" + i + ".png"));
                eskimo[i - 1] = ImageIO.read(getResource("ui_eskimo" + i + "_playericon.png"));
                explorer[i - 1] = ImageIO.read(getResource("ui_explorer" + i + "_playericon.png"));
            }
            polarBear = ImageIO.read(getResource("entity_polarbear.png"));

            // Shelter
            igloo = ImageIO.read(getResource("tile_igloo.png"));
            tent = ImageIO.read(getResource("tile_tent.png"));

            // Items
            itemSlot = ImageIO.read(getResource("ui_itemslot.png"));
            foodSlot = ImageIO.read(getResource("ui_foodslot.png"));
            flareGunSlot = ImageIO.read(getResource("ui_flareslot.png"));
            tentKitSlot = ImageIO.read(getResource("ui_tentkitslot.png"));
            winner = ImageIO.read(getResource("ui_winner.png"));

            breakingShovel = ImageIO.read(getResource("item_shovel1.png"));
            shovel = ImageIO.read(getResource("item_shovel2.png"));
            tentKit = ImageIO.read(getResource("item_tentkit.png"));
            flare = ImageIO.read(getResource("item_flare.png"));
            flareGun = ImageIO.read(getResource("item_flaregun.png"));
            flareLight = ImageIO.read(getResource("item_flarelight.png"));
            food = ImageIO.read(getResource("item_food.png"));
            scubaGear = ImageIO.read(getResource("item_scuba.png"));
            scubaGearPlayer = ImageIO.read(getResource("entity_player_scuba.png"));
            rope = ImageIO.read(getResource("item_rope.png"));

            imageIce = ImageIO.read(getResource("tile_ice.png"));
           // imageLeaves = ImageIO.read(getResource("res/oak_leaves.png"));
           // imageSea = ImageIO.read(getResource("res/water.png"));
           // imageEntity = ImageIO.read(getResource("res/entity.png"));

            emptyPlayerSlot = ImageIO.read(getResource("ui_empty_playerslot.png"));
            playerSlot = ImageIO.read(getResource("ui_playerslot.png"));
            selectedPlayer = ImageIO.read(getResource("ui_active_playerslot.png"));
            selectedEskimo = ImageIO.read(getResource("entity_activeplayer_eskimo.png"));
            selectedExplorer = ImageIO.read(getResource("entity_activeplayer_explorer.png"));
            selectedScuba = ImageIO.read(getResource("entity_activeplayer_scuba.png"));
            //Image snow = ImageIO.read(getResource("res/snow.png"));

            waterSide = ImageIO.read(getResource("tile_seaside.png"));
            waterCorner = ImageIO.read(getResource("tile_seacorner.png"));

            Image hole = ImageIO.read(getResource("tile_hole.png"));

            imageSnow[0] = hole;
            for (int i = 1; i <= 5; i++) {
                Image snow = ImageIO.read(getResource("tile_snow" + i + ".png"));
                imageSnow[i] = snow;
            }
            // UI
            buttonSlot = ImageIO.read(getResource("ui_buttonslot.png"));

            imageHP[0] = ImageIO.read(getResource("ui_bar.png"));
            for (int i = 1; i <= 5; i++) {
                imageHP[i] = ImageIO.read(getResource("ui_bar_red" + i + ".png"));
            }

            imageEnergy[0] = ImageIO.read(getResource("ui_bar.png"));
            for (int i = 1; i <= 5; i++) {
                imageEnergy[i] = ImageIO.read(getResource("ui_bar_yellow" + i + ".png"));
            }
        } catch (IOException debug) {
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
