import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class FifteenPuzzle {
    private final static int SIZE = 4;
    private int[][] board;

    public FifteenPuzzle() {
        this.board = new int[SIZE][SIZE];
        List<Integer> numList = new ArrayList<Integer>();

        for(int i = 0; i < SIZE * SIZE; i++) {
            numList.add(i);
        }

        Collections.shuffle(numList);

        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = numList.get(i * SIZE + j);
            }
        }
    }

    public void printBoard() {
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%3d", this.board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FifteenPuzzle f = new FifteenPuzzle();
        f.printBoard();
    }
}