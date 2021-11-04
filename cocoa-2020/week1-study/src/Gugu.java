import java.util.Scanner;

public class Gugu {
    private int start;
    private int end;

    public boolean getInputFromKeyboard() {
        Scanner s = new Scanner(System.in);
        System.out.println("시작단과 끝단을 입력해 주세요.(1-9)");
        int start = s.nextInt();
        int end = s.nextInt();
        if (start < 1 || end > 9 || start > end) {
            System.out.println("잘못 입력하셨!");
            return false;
        }
        this.start = start;
        this.end = end;
        return true;
    }

    @Override
    public String toString() {
        return "Gugu{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public static void main(String[] args) {
        Gugu g = new Gugu();

        boolean valid = g.getInputFromKeyboard();

        while(!valid) {
            valid = g.getInputFromKeyboard();
        }
        System.out.println(g);
    }
}