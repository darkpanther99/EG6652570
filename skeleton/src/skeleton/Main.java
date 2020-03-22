package skeleton;

public class Main {
    public static void main(String[] args) {
        LoggerTest lt = new LoggerTest();
        Logger.logConstructorCall(lt, "myLoggerTest");
        lt.DoTest();
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
            fn2(d, 10);
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
