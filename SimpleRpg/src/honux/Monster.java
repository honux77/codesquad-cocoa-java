package honux;

import java.util.Random;

public class Monster {
    private String name;
    private Position position;

    public Monster(int n, Position p) {
        this.name = "몬스터" + n;
        this.position = new Position(p.getX(), p.getY());
    }

    @Override
    public String toString() {
        return "Monster{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
    }
}
