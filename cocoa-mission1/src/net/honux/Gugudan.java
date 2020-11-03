package net.honux;

import java.util.Scanner;

public class Gugudan {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("시작단을 입력해 주세요");
        int start = s.nextInt();
        System.out.println("끝단을 입력해 주세요");
        int end = s.nextInt();
        System.out.printf("%d %d\n", start, end);
    }
}
