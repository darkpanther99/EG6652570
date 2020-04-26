package proto;

public interface Command {
    void execute(Proto state) throws ProtoException;
    String toString();
}
