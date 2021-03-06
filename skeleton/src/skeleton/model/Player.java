package skeleton.model;

import static skeleton.Logger.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Player osztály, ami a jégmezőn lévő játékosokat (eszkimók, sarkkutatók) modellezi.
 * A player osztály tartalmazza a játékos irányításához szükséges interfészt, mely a játékos típusoktól független.
 */
public abstract class Player {
    /**
     * A játékos test hőmérséklete. Ha ez eléri a 0-t, a játék véget ér.
     */
    private int bodyTemp;
    /**
     * A játékos energiája. A cselekedetek energiát fogyasztanak, a játékosoknak egy körben véges energiájuk van.
     */
    private int energy;
    /**
     * A játék példány, amihez ez a játékos tartozik.
     */
    private Game game;
    /**
     * A játékos ásási stratégiája. Pl.: fogyaszt-e energiát az ásás, stb.
     */
    private DigStrategy digStrategy;
    /**
     * A játékos mentési stratégiája. Ha a játékosnál van kötél, a játékos meg tudja menteni a vízben fuldokló társait.
     */
    private RescueStrategy rescueStrategy;
    /**
     * A játékos víz ellenállási stratégiája. Ha a játékos búvárruhát visel, nem fázik a vízben.
     */
    private WaterResistanceStrategy waterResistanceStrategy;
    /**
     * A játékos élelmiszer tárolója.
     */
    private FoodStore foodStore;
    /**
     * A játékos rakéta alkatrész tárolója
     */
    private PartStore partStore;
    /**
     * A játékos eszköztára.
     */
    private final ArrayList<Item> inventory = new ArrayList<>();
    /**
     * A mező, amin épp a játékos tartózkodik
     */
    Tile currentTile;

    /**
     * Constructor
     */
    Player() {
        setDisplayName(inventory, "inventory");
    }

    /**
     * Beállítja a játékos testhőjét
     *
     * @param bodyTemp az új testhő
     */
    public void setBodyTemp(int bodyTemp) {
        logMethodCall(this, bodyTemp);
        this.bodyTemp = bodyTemp;
        logMethodReturn();
    }

    /**
     * Beállítja a játékos energiáját
     *
     * @param energy az új energia szint.
     */
    public void setEnergy(int energy) {
        logMethodCall(this, energy);
        this.energy = energy;
        logMethodReturn();
    }

    /**
     * Beállítja a játékos játék példányát
     *
     * @param game az új játék példány, amihez ez a játékos tartozik.
     */
    public void setGame(Game game) {
        logMethodCall(this, game);
        this.game = game;
        logMethodReturn();
    }

    public void setDigStrategy(DigStrategy digStrategy) {
        logMethodCall(this, digStrategy);
        this.digStrategy = digStrategy;
        logMethodReturn();
    }

    public void setRescueStrategy(RescueStrategy rescueStrategy) {
        logMethodCall(this, rescueStrategy);
        this.rescueStrategy = rescueStrategy;
        logMethodReturn();
    }

    public void setWaterResistanceStrategy(WaterResistanceStrategy waterResistanceStrategy) {
        logMethodCall(this, waterResistanceStrategy);
        this.waterResistanceStrategy = waterResistanceStrategy;
        logMethodReturn();
    }

    public FoodStore getFoodStore() {
        logMethodCall(this);
        logMethodReturn(foodStore);
        return foodStore;
    }

    public void setFoodStore(FoodStore foodStore) {
        logMethodCall(this, foodStore);
        this.foodStore = foodStore;
        logMethodReturn();
    }

    public PartStore getPartStore() {
        logMethodCall(this);
        logMethodReturn(partStore);
        return partStore;
    }

    public void setPartStore(PartStore partStore) {
        logMethodCall(this, partStore);
        this.partStore = partStore;
        logMethodReturn();
    }

    private Tile getCurrentTile() {
        logMethodCall(this);
        logMethodReturn(currentTile);
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        logMethodCall(this, currentTile);
        this.currentTile = currentTile;
        logMethodReturn();
    }

    /**
     * Hozzád egy eszközt a játékos eszköztárához
     *
     * @param i az új eszköz.
     */
    private void AddToInventory(Item i) {
        logMethodCall(this, i);
        inventory.add(i);
        logMethodReturn();
    }

    /**
     * Csökkenti a játékos energiáját egy egységgel (ha ez lehetséges).
     */
    void DecrementEnergy() {
        logMethodCall(this);
        if (energy > 0) energy--;
        logMethodReturn();
    }

    /**
     * Növeli a játékos testhőjét egy egységgel.
     */
    public void IncrementBodyTemp() {
        logMethodCall(this);
        bodyTemp++;
        logMethodReturn(this);
    }

    /**
     * Csökkenti a játékos testhőjét egy egységgel.
     */
    private void DecrementBodyTemp() {
        logMethodCall(this);
        bodyTemp--;
        logMethodReturn(this);
    }

    /**
     * Csökkenti a játékos testhőjét. Ha a játékos kihűlt, véget vet a játéknak.
     */
    public void Chill() {
        logMethodCall(this);
        DecrementBodyTemp();
        if (prompt("Kihűlt?", false)) {
            game.GameOver();
        }
        logMethodReturn();
    }

    /**
     * Felvesz egy eszközt a jelenlegi mezőről.
     */
    public void PickUp() {
        logMethodCall(this);
        if (!prompt("Van elég energiája?", true)) {
            logMethodReturn();
            return;
        }

        DecrementEnergy();
        Item i = currentTile.TakeItem();
        AddToInventory(i);
        i.GiveTo(this);
        logMethodReturn();
    }

    /**
     * A játékos eszköztárából aktívvá tesz egy eszközt.
     *
     * @param inventorySlot az eszköz indexe az inventory-ban.
     */
    public void Equip(int inventorySlot) {
        logMethodCall(this, inventorySlot);
        inventory.get(inventorySlot).GiveTo(this);
        logMethodReturn();
    }

    /**
     * Ráhelyezi a játékost egy új mezőre
     *
     * @param t az új mező
     */
    public void PlaceOn(Tile t) {
        logMethodCall(this, t);
        setCurrentTile(t);
        t.StepOn(this);
        logMethodReturn();
    }

    /**
     * Lépteti a játékost egy megadott irányba
     *
     * @param direction a lépés iránya
     */
    public void Step(int direction) {
        logMethodCall(this, direction);
        if (!prompt("Van elég energiája?", true)) {
            logMethodReturn();
            return;
        }

        DecrementEnergy();
        currentTile.StepOff(this);
        currentTile = currentTile.neighborAt(direction);
        currentTile.StepOn(this);
        logMethodReturn();
    }

    /**
     * A játékos a felszerelése szerint ellenáll a víznek.
     */
    public void ResistWater() {
        logMethodCall(this);
        waterResistanceStrategy.Chill(this);
        logMethodReturn();
    }

    /**
     * A játék elfogyaszt egy élelmet
     */
    public void EatFood() {
        logMethodCall(this);
        foodStore.Feed(this);
        logMethodReturn();
    }

    /**
     * A játékos eltakarít egy réteg havat a mezőjéről.
     */
    public void Dig() {
        logMethodCall(this);

        //if (energy <= 0) return;
        if (!prompt("Van elég energiája?", true)) {
            logMethodReturn();
            return;
        }

        if (digStrategy.Dig(currentTile)) {
            DecrementEnergy();
        }

        logMethodReturn();
    }

    /**
     * A játékos megpróbálja egy szomszédos mezőről kimenteni csapattársát.
     *
     * @param direction a szomszédos mező iránya.
     */
    public void RescueTeammate(int direction) {
        logMethodCall(this, direction);

        //if (energy <= 0) return;
        if (!prompt("Van elég energiája?", true)) {
            logMethodReturn();
            return;
        }

        DecrementEnergy();

        Tile neighbor = currentTile.neighborAt(direction);
        rescueStrategy.Rescue(neighbor, currentTile);

        logMethodReturn();
    }

    /**
     * A játékos megpróbálja összeszerelni a jelzőrakétát.
     * <p>
     * A játékos összegyűjti a társaitól az alkatrészeket, majd összeszereli a rakétát.
     * Ha bármely játékos másik mezőn tartózkodik, akkor ez sikertelen.
     * Ha nincs elég alkatrész, szintén sikertelen az összeszerelés
     */
    public void AssembleFlare() {
        logMethodCall(this);

        // @NOTE(boti): ez a szekvenciától kicsit eltér
        Collection<Player> players = game.getPlayers();

        for (Player player : players) {
            if (player == this) continue;

            // Ha bármely másik játékos másik mezőn tartózkodik,
            // nem tudjuk összeszerelni
            if (player.getCurrentTile() != currentTile) {
                logMethodReturn();
                return;
            }

            // Összegyűjtjük az alkatrészeket
            partStore.Gain(player.getPartStore());
        }

        // Ha mindhárom alkatrész megvan, nyertünk
        //if (partStore.getCount() >= 3) {
        if (prompt("Van 3 alkatrész?", true)) {
            game.Victory();
        }

        logMethodReturn();
    }

    /**
     * Kivesz egy eszközt a játékos eszköztárából.
     *
     * @param p az eszköz, amit kiveszünk.
     */
    public void RemoveFromInventory(Item p) {
        logMethodCall(this, p);
        inventory.remove(p);
        logMethodReturn();
    }
}
