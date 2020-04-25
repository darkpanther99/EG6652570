package proto.model;

import java.util.List;

public abstract class Player extends Entity {
    /**
     * Jelzi a játékos jelenlegi homérsékletét, ha 0 akkor megfagy -> játék vége.
     */
    protected int bodyTemp;
    /**
     * Számlálja mennyit mozogott az adott körben a játékos.
     */
    protected int energy;
    /**
     * A játékos ismeri a játékot.
     */
    private Game game;
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
    /**
     *  Tárolja a játékos ételeit.
     */
    protected FoodStore foodStore;
    /**
     * Tárolja a játékos rakéta alkatrészeit.
     */
    private PartStore partStore;
    /**
     * Tárolja a játékos tárgyait, amik képességekkel tudjak felruházni ot.
     */
    private List<Item> inventory;
    /**
     * Így tud építeni a játékos.
     */
    private BuildStrategy buildStrategy;
    /**
     * A játékos ismeri a mezot amin éppen áll.
     */
    private Tile currentTile;

    /**
     * Ezt a metódust a Controller hívja. A játékos lép, ha van még hozzá elég
     * energiája. 1 munkaegység
     * @param direction
     */
    public void step(int direction) {
        if(energy > 0){
            decrementEnergy();
            step(direction);
        }
    }

    /**
     *  A játékos testhoje a WaterResistance szerint változik.
     */
    public void resistWater() {
        waterResistanceStrategy.chill(this);
    }

    /**
     * A testho 1-el csökken, ha 0 alá megy -> GameOver
     */
    public void chill() {
        bodyTemp--;
        if(bodyTemp == 0){
            game.gameOver();
        }
    }

    /**
     * A játékost medvetámadás éri.
     */
    public void bearAttack() {
        game.gameOver()
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
        if( energy > 0){
            decrementEnergy();
            Item item = currentTile.takeItem();
            addToInventory(item);
            i.giveTo(this);
        }
    }

    private void addToInventory(Item i) {
        inventory.add(i);
    }

    public void removeFromInventory(Item i) {
        inventory.remove(i);
    }

    /**
     * Ezt a metódust a Controller hívja. A játékos kiválaszt egy tárgyat
     * használatra.
     * @param inventorySlot
     */
    public void equip(int inventorySlot) {
        inventory.get(inventorySlot).giveTo(this);
    }

    /**
     *  Élelem megtalálásához helper metódus.
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

        if(energy > 0){
            decrementEnergy();
            digStrategy.dig(currentTile);
        }
    }

    /**
     * A játékos épít
     */
    public void build() {
        decrementEnergy();
        buildStrategy.Build(currentTile);
    }

    /**
     * Ezt a metódust a Controller hívja. A játékos kiment egy
     * másikat a vízbol. 1 munkaegység
     * @param direction
     */
    public void rescueTeammate(int direction) {
        if( energy > 0){
            decrementEnergy();
            rescueStrategy.rescue(currentTile.getNeighbourAt(direction), currentTile);
        }
    }

    /**
     *  Összerakja a játék végéhez szükséges rakéta pisztolyt. 1 munkaegység
     */
    public void assembleFlare() {
        for (Player p : game.getPlayers();) {
            if (player == this) continue;
            if(p.currentTile == this.currentTile){
                partStore.gain(p.getPartStore());
            }
        }
        if(partStore.getCount() >= 3){
            game.victory();
        }
    }

    public void setDigStrategy(DigStrategy d) {
        digStrategy = d;
    }

    public FoodStore getFoodStore() {
        return foodStore;
    }

    public void setEnergy(int n) {
        energy = n;
    }

    public RescueStrategy getRescueStrategy() {
        return rescueStrategy;
    }

    public void setRescueStrategy(RescueStrategy rescueStrategy) {
        this.rescueStrategy = rescueStrategy;
    }
}
