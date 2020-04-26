package proto;

import java.util.ArrayList;
import java.util.List;

public class ConnectCommandParser implements CommandParser {
    private String keyword;

    public ConnectCommandParser() {
        keyword = "connect";
    }

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public Command parse(List<String> tokens) throws ProtoException {
        List<Integer> tmp = new ArrayList<Integer>();
        if(tokens.size() < 2) throw new ProtoException("Invalid connect command.");
        for (var i : tokens.subList(1, tokens.size())) {
            tmp.add(Integer.parseInt(i));
        }
        return new ConnectCommand(tmp);
    }
}
