package proto;

public class DigCommand implements Command {
    @Override
    public void Execute(Proto state) {
        throw new RuntimeException();
    }

    @Override
    public String toString() {
        throw new RuntimeException();
    }
}
