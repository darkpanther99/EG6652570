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
        List<String> tmp = new ArrayList<String>(tokens);
        tmp.remove(0);

        List<Integer> res = new ArrayList<Integer>();
        for (String s : tmp) {
            res.add(Integer.parseInt(s));
        }

        return new ConnectCommand(res);

    }
}
