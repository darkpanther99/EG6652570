package proto;
import proto.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Proto {
    /**
     * A teljes játékot tartalmazó változó.
     */
    public Game game;
    /**
     * A parancsok feldolgozásának állapota.
     */
    private boolean running;
    /**
     * A parancsfeldolgozók tömbje.
     */
    private ArrayList<CommandParser> parsers;
    /**
     * A kiválasztott mező.
     */
    private Tile selectedTile;
    /**
     * A kiválasztott játékos.
     */
    private Player selectedPlayer;
    /**
     * A kiválasztott jegesmedve.
     */
    private PolarBear selectedBear;

    /**
     * Létrehozza a játék objektumot és feltölti a parsers tömböt.
     */
    public Proto() {
        game = new Game();
        game.subscribe(new MessagePrinter(this));
        parsers = new ArrayList<>(createParses());

    }
    /**
     * Létrehozz egy listát, ami tartalmaz egyet az összes CommandParser típusból.
     * @return A parsereket tartalmazó lista
     */
    private List<CommandParser> createParses() {
        return (Arrays.asList(new AssembleCommandParser(),new BuildCommandParser(), new ConnectCommandParser(),
                new DigCommandParser(), new EatCommandParser(), new EntityCommandParser(),
                new EquipCommandParser(), new ExamineCommandParser(), new ItemCommandParser(),
                new PickUpCommandParser(),new QueryCommandParser(), new RescueCommandParser(),
                new SelectCommandParser(), new StepCommandParser(), new StormCommandParser(),
                new TileCommandParser(), new TurnCommandParser(), new BuildingCommandParser()));
    }

    /**
     * Futtatja a parancsértelmezést.
     */
    public void run() throws Exception {
        running = true;
        while (running) {
            Command c = getCommand();
            try {
                c.execute(this);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);

            }
        }
    }

    /**
     * Leállítja a parancsértelmezést.
     */
    public void stop() {
        running = false;
    }

    // TODO(Mark): this is not done yet boi
    /**
     * Beolvas egy parancsot a standard bemenetről.
     */

    private Command getCommand() throws Exception {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        line = line.trim();
        String[] tokenArr = line.split(" ");
        List<String> tokens = new ArrayList<>(Arrays.asList(tokenArr));
        for (var p : parsers) {
            if (tokens.get(0) == p.getKeyword()) {
                return p.parse(tokens);
            }
        }
        throw new Exception("Unable to parse command.");
    }

    /**
     * Beállítja a selectedTile-t és lenullozza a selectedPlayer-t és a selectedBear-t.
     * @param t: A kiválasztandó Tile
     */
    public void selectTile(Tile t) {
        selectedTile = t;
        selectedBear = null;
        selectedPlayer = null;
    }
    /**
     * Beállítja a selectedPlayer-t és lenullozza a selectedTile-t és a selectedBear-t.
     * @param p: A kiválasztandó Player
     */
    public void selectPlayer(Player p) {
        selectedTile = null;
        selectedBear = null;
        selectedPlayer = p;
    }

    /**
     * Beállítja a selectedBear-t és lenullozza a selectedTile-t és a selectedPlayer-t.
     * @param b: A kiválasztandó PolarBear
     */
    public void selectBear(PolarBear b) {
        selectedTile = null;
        selectedBear = b;
        selectedPlayer = null;
    }

    /**
     * Megmondja, hogy van e kiválasztott Tile.
     * @return True, ha van False, ha nincs
     */
    public boolean hasSelectedTile() {
        return selectedTile != null;
    }
    /**
     * Megmondja, hogy van e kiválasztott Player.
     * @return True, ha van False, ha nincs
     */
    public boolean hasSelectedPlayer() {
        return selectedPlayer != null;
    }
    /**
     * Megmondja, hogy van e kiválasztott PolarBear.
     * @return True, ha van False, ha nincs
     */
    public boolean hasSelectedBear() {
        return selectedBear != null;
    }
    /**
     * Visszaadja a kiválasztott Tile-t, ha nincs ilyen, akkor kivételt dob.
     * @return A kiválasztott Tile.
     */
    public Tile getSelectedTile() throws Exception {
        if (hasSelectedTile())
            return selectedTile;
        else throw new Exception("No tile is selected right now!");
    }
    /**
     * Visszaadja a kiválasztott Player-t, ha nincs ilyen, akkor kivételt dob.
     * @return A kiválasztott Player.
     */
    public Player getSelectedPlayer() throws Exception {
        if (hasSelectedPlayer())
            return selectedPlayer;
        else throw new Exception("No player is selected right now!");
    }
    /**
     * Visszaadja a kiválasztott PolarBear-t, ha nincs ilyen, akkor kivételt dob.
     * @return A kiválasztott PolarBear.
     */
    public PolarBear getSelectedBear() throws Exception {
        if (hasSelectedBear())
            return selectedBear;
        else throw new Exception("No bear is selected right now!");
    }

}
