package proto;

/**
 * Parancs interfész
 */
public interface Command {
    /**
     * Végrehajtás az adott állapoton
     * @param state
     * @throws ProtoException
     */
    void execute(Proto state) throws ProtoException;

    /**
     * Így jelenik meg a konzolon.
     * @return
     */
    String toString();
}
