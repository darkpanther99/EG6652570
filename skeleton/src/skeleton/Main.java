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

    static void TestPickupScubeGear() {
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

        a.setNeighborTiles(b);
        e.setCurrentTile(a);
        // e.Step(forward);
        // TODO: ENUM
    }


    private static class LoggerTest {
        void DoTest() {
            Logger.logMethodCall(this);
            fn1();
            Logger.logMethodReturn();
        }

        private static class DummyObject {
            void fn3(int i) {
                Logger.logMethodCall(this, i);
                Logger.logMethodReturn();
            }
        }

        DummyObject fn1() {
            Logger.logMethodCall(this);
            DummyObject d = new DummyObject();
            Logger.logConstructorCall(d, "myDummyObject");
            boolean pr = Logger.prompt("Does the set of all sets contain itself?", true);
            fn2(d, pr ? 10 : 20);
            Logger.logMethodReturn(d);
            return d;
        }

        int fn2(DummyObject d, int i) {
            Logger.logMethodCall(this, d, i);
            d.fn3(2 * i);
            Logger.logMethodReturn(1234);
            return 1234;
        }
    }
}
