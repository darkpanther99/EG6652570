package skeleton;

import skeleton.model.*;

public class Main {
    public static void main(String[] args) {
        TestPickUpFood();
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

    static void TestBarehandsDig() {
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

        PartStore ps1 = new PartStore();
        Logger.logConstructorCall(ps1, "partStore1");

        PartStore ps2 = new PartStore();
        Logger.logConstructorCall(ps2, "partStore1");

        ps1.Gain(1);
        ps2.Gain(2);

        e.setPartStore(ps1);
        e2.setPartStore(ps2);

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

        g.CreateEskimo();
        g.CreateIce();

        g.Turn();
    }

    static void TurnInWaterNaked(){
        Game g = new Game();
        Logger.logConstructorCall(g, "game");

        g.CreateEskimo();
        g.CreateSea();

        
        g.Turn();
    }


}
