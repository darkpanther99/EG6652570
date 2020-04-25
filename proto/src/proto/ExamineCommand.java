package proto;

import proto.model.PolarExplorer;

public class ExamineCommand implements Command {
    private int direction;

    public ExamineCommand(int direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Proto state) throws Exception {
        if (state.getSelectedPlayer() instanceof PolarExplorer) {
            PolarExplorer p = (PolarExplorer) state.getSelectedPlayer();
            p.examine(direction);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "examine " + direction;
    }
}
