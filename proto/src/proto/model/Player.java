package proto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Játékos osztály, amit a felhasználó irányít a grafikus felületen keresztül. Ilyen típussal nem lehet játszani,
 * csak a leszármazottakkal. Felelo ̋ssége a játékos által a controlleren keresztül kiadott mu ̋veletek elvégzése.
 * Tárolja a játékos jelenlegi állapotát.
 */
public abstract class Player extends Entity {
    /**
     * A játékos ismeri a játékot.
     */
    protected final Game game;
    /**
     * Tárolja a játékos ételeit.
     */
    protected final FoodStore foodStore;
    /**
     * Tárolja a játékos rakéta alkatrészeit.
     */
    private final PartStore partStore;
    /**
     * Tárolja a játékos tárgyait, amik képességekkel tudjak felruházni ot.
     */
    private final List<Item> inventory;
    /**
     * Így tud építeni a játékos.
     */
    private final BuildStrategy buildStrategy;
    /**
     * Jelzi a játékos jelenlegi homérsékletét, ha 0 akkor megfagy -> játék vége.
     */
    protected int bodyTemp;
    /**
     * Számlálja mennyit mozogott az adott körben a játékos.
     */
    protected int energy;
    /**
     * Eldönti hogyan képes ásni a játékos.
     */
    private DigStrategy digStrategy;
    /**
     * Eldönti, hogy megmenthet egy játékos egy másikat a vízbeesés után.
     */
    private RescueStrategy rescueStrategy;
    /**
     * Eldönti, hogy a játékos hogyan viselkedik
     * vízbeesés esetén.
     */
    private WaterResistanceStrategy waterResistanceStrategy;


    public Player(Game g) {
        game = g;
        inventory = new ArrayList<>();
        waterResistanceStrategy = new Naked();
        partStore = new PartStore();
        foodStore = new FoodStore();
        digStrategy = new BareHands();
        buildStrategy = new BuildStrategy();
        rescueStrategy = new CantRescue();
        bodyTemp = 4;
        energy = 4;
    }

    /**
     * Ezt a metódust a Controller hívja. A játékos lép, ha van még hozzá elég
     * energiája. 1 munkaegység
     *
     * @param direction
     */
    public void step(int direction) {
        if (energy > 0) {
            decrementEnergy();
            super.step(direction);
        }
    }

    /**
     * A játékos testhoje a WaterResistance szerint változik.
     */
    public void resistWater() {
        waterResistanceStrategy.chill(this);
    }

    /**
     * A testho 1-el csökken, ha 0 alá megy -> GameOver
     */
    public void chill() {
        bodyTemp--;
        if (bodyTemp == 0) {
            game.gameOver();
        }
    }

    /**
     * A játékost medvetámadás éri.
     */
    public void bearAttack() {
        game.gameOver();
    }

    /**
     * Az energiát csökkento helper metódus
     */
    public void decrementEnergy() {
        energy--;
    }

    /**
     * Az energiát növelő helper metódus
     */
    public void incrementBodyTemp() {
        bodyTemp++;
    }

    /**
     * Ezt a metódust a Controller hívja. A játékos felvesz egy tárgyat. 1 munkaegység
     */
    public void pickUp() {
        if (energy > 0 || !(currentTile.getItem() instanceof Empty)) {
            decrementEnergy();
            Item item = currentTile.takeItem();
            addToInventory(item);
            item.giveTo(this);
        }
    }

    public void addToInventory(Item i) {
        inventory.add(i);
    }

    public void removeFromInventory(Item i) {
        inventory.remove(i);
    }

    /**
     * Ezt a metódust a Controller hívja. A játékos kiválaszt egy tárgyat
     * használatra.
     *
     * @param inventorySlot
     */
    public void equip(int inventorySlot) {
        inventory.get(inventorySlot).giveTo(this);
    }

    /**
     * Élelem megtalálásához helper metódus.
     */
    public void toFoodStore() {
        foodStore.gain();
    }

    /**
     * Ezt a metódust a Controller hívja. A játékos eszik. A testhoje megn ˝ o 1-el
     */
    public void eatFood() {
        foodStore.feed(this);
    }

    /**
     * Ezt a metódust a Controller hívja. A játékos havat ás. 1 munkaegység
     */
    public void dig() {
        if (energy > 0) {
            if (digStrategy.dig(currentTile))
                decrementEnergy();
        }
    }

    /**
     * A játékos épít
     */
    public void build() {
        decrementEnergy();
        buildStrategy.build(currentTile);
    }

    /**
     * Ezt a metódust a Controller hívja. A játékos kiment egy
     * másikat a vízbol. 1 munkaegység
     *
     * @param direction
     */
    public void rescueTeammate(int direction) {
        if (energy > 0) {
            decrementEnergy();
            rescueStrategy.rescue(currentTile.getNeighbor(direction), currentTile);
        }
    }

    /**
     * Összerakja a játék végéhez szükséges rakéta pisztolyt. 1 munkaegység
     */
    public void assembleFlare() {
        decrementEnergy();
        for (Player p : game.getPlayers()) {
            if (p == this) continue;
            if (p.currentTile == this.currentTile) {
                partStore.gain(p.getPartStore());
            }
        }
        if (partStore.getCount() >= 3 && energy > 0) {
            game.victory();
        }
    }

    public FoodStore getFoodStore() {
        return foodStore;
    }

    public RescueStrategy getRescueStrategy() {
        return rescueStrategy;
    }

    public void setRescueStrategy(RescueStrategy rescueStrategy) {
        this.rescueStrategy = rescueStrategy;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public BuildStrategy getBuildStrategy() {
        return buildStrategy;
    }

    public PartStore getPartStore() {
        return partStore;
    }

    public WaterResistanceStrategy getWaterResistanceStrategy() {
        return waterResistanceStrategy;
    }

    public void setWaterResistanceStrategy(WaterResistanceStrategy wrs) {
        waterResistanceStrategy = wrs;
    }

    public DigStrategy getDigStrategy() {
        return digStrategy;
    }

    public void setDigStrategy(DigStrategy d) {
        digStrategy = d;
    }

    public int getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(int n) {
        bodyTemp = n;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int n) {
        energy = n;
    }
}
