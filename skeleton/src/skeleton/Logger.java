package skeleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Naplózó.
 * A modell működését ezzel lehet figyelemmel követni.
 */
public class Logger {
    private Logger() {
    }

    private static final Object syncObject = new Object();
    private static final HashMap<Object, String> names = new HashMap<>();
    private static int indentation = 0;

    /**
     * Objektum elnevezése.
     * Az adott néven fog megjelenni az objektum a napló üzenetkeben.
     */
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
        final int spaces = 4;
        System.out.print(String.join("", Collections.nCopies(Math.max(0, i) * spaces, " ")));
    }

    /**
     * Metódushívás naplózása.
     * Kiírja a hívott objektum nevét, a hívott metódus nevét és a paramétereket.
     * Az indentációt növeli eggyel.
     * A hívott metódus nevét stack trace segítségével keresi meg.
     *
     * @param callee A hívott objektum (azaz: this).
     * @param params A kapott paraméterek listája.
     */
    public static void logMethodCall(Object callee, Object... params) {
        String methodName = "$missing_method$";
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if (st.length > 1) methodName = st[2].getMethodName();
        logMethodCall(callee, methodName, params);
    }

    /**
     * Metódushívás naplózása.
     * Kiírja a hívott objektum nevét, a hívott medódus nevét és a paramétereket.
     * Az indentációt növeli eggyel.
     *
     * @param callee     A hívott objektum (azaz: this).
     * @param methodName A hívott metódus neve.
     * @param params     A kapott paraméterek listája.
     */
    public static void logMethodCall(Object callee, String methodName, Object... params) {
        synchronized (syncObject) {
            indent(indentation++);
            String argList = Arrays.stream(params).map(Logger::getName).collect(Collectors.joining(", "));
            System.out.format("%s.%s(%s) {%n", getName(callee), methodName, argList);
        }
    }

    /**
     * Metódus visszatérés naplózása.
     * Kiírja a visszatérési érték nevét
     * Az indentációt csökkenti eggyel.
     */
    public static void logMethodReturn(Object returnValue) {
        synchronized (syncObject) {
            indent(indentation);
            System.out.format("return %s;%n", getName(returnValue));
            indent(--indentation);
            System.out.println("}");
        }
    }

    /**
     * Metódus visszatérés naplózása.
     * Az indentációt csökkenti eggyel.
     */
    public static void logMethodReturn() {
        synchronized (syncObject) {
            indent(--indentation);
            System.out.println("}");
        }
    }
}
