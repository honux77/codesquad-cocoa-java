package honux;

public class Game {

    private final int WIDTH = 5;
    private final int HEIGHT = 5;
    private final int PLAYER_X = 2;
    private final int PLAYER_Y = 2;

    private Player player;
    private int[][] map;
    private Monster monster;

    public void init() {
        createMap(WIDTH, HEIGHT);
        String name = getNameFromUser();
        player = new Player(name,PLAYER_X, PLAYER_Y);
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
        System.out.println("당신의 점수: " + player.getScore());
    }
}
