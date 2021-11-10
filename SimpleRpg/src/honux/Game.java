package honux;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int WIDTH = 5;
    private final int HEIGHT = 5;
    private final int PLAYER_X = 2;
    private final int PLAYER_Y = 2;
    private final int MAX_MONSTER = 3;

    private Player player;
    private int[][] map;
    private List<Monster> monsters;


    public boolean isValidLocation(int x, int y) {
        if(player.isSamePosition(x, y)) return false;
        return true;
    }

    public void init() {
        createMap(WIDTH, HEIGHT);
        String name = getNameFromUser();
        player = new Player(name,PLAYER_X, PLAYER_Y);
        setMonsters();
    }

    public void setMonsters() {
        monsters = new ArrayList<>();
        for (int i = 1; i <= MAX_MONSTER; i++) {
            Position p = generateValidRandomPostion();
            Monster m = new Monster(i, p);
            monsters.add(m);
        }
    }

    //TODO: must implement!!
    private Position generateValidRandomPostion() {
        return new Position(1, 1);
    }

    //TODO: 키보드 입력을 받도록 수정
    private String getNameFromUser() {
        return "honux";
    }

    private void createMap(int w, int h) {
        map = new int[w][h];
    }

    public void start() {
        System.out.println("게임을 시작하지!");
    }

    public void showResult() {
        System.out.println("Thank you for playing");

        System.out.println(this.player);
        for (Monster m:monsters) {
            System.out.println(m);
        }

        System.out.println("당신의 점수: " + player.getScore());
    }
}
