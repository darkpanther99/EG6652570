package skeleton;

import skeleton.model.*;

import static skeleton.Logger.*;

import java.util.Scanner;

// TODO: javadoc

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (Menu()) ;
    }

    private static boolean Menu() {
        System.out.println("Válassz a menüpontokból");
        System.out.print("1. Játékos\n" +
                "2. Tábla\n" +
                "3. Játék\n"
        );
        int answer = sc.nextInt();
        switch (answer) {
            case 1:
                Menu1();
                break;
            case 2:
                Menu2();
                break;
            case 3:
                Menu3();
                break;
            default:
                return false;
        }
        return true;
    }

    private static void Menu1() {
        System.out.print("1. felvesz\n" +
                "2. lapátol\n" +
                "3. lép\n" +
                "4. cselekszik\n"
        );
        int answer = sc.nextInt();
        switch (answer) {
            case 1:
                Menu11();
                break;
            case 2:
                Menu12();
                break;
            case 3:
                Menu13();
                break;
            case 4:
                Menu14();
                break;
        }
    }

    private static void Menu11() {
        System.out.print("1. ételt\n" +
                "2. lapátot\n" +
                "3. alkatrészt\n" +
                "4. kötelet\n" +
                "5. búvárruhát\n"
        );
        int answer = sc.nextInt();
        switch (answer) {
            case 1:
                TestPickUpFood();
                break;
            case 2:
                TestPickupShovel();
                break;
            case 3:
                TestPickupPart();
                break;
            case 4:
                TestPickupRope();
                break;
            case 5:
                TestPickupScubaGear();
                break;
        }
    }

    private static void Menu12() {
        System.out.print("1. kézzel\n" +
                "2. lapáttal\n"
        );
        int answer = sc.nextInt();
        switch (answer) {
            case 1:
                TestBareHandsDig();
                break;
            case 2:
                TestShovelDig();
                break;
        }
    }

    private static void Menu13() {
        System.out.print("1. jégre\n" +
                "2. instabil jégre búvárruhával\n" +
                "3. instabil jégre búvárruha nélkül\n" +
                "4. vízbe búvárruhával\n" +
                "5. vízbe búvárruha nélkül\n"
        );
        int answer = sc.nextInt();
        switch (answer) {
            case 1:
                TestStepOnIce();
                break;
            case 2:
                TestStepOnUnstableIceWithScubaGear();
                break;
            case 3:
                TestStepOnUnstableIceNaked();
                break;
            case 4:
                TestStepInHoleWithScubaGear();
                break;
            case 5:
                TestStepInHoleNaked();
                break;
        }
    }

    private static void Menu14() {
        System.out.print("1. kötéllel kiment\n" +
                "2. eszik\n" +
                "3. rakétát összeszerel"
        );
        int answer = sc.nextInt();
        switch (answer) {
            case 1:
                TestRopeRescue();
                break;
            case 2:
                TestEatFood();
                break;
            case 3:
                TestAssembleFlare();
                break;
        }
    }

    private static void Menu2() {
        System.out.print("1. iglut épít\n" +
                "2. táblát vizsgál\n"
        );
        int answer = sc.nextInt();
        switch (answer) {
            case 1:
                TestBuildIgloo();
                break;
            case 2:
                TestExamineTile();
                break;
        }
    }

    private static void Menu3() {
        System.out.print("1. kör stabil jégen\n" +
                "2. kör vízben\n" +
                "3. kör vízben búvárruhában\n" +
                "4. kör hóvihar igluban\n" +
                "5. kör hóvihar üres mezőn\n"
        );
        int answer = sc.nextInt();
        switch (answer) {
            case 1:
                TestTurnOnStableIce();
                break;
            case 2:
                TestTurnInWaterNaked();
                break;
            case 3:
                TestTurnInWaterWithScubaGear();
                break;
            case 4:
                TestChillStormIgloo();
                break;
            case 5:
                TestChillStormBareIce();
                break;
        }
    }

    private static void TestPickUpFood() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);
        Food f = new Food();
        logConstructorCall(f, "food");
        currentTile.setItem(f);

        e.PickUp();
    }

    private static void TestPickupPart() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);
        Part p = new Part();
        logConstructorCall(p, "part");
        currentTile.setItem(p);

        e.PickUp();
    }

    private static void TestPickupShovel() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);
        Shovel s = new Shovel();
        logConstructorCall(s, "shovel");
        currentTile.setItem(s);

        e.PickUp();
    }


    private static void TestPickupRope() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);
        Rope r = new Rope();
        logConstructorCall(r, "rope");
        currentTile.setItem(r);

        e.PickUp();
    }

    private static void TestPickupScubaGear() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);
        ScubaGear sg = new ScubaGear();
        logConstructorCall(sg, "scubaGear");
        currentTile.setItem(sg);

        e.PickUp();
    }

    private static void TestBareHandsDig() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);

        e.Dig();
    }

    private static void TestShovelDig() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);
        ShovelDig s = new ShovelDig();
        logConstructorCall(s, "bareHands");
        e.setDigStrategy(s);

        e.Dig();
    }

    private static void TestStepOnIce() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile a = g.CreateIce("a");
        e.PlaceOn(a);
        Tile b = g.CreateIce("b");
        a.setNeighborAt(Direction.FORWARD, b);

        e.Step(Direction.FORWARD);
    }

    private static void TestStepOnUnstableIceWithScubaGear() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        WaterResistanceStrategy ws = new ScubaWearing();
        logConstructorCall(ws, "scubaWearing");
        e.setWaterResistanceStrategy(ws);
        Tile a = g.CreateIce("a");
        e.PlaceOn(a);
        Eskimo dummy = g.CreateEskimo("dummy");
        Tile b = g.CreateUnstableIce("b");
        b.setWeightLimit(2);
        dummy.setCurrentTile(b);
        b.getOccupants().add(dummy);
        a.setNeighborAt(Direction.FORWARD, b);

        e.Step(Direction.FORWARD);
    }

    private static void TestStepOnUnstableIceNaked() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile a = g.CreateIce("a");
        e.PlaceOn(a);
        Eskimo dummy = g.CreateEskimo("dummy");
        Tile b = g.CreateUnstableIce("b");
        b.setWeightLimit(2);
        dummy.setCurrentTile(b);
        b.getOccupants().add(dummy);
        a.setNeighborAt(Direction.FORWARD, b);

        e.Step(Direction.FORWARD);
    }

    private static void TestStepInHoleWithScubaGear() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        WaterResistanceStrategy ws = new ScubaWearing();
        logConstructorCall(ws, "scubaWearing");
        e.setWaterResistanceStrategy(ws);
        Tile a = g.CreateIce("a");
        e.PlaceOn(a);
        Tile b = g.CreateHole("b");
        a.setNeighborAt(Direction.FORWARD, b);

        e.Step(Direction.FORWARD);
    }

    private static void TestStepInHoleNaked() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile a = g.CreateIce("a");
        e.PlaceOn(a);
        Tile b = g.CreateHole("b");
        a.setNeighborAt(Direction.FORWARD, b);

        e.Step(Direction.FORWARD);
    }

    private static void TestRopeRescue() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        RescueStrategy rs = new RopeRescue();
        logConstructorCall(rs, "rope");
        e.setRescueStrategy(rs);
        Tile currentTile = g.CreateIce("land");
        e.PlaceOn(currentTile);
        Eskimo dummy = g.CreateEskimo("dummy");
        Tile hole = g.CreateHole("hole");
        dummy.setCurrentTile(hole);
        hole.getOccupants().add(dummy);
        currentTile.setNeighborAt(Direction.FORWARD, hole);

        e.RescueTeammate(Direction.FORWARD);
    }

    private static void TestEatFood() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        e.getFoodStore().Gain();

        e.EatFood();
    }

    private static void TestAssembleFlare() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);
        e.getPartStore().setCount(2);
        Eskimo dummy = g.CreateEskimo("dummy");
        dummy.PlaceOn(currentTile);
        dummy.getPartStore().setCount(1);

        e.AssembleFlare();
    }

    private static void TestBuildIgloo() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);

        e.BuildIgloo();
    }

    private static void TestExamineTile() {
        Game g = new Game();
        logConstructorCall(g, "game");
        PolarExplorer p = g.CreatePolarExplorer();
        Tile currentTile = g.CreateIce("currentTile");
        p.PlaceOn(currentTile);
        Tile unstableIce = g.CreateUnstableIce();
        currentTile.setNeighborAt(Direction.FORWARD, unstableIce);

        p.Examine(Direction.FORWARD);
    }

    private static void TestTurnOnStableIce() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);

        g.Turn();
    }

    private static void TestTurnInWaterNaked() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateSea("currentTile");
        e.PlaceOn(currentTile);

        g.Turn();
    }

    private static void TestTurnInWaterWithScubaGear() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        WaterResistanceStrategy ws = new ScubaWearing();
        logConstructorCall(ws, "scubaWearing");
        e.setWaterResistanceStrategy(ws);
        Tile currentTile = g.CreateSea("currentTile");
        e.PlaceOn(currentTile);

        g.Turn();
    }

    private static void TestChillStormIgloo() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);
        ChillStormStrategy cs = new Igloo();
        logConstructorCall(cs, "igloo");
        currentTile.setChillStormStrategy(cs);

        currentTile.ChillStorm();
    }

    private static void TestChillStormBareIce() {
        Game g = new Game();
        logConstructorCall(g, "game");
        Eskimo e = g.CreateEskimo();
        Tile currentTile = g.CreateIce("currentTile");
        e.PlaceOn(currentTile);

        currentTile.ChillStorm();
    }
}
