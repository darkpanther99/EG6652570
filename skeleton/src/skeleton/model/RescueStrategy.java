package skeleton.model;

public interface RescueStrategy {
    /**
     * Interface függvénye, amivel egy játékos képes kimenteni egy másikat a vízből.
     *
     * @param water Tile típusú jégtábla objektum, ahol a játékos akit kimentünk éppen áll.
     * @param land Tile típusú jégtábla objektum, ahova a játékos kihúzza a társát.
     */
    void Rescue(Tile water, Tile land);
}
