package proto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cella, ilyenekbol áll a jégmez ˝ o ahol a játékosok játszanak
 */
public class Tile {
    /**
     * Rajta lévo hómennyiség.
     */
    private int snow;
    /**
     * Rajta lévo játékosok számának maximuma
     */
    private int weightLimit;
    /**
     * Szomszédos cellákat ismer.
     */
    private final Map<Integer, Tile> neighbors;
    /**
     * Eldönti, kinek változik a testhoje vihar esetén.
     */
    private Shelter shelter;
    /**
     * Eldönti, kinek változik a testhoje víz esetén.
     */
    private ChillWaterStrategy chillWaterStrategy;
    /**
     * Ezt a tárgyat lehet kiásni belole.
     */
    private Item item;
    /**
     * Rajta lévo entitások.
     */
    private final List<Entity> occupants;

    public Tile() {
        item = new Empty();
        occupants = new ArrayList<>();
        neighbors = new HashMap<>();
    }

    public Tile neighborAt(int direction) {
        return neighbors.get(direction);
    }

    public void decrementSnow() {
        if (snow > 0) snow--;
    }

    /**
     * A játékos megkapja a tartalmazott tárgyat.
     *
     * @return
     */
    public Item takeItem() {
        if (item != null) {
            Item i = getItem();
            setItem(null);
            return i;
        }
        return new Empty();
    }

    /**
     * Hozzáad egy entitást a táblához.
     *
     * @param e
     */
    private void add(Entity e) {
        occupants.add(e);
    }

    /**
     * Eltávolítja egy entitást a táblárol.
     *
     * @param e
     */
    private void remove(Entity e) {
        occupants.remove(e);
    }

    /**
     * Játékos rálép a cellára, ha többen vannak mint a korlát, a jégtábla átfordul. A függvény futása során beállítja a megfelelo ̋ adattagokat az új értékekre.
     *
     * @param e
     */
    public void stepOn(Entity e) {
        this.add(e);
        if (occupants.size() > weightLimit) {
            setSnow(0);
            setWeightLimit(0);
            setItem(new Empty());
            setShelter(new BareIce());
            setChillWaterStrategy(new Sea());
            chillWater();
        }
    }

    /**
     * Játékos lelép a celláról. A függvény futása során beállítja a megfelelo ̋ adattago- kat az új értékekre
     *
     * @param e
     */
    public void stepOff(Entity e) {
        if (occupants.contains(e)) {
            remove(e);
        }
    }

    /**
     * Ezt a metódust a Controller hívja viharban. H ˝uti a játékosokat, ha nincsenek
     * igluban vagy sátorban.
     */
    public void chillStorm() {
        shelter.chillStorm(this);
    }

    /**
     * Ez a metódus eltávolítja a sátrat a tábláró
     */
    public void ruinShelter() {
        shelter.ruin(this);
    }

    /**
     * Medve megtámadja a cellán állókat.
     */
    public void bearAttack() {
        shelter.bearAttack(this);
    }

    /**
     * Ezt a metódust a Controller hívja körönként. Hu ̋ti a játékosokat, ha ez a cella víz.
     */
    public void chillWater() {
        chillWaterStrategy.chill(this);
    }

    public List<Entity> getOccupants() {
        return occupants;
    }

    public Tile getNeighbor(int direction) {
        return neighbors.get(direction);
    }

    public void setChillWaterStrategy(ChillWaterStrategy cws) {
        chillWaterStrategy = cws;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter s) {
        shelter = s;
    }

    public Item getItem() {
        if (item == null) return new Empty();
        return item;
    }

    public void setItem(Item i) {
        item = i;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int n) {
        weightLimit = n;
    }

    public int getSnow() {
        return snow;
    }

    public void setSnow(int n) {
        snow = n;
    }

    public Map<Integer, Tile> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Tile t, int direction) {
        neighbors.put(direction, t);
    }
}
