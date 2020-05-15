package grafikus;

import grafikus.model.Player;

/**
 * Játékos kiválasztása esemény.
 * Akkor keletkezik, ha a PlayerListMenuben egy játékosra kattintanak.
 */
public interface PlayerSelectListener {
    /**
     * @param p A kiválasztandó játékos.
     */
    void select(Player p);
}
