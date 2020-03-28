package skeleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Naplózó.
 * A modell működését ezzel lehet figyelemmel követni.
 */
public final class Logger {
    private Logger() {
    }

    private static final HashMap<Object, String> names = new HashMap<>();
    private static int indentation = 0;

    public static void setDisplayName(Object o, String name) {
        names.put(o, name);
    }

    private static String getName(Object o) {
        String n = o.toString();
        if (names.containsKey(o))
            n = names.get(o);
        return n;
    }

    private static void log(String msg) {
        final int spaces = 4;
        System.out.print(String.join("", Collections.nCopies(Math.max(0, indentation) * spaces, " ")));
        System.out.print(msg);
    }

    /**
     * Eldöntendő kérdés feltevése a konzolon.
     *
     * @param message A kérdés.
     * @return A válasz.
     */
    public static boolean prompt(String message) {
        return prompt(message, false);
    }

    /**
     * Eldöntendő kérdés feltevése a konzolon.
     *
     * @param message A kérdés.
     * @param def     A válasz, ha nincs válasz. (default)
     * @return A válasz.
     */
    public static boolean prompt(String message, boolean def) {
        log(String.format(def ? "%s (Y/n): " : "%s (y/N): ", message));
        String line = new Scanner(System.in).nextLine();
        if (line.length() == 0) return def;
        char answer = Character.toLowerCase(line.charAt(0));
        return answer == 'y' || answer == 'i'; // yes, igen
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
        if (st.length > 2) methodName = st[2].getMethodName();
        logMethodCall(callee, methodName, params);
    }

    /**
     * Metódushívás naplózása.
     * Kiírja a hívott objektum nevét, a hívott metódus nevét és a paramétereket.
     * Az indentációt növeli eggyel.
     *
     * @param callee     A hívott objektum (azaz: this).
     * @param methodName A hívott metódus neve.
     * @param params     A kapott paraméterek listája.
     */
    private static void logMethodCall(Object callee, String methodName, Object... params) {
        String argList = Arrays.stream(params).map(Logger::getName).collect(Collectors.joining(", "));
        log(String.format("%s.%s(%s) {%n", getName(callee), methodName, argList));
        indentation++;
    }

    /**
     * Metódus visszatérés naplózása.
     * Kiírja a visszatérési érték nevét
     * Az indentációt csökkenti eggyel.
     */
    public static void logMethodReturn(Object returnValue) {
        log(String.format("return %s;%n", getName(returnValue)));
        indentation--;
        log(String.format("}%n"));
    }

    /**
     * Metódus visszatérés naplózása.
     * Az indentációt csökkenti eggyel.
     */
    public static void logMethodReturn() {
        indentation--;
        log(String.format("}%n"));
    }

    /**
     * Konstruktorhívás naplózása.
     * Elnevezi az objektumot és kiírja, hogy létrejött.
     * Ezt a metódust nem az új objektum hívja a konstruktorában, hanem a
     * létrehozó objektum, mert az tud nevet adni neki.
     * Ez a metódus nem kap paraméter listát, mert a modellbeli osztályoknak
     * csak paraméter nélküli konstruktora van.
     *
     * @param newObject A létrehozott objektum.
     * @param newName   A létrehozott objektum neve.
     */
    public static void logConstructorCall(Object newObject, String newName) {
        setDisplayName(newObject, newName);
        logMethodCall(newObject, newObject.getClass().getSimpleName());
        logMethodReturn();
    }
}
