package proto;

public interface Command {
    void execute(Proto state);
    String toString();
}
