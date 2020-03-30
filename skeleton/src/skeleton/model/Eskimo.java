package skeleton.model;

import static skeleton.Logger.*;

/**
 * Eszkimó, játékos osztály.
 */
public class Eskimo extends Player {

    public Eskimo() {
        super();
    }

    /**
     * Különleges képessége az igluépítés.
     * A jelen cellára épül egy iglu, ami véd a vihar ellen.
     */
    public void BuildIgloo() {
        logMethodCall(this);
        Igloo igloo = new Igloo();
        logConstructorCall(igloo, "igloo");
        currentTile.setChillStormStrategy(igloo);
        logMethodReturn();
    }
}
