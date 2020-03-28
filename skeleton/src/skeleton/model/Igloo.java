package skeleton.model;

import skeleton.Logger;

/**
 * Iglu.
 * Azokon a cellákon, amiken iglu áll, ez történik hóviharban.
 */
public class Igloo implements ChillStormStrategy {
    /**
     * Semmi nem történik. A cellán lévő játékosok nem hűlnek.
     *
     * @param t A cella.
     */
    public void Chill(Tile t) {
        Logger.logMethodCall(this, t);
        Logger.logMethodReturn();
    }
}
