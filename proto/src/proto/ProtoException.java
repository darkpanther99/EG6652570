package proto;

/**
 * Akkor keletkezik, ha a Proto illegális parancsot kap.
 */
public class ProtoException extends Exception {
    public ProtoException() {
        super();
    }

    public ProtoException(String message) {
        super(message);
    }

    public ProtoException(String message, Throwable cause) {
        super(message, cause);
    }
}
