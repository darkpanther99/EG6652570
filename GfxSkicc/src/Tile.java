
/**
 * Helper tile, nem akartam az egesz modellt beimportalni
 */
public class Tile {
    public int snow;
    public int weightLimit;
    public int occupants;

    public Tile(int snow, int weightLimit, int occupants) {
        this.snow = snow;
        this.weightLimit = weightLimit;
        this.occupants = occupants;
    }
}
