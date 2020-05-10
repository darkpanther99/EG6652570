package grafikus;

import grafikus.model.Player;

public interface PlayerSelectListener {
    void select(Player p);
    void deselect(Player p);
}
