package honux;

public class Player {
    private String name;
    private int x;
    private int y;
    private int score;

    public Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    private void move(int x, int y) {
    }
}
