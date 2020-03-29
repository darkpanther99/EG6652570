package skeleton;

import skeleton.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Válassz a menüpontokból");
        System.out.print("1. Játékos\n" +
                "2. Tábla\n" +
                "3. Játék\n"
        );
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        switch (answer){
            case 1:
                System.out.print("1. felvesz\n" +
                    "2. lapátol\n" +
                    "3. lép\n" +
                    "4. cselekszik\n"
                );
                answer = sc.nextInt();
                switch (answer){
                    case 1:
                        System.out.print("1. ételt\n" +
                                "2. lapátot\n" +
                                "3. alkatrészt\n" +
                                "4. kötelet\n" +
                                "5. búvárruhát\n"
                        );
                        answer = sc.nextInt();
                        switch (answer){
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
                        break;
                    case 2:
                        System.out.print("1. kézzel\n" +
                                "2. lapáttal\n"
                        );
                        answer = sc.nextInt();
                        switch (answer){
                            case 1:
                                TestBareHandsDig();
                                break;
                            case 2:
                                TestShovelDig();
                                break;
                        }
                        break;
                    case 3:
                        System.out.print("1. jégre\n" +
                                "2. instabil jégre búvárruhával\n" +
                                "3. instabil jégre búvárruha nélkül\n" +
                                "4. vízbe búvárruhával\n" +
                                "5. vízbe búvárruha nélkül\n"
                        );
                        answer = sc.nextInt();
                        switch (answer){
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
                        break;
                    case 4:
                        System.out.print("1. kötéllel kiment\n" +
                                "2. eszik\n" +
                                "3. rakétát összeszerel"
                        );
                        answer = sc.nextInt();
                        switch (answer){
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
                        break;
                }
                break;
            case 2:
                System.out.print("1. iglut épít\n" +
                        "2. táblát vizsgál\n"
                );
                answer = sc.nextInt();
                switch (answer){
                    case 1:
                        TestBuildIgloo();
                        break;
                    case 2:
                        TestExamineTile();
                        break;
                }
                break;
            case 3:
                System.out.print("1. kör stabil jégen\n" +
                        "2. kör vízben\n" +
                        "3. kör vízben búvárruhában\n" +
                        "4. kör hóvihar igluban\n" +
                        "5. kör hóvihar üres mezőn\n"
                );
                answer = sc.nextInt();
                switch (answer){
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
                break;
        }

    }

    static void TestPickUpFood() {
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile currentTile = new Tile();
        Logger.logConstructorCall(currentTile, "currentTile");

        Food f = new Food();
        Logger.logConstructorCall(f, "food");

        FoodStore fs = new FoodStore();
        Logger.logConstructorCall(fs, "foodStore");

        e.setCurrentTile(currentTile);
        currentTile.setItem(f);
        e.setFoodStore(fs);

        e.PickUp();
    }

    static void TestPickupShovel() {
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile currentTile = new Tile();
        Logger.logConstructorCall(currentTile, "currentTile");

        Shovel s = new Shovel();
        Logger.logConstructorCall(s, "shovel");

        FoodStore fs = new FoodStore();
        Logger.logConstructorCall(fs, "foodStore");

        e.setCurrentTile(currentTile);
        currentTile.setItem(s);
        e.setFoodStore(fs);

        e.PickUp();
    }

    static void TestPickupPart() {
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile currentTile = new Tile();
        Logger.logConstructorCall(currentTile, "currentTile");

        Part p = new Part();
        Logger.logConstructorCall(p, "part");

        FoodStore fs = new FoodStore();
        Logger.logConstructorCall(fs, "foodStore");

        e.setCurrentTile(currentTile);
        currentTile.setItem(p);
        e.setFoodStore(fs);

        e.PickUp();
    }

    static void TestPickupRope() {
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile currentTile = new Tile();
        Logger.logConstructorCall(currentTile, "currentTile");

        Rope r = new Rope();
        Logger.logConstructorCall(r, "rope");

        FoodStore fs = new FoodStore();
        Logger.logConstructorCall(fs, "foodStore");

        e.setCurrentTile(currentTile);
        currentTile.setItem(r);
        e.setFoodStore(fs);

        e.PickUp();
    }

    static void TestPickupScubaGear() {
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile currentTile = new Tile();
        Logger.logConstructorCall(currentTile, "currentTile");

        ScubaGear sg = new ScubaGear();
        Logger.logConstructorCall(sg, "rope");

        FoodStore fs = new FoodStore();
        Logger.logConstructorCall(fs, "foodStore");

        e.setCurrentTile(currentTile);
        currentTile.setItem(sg);
        e.setFoodStore(fs);

        e.PickUp();
    }

    static void TestBareHandsDig() {
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile currentTile = new Tile();
        Logger.logConstructorCall(currentTile, "currentTile");

        BareHands b = new BareHands();
        Logger.logConstructorCall(b, "bareHands");

        e.setCurrentTile(currentTile);
        e.setDigStrategy(b);
        e.Dig();
    }

    static void TestShovelDig() {
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile currentTile = new Tile();
        Logger.logConstructorCall(currentTile, "currentTile");

        ShovelDig s = new ShovelDig();
        Logger.logConstructorCall(s, "bareHands");

        e.setCurrentTile(currentTile);
        e.setDigStrategy(s);
        e.Dig();
    }

    static void TestStepOnIce() {
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile a = new Tile();
        Logger.logConstructorCall(a, "a");

        Tile b = new Tile();
        Logger.logConstructorCall(b, "b");
        b.setWeightLimit(999);

        a.setNeighborAt(Direction.FORWARD, b);
        e.setCurrentTile(a);
        e.Step(Direction.FORWARD);
    }

    static void TestStepOnUnstableIceWithScubaGear(){
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile a = new Tile();
        Logger.logConstructorCall(a, "a");

        Tile b = new Tile();
        Logger.logConstructorCall(b, "b");

        e.setWaterResistanceStrategy(new ScubaWearing());

        a.setNeighborAt(Direction.FORWARD, b);
        e.setCurrentTile(a);
        e.Step(Direction.FORWARD);

    }

    static void TestStepOnUnstableIceNaked(){
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile a = new Tile();
        Logger.logConstructorCall(a, "a");

        Tile b = new Tile();
        Logger.logConstructorCall(b, "b");

        e.setWaterResistanceStrategy(new Naked());

        a.setNeighborAt(Direction.FORWARD, b);
        e.setCurrentTile(a);
        e.Step(Direction.FORWARD);
    }

    static void TestStepInHoleWithScubaGear(){
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile a = new Tile();
        Logger.logConstructorCall(a, "a");

        Tile b = new Tile();
        Logger.logConstructorCall(b, "b");

        b.setChillWaterStrategy(new Sea());

        e.setWaterResistanceStrategy(new ScubaWearing());

        a.setNeighborAt(Direction.FORWARD, b);
        e.setCurrentTile(a);
        e.Step(Direction.FORWARD);
    }

    static void TestStepInHoleNaked(){
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile a = new Tile();
        Logger.logConstructorCall(a, "a");

        Tile b = new Tile();
        Logger.logConstructorCall(b, "b");

        b.setChillWaterStrategy(new Sea());

        e.setWaterResistanceStrategy(new Naked());

        a.setNeighborAt(Direction.FORWARD, b);
        e.setCurrentTile(a);
        e.Step(Direction.FORWARD);
    }

    static void TestRopeRescue(){
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Eskimo e2 = new Eskimo();
        Logger.logConstructorCall(e2, "eskimo2");

        Tile a = new Tile();
        Logger.logConstructorCall(a, "ct");

        Tile b = new Tile();
        Logger.logConstructorCall(b, "w");

        b.setChillWaterStrategy(new Sea());

        e.setRescueStrategy(new RopeRescue());

        a.setNeighborAt(Direction.FORWARD, b);
        e.setCurrentTile(a);
        e2.setCurrentTile(b);
        e.RescueTeammate(Direction.FORWARD);
    }

    static void TestEatFood(){
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        FoodStore fs = new FoodStore();
        Logger.logConstructorCall(fs, "foodStore");

        fs.Gain();
        e.setFoodStore(fs);
        e.EatFood();
    }

    static void TestAssembleFlare(){
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Eskimo e2 = new Eskimo();
        Logger.logConstructorCall(e2, "eskimo2");

        Tile a = new Tile();
        Logger.logConstructorCall(a, "a");

        a.setChillWaterStrategy(new DryLand());
        e.setCurrentTile(a);
        e2.setCurrentTile(a);

        e.AssembleFlare();
    }

    static void TestBuildIgloo(){
        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");

        Tile ct = new Tile();
        Logger.logConstructorCall(ct, "ct");

        e.setCurrentTile(ct);

        e.BuildIgloo();
    }

    static void TestExamineTile(){
        PolarExplorer p = new PolarExplorer();
        Logger.logConstructorCall(p, "eskimo");

        Tile ct = new Tile();
        Logger.logConstructorCall(ct, "ct");

        Tile t = new Tile();
        Logger.logConstructorCall(t, "t");

        t.setNeighborAt(Direction.FORWARD, t);
        p.setCurrentTile(ct);
        p.Examine(Direction.FORWARD);
    }

    static void TestTurnOnStableIce(){
        Game g = new Game();
        Logger.logConstructorCall(g, "game");
        Player e = g.CreateEskimo();
        Tile t = g.CreateIce();
        e.setCurrentTile(t);
        g.Turn();
    }

    static void TestTurnInWaterNaked(){
        Game g = new Game();
        Logger.logConstructorCall(g, "game");
        Player e = g.CreateEskimo();
        Tile t = g.CreateSea();
        e.setCurrentTile(t);
        g.Turn();
    }

    static void TestTurnInWaterWithScubaGear(){
        Game g = new Game();
        Logger.logConstructorCall(g, "game");
        Player e = g.CreateEskimo();
        Tile t = g.CreateSea();
        e.setCurrentTile(t);
        e.setWaterResistanceStrategy(new ScubaWearing());
        g.Turn();
    }

    static void TestChillStormIgloo(){
        Tile t = new Tile();
        Logger.logConstructorCall(t, "tile");

        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");
        e.setCurrentTile(t);

        t.setChillStormStrategy(new Igloo());

        t.ChillStorm();
    }

    static void TestChillStormBareIce(){
        Tile t = new Tile();
        Logger.logConstructorCall(t, "tile");

        Eskimo e = new Eskimo();
        Logger.logConstructorCall(e, "eskimo");
        e.setCurrentTile(t);

        t.setChillStormStrategy(new BareIce());

        t.ChillStorm();
    }
}
