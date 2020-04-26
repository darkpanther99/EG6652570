package proto;

import proto.model.PolarExplorer;

public class ExamineCommand implements Command {
    /**
     * Az szomszédos mező iránya, amit a sarkkutató vizsgál
     */
    private int direction;

    /**
     * Konstruktor
     * @param direction Az szomszédos mező iránya, amit a sarkkutató vizsgál
     */
    public ExamineCommand(int direction) {
        this.direction = direction;
    }

    /**
     * Megvizsgálja a sarkkutató a szomszédos mezőt.
     * @param state
     * @throws ProtoException ha nincs játékos/nem sarkkutató van kiválasztva, kivételt dob.
     */
    @Override
    public void execute(Proto state) throws ProtoException {

        if (state.getSelectedPlayer() instanceof PolarExplorer) {
            PolarExplorer p = (PolarExplorer) state.getSelectedPlayer();
            p.examine(direction);
        } else {
            throw new ProtoException("Nem sarkkutato van kivalasztva");
        }
    }

    @Override
    public String toString() {
        return "examine " + direction;
    }
}
