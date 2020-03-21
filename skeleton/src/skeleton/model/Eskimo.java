package skeleton.model;

import skeleton.Logger;

public class Eskimo extends Player {
    public void BuildIgloo() {
        Logger.logMethodCall(this);
        Igloo c = new Igloo();
        currentTile.setChillStormStrategy(c);
        Logger.logMethodReturn();
    }
}
