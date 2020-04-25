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
    public Command parse(List<String> tokens) {
        List<Integer> tmp = new ArrayList<Integer>();
        for (var i : tokens) {
            tmp.add(Integer.parseInt(i));
        }
        tmp.remove(0);
        return new ConnectCommand(tmp);

    }
}
