package skeleton.model;

import skeleton.Logger;

public class Eskimo extends Player {
    public void BuildIgloo() {
        Logger.logMethodCall(this);
        Igloo igloo = new Igloo();
        Logger.logConstructorCall(igloo, "igloo");
        currentTile.setChillStormStrategy(igloo);
        Logger.logMethodReturn();
    }
}
