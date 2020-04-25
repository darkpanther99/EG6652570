package proto;

public interface Command {
    void execute(Proto state) throws Exception;
    String toString();
}
