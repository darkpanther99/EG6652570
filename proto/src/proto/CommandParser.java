package proto;

import java.util.List;

public interface CommandParser {
    String getKeyword();
    Command parse(List<String> tokens);
}
