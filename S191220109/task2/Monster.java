package S191220109.task2;

import S191220109.task2.Line.Position;

public class Monster implements Linable {

    private final int r;
    private final int g;
    private final int b;
    private int numrank;

    private Position position;

    public Monster(int i) {
        this.r = (i >> 4) << 4;
        this.g = ((i >> 2) & 0xf) << 4;
        this.b = (i & 0xf) << 4;
        this.numrank = i;
    }

    public int rank() {
        return numrank + 1;
    }

    @Override
    public String toString() {
        String a = "";
        if (this.rank() < 10)
            a = " ";
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;255;255;255m  " + a + this.rank()
                + "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank();
    }

}