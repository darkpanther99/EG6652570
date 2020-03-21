package skeleton;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Logger {
    private Logger() {
        throw new NotImplementedException();
    }

    private static final Object syncObject = new Object();
    private static final HashMap<Object, String> names = new HashMap<>();
    private static int indentation = 0;

    public static void setName(Object o, String name) {
        synchronized (syncObject) {
            names.put(o, name);
        }
    }

    private static String getName(Object o) {
        String n = o.toString();
        if (names.containsKey(o))
            n = names.get(o);
        return n;
    }

    private static void indent(int i) {
        System.out.print(String.join("", Collections.nCopies(i, "\t")));
    }

    public static void logMethodCall(Object callee, Object... params) {
        String methodName = "$missing_method$";
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if (st.length > 1) methodName = st[2].getMethodName();
        logMethodCall(callee, methodName, params);
    }

    public static void logMethodCall(Object callee, String methodName, Object... params) {
        synchronized (syncObject) {
            indent(indentation++);
            String argList = Arrays.stream(params).map(Logger::getName).collect(Collectors.joining(", "));
            System.out.format("%s.%s(%s) {%n", getName(callee), methodName, argList);
        }
    }

    public static void logMethodReturn(Object returnValue) {
        synchronized (syncObject) {
            indent(indentation);
            System.out.format("return %s;%n", returnValue);
            indent(--indentation);
            System.out.println("}");
        }
    }

    public static void logMethodReturn() {
        synchronized (syncObject) {
            indent(--indentation);
            System.out.println("}");
        }
    }
}
