package proto;

// Ezzel az osztállyal sokkal több munka lesz, mint a többivel!

public class QueryCommand implements Command {
    @Override
    public void execute(Proto state) {
        throw new RuntimeException();
    }

    @Override
    public String toString() {
        throw new RuntimeException();
    }
}
