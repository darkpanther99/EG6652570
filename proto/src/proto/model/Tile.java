package proto.model;

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
     *  Rajta lévo játékosok számának maximuma
     */
    private int weightLimit;
    /**
     * Szomszédos cellákat ismer.
     */
    private Map<Integer, Tile> neighbors;
    /**
     * Eldönti, kinek változik a testhoje vihar esetén.
     */
    private Shelter shelter;
    /**
     *  Eldönti, kinek változik a testhoje víz esetén.
     */
    private ChillWaterStrategy chillWaterStrategy;
    /**
     * Ezt a tárgyat lehet kiásni belole.
     */
    private Item item;
    /**
     *  Rajta lévo entitások.
     */
    private List<Entity> occupants;

    public Tile neighborAt(int direction) {
        throw new RuntimeException();
    }

    public void decrementSnow() {
        if(snow > 0) snow--;
    }

    /**
     * A játékos megkapja a tartalmazott tárgyat.
     * @return
     */
    public Item takeItem() {
        if(item){
            // todo: remove item az mit jelent, nincs kedvem amr szekkvencian kibogozni, fuj OO
            return item
        }
    }

    /**
     *  Hozzáad egy entitást a táblához.
     * @param e
     */
    private void add(Entity e) {
        occupants.add(e);
    }

    /**
     * Eltávolítja egy entitást a táblárol.
     * @param e
     */
    private void remove(Entity e) {
        occupants.remove(e);
    }

    public void stepOn(Entity e) {
        throw new RuntimeException();
    }

    public void stepOff(Entity e) {
        throw new RuntimeException();
    }

    /**
     * Ezt a metódust a Controller hívja viharban. H ˝uti a játékosokat, ha nincsenek
     * igluban vagy sátorban.
     */
    public void chillStorm() {
        // Gabor TODO: this
    }

    /**
     * Ez a metódus eltávolítja a sátrat a tábláró
     */
    public void ruinShelter() {
        shelter.ruin();
    }

    public void bearAttack() {
        for (Entity e : occupants) {
            e.bearAttack();
        }
    }

    public void chillWater() {
        throw new RuntimeException();
    }

    public List<Entity> getOccupants() {
        return occupants;
    }

    public void setShelter(Shelter s) {
        shelter = s;
    }

    public Tile getNeighbor(int direction) {
        return neighbors.get(direction);
    }
    
    public void setSnow(int n) {
    	snow=n;
    }
    
    public void setWeightLimit(int n) {
    	weightLimit=n;
    }
    
    public void setChillWaterStrategy(ChillWaterStrategy cws) {
    	chillWaterStrategy=cws;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public Item getItem() {
        return item;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public int getSnow() {
        return snow;
    }

    public Map<Integer, Tile> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Tile t, int direction) {
        neighbors.put(direction, t);
    }
}
