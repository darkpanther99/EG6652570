package proto;

import java.util.List;

/**
 * Parancsok elkészítéséhez használt interfész
 */
public interface CommandParser {
    /**
     * A Parancs kulcsszavát adja vissza.
     * @return A kulcsszó
     */
    String getKeyword();

    /**
     * Elkészíti a parancsot tokenekből.
     * @param tokens
     * @return A parancs
     * @throws ProtoException
     */
    Command parse(List<String> tokens) throws ProtoException;
}
