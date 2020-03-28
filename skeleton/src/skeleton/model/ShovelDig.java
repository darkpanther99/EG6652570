package skeleton.model;

import static skeleton.Logger.*;

public class ShovelDig implements DigStrategy {
    /*
    private boolean lastUsed;
    public boolean Dig(Tile t) {
        // @NOTE(boti): mindig az elozo allapotot adjuk vissza, igy minden
        //             paros asaskor adunk vissza true-t
        // @TODO(boti): Ha tobbfele asast akarunk, akkor int-et kene tarolni. Ennel a dig-nel pl.
        //              azt inkrementalnank minden lepesben es digCount % 2 == 0-t adnank vissza
        lastUsed = !lastUsed;
        return !lastUsed;
    }
    */

    public boolean Dig(Tile t) {
        logMethodCall(this, t);
        t.DecrementSnow();
        boolean tiring = prompt("Fárasztó volt az ásás?", true);
        logMethodReturn(tiring);
        return tiring;
    }
}
