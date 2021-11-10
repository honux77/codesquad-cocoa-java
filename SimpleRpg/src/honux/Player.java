package honux;

public class Player {
    private String name;
    private Position position;
    private int score;

    public Player(String name, int x, int y) {
        this.name = name;
        this.position = new Position(x, y);
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", score=" + score +
                '}';
    }

    public boolean isSamePosition(int x, int y) {
        return this.position.getX() == x && this.position.getY() == y;
    }

    private void move(int x, int y) {
    }
}
