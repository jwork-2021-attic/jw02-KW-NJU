package S191220109.task3;

public class Line {

    public Line() {

    }

    public Line(int length) {
        this.positions = new Position[length];
    }

    protected Position[] positions;

    public void put(Monster monster, int i, int n) {
        if (this.positions[i] == null) {
            this.positions[i] = new Position(null);
        }
        this.positions[i].setLinable(monster);
    }

    public Monster get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i].monster;
        }
    }

    class Position {

        protected Monster monster;

        Position(Monster monster) {
            this.monster = monster;
        }

        public void setLinable(Monster monster) {
            this.monster = monster;
            monster.setPosition(this);
        }
    }

    @Override
    public String toString() {
        String lineString = "";
        for (Position p : positions) {
            lineString += p.monster.toString();
        }
        return lineString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].monster;
        }

        return linables;

    }

}
