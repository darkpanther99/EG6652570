package skeleton.model;

import skeleton.Logger;

/**
 * Ez majd a grafikusban enum lesz.
 * Így oldjuk meg, hogy a skeletonban legyen kiírható neve a forward-nak.
 */
public class Direction {
    @SuppressWarnings("CanBeFinal")
    public static int FORWARD = 0xDEADBEEF; // ne ütközzön más intekkel

    // A gyengébbek kedvéért: ez egy statikus konstruktor,
    // ami akkor fut le amikor először hozzáférnek az osztályhoz.
    static {
        Logger.setDisplayName(FORWARD, "forward");
    }
}
