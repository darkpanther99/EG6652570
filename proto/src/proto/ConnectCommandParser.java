package proto;

import java.util.ArrayList;
import java.util.List;

public class ConnectCommandParser implements CommandParser {
    @Override
    public String getKeyword() {
        return "connect";
    }

    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        List<Integer> tmp = new ArrayList<>();
        if (tokens.size() < 2) throw new ProtoException("Invalid connect command.");
        for (var i : tokens.subList(1, tokens.size())) {
            tmp.add(Integer.parseInt(i));
        }
        return new ConnectCommand(tmp);
    }
}
