package skeleton;

public class Main {
    public static void main(String[] args) {
        LoggerTest lt = new LoggerTest();
        Logger.setName(lt, "MyLoggerTest");
        lt.DoTest();
    }

    /*
    Ezt printeli:
    MyLoggerTest.DoTest() {
        MyLoggerTest.fn1() {
            MyLoggerTest.fn2(MyDummyObject, 10) {
                MyDummyObject.fn3(20) {
                }
                return 3;
            }
            return MyDummyObject;
        }
    }
    */
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
            Logger.setName(d, "MyDummyObject");
            int i = 10;
            int x = fn2(d, i);
            Logger.logMethodReturn(d);
            return d;
        }

        int fn2(DummyObject d, int i) {
            Logger.logMethodCall(this, d, i);
            d.fn3(2 * i);
            Logger.logMethodReturn(3);
            return 1234;
        }
    }
}
