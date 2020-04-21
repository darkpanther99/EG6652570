package proto;

public interface Command {
    void Execute(Proto state);
    String toString();
}
