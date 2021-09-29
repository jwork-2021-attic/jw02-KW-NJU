package S191220109.task3;

public class Matrix extends Line {

    public Matrix(int length) {
        this.positions = new Position[length];
    }

    @Override
    public String toString() {
        double n = Math.sqrt(positions.length), i = 0;
        String lineString = "";
        for (Position p : positions) {
            lineString += p.monster.toString();
            ++i;
            if (i % n == 0)
                lineString += "\n";
        }
        return lineString;
    }
}
