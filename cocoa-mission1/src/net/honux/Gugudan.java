package net.honux;

import java.util.Scanner;

public class Gugudan {

    static int[] getGugudanInputFromKeyboard() {
        int ret[] = new int[2];
        Scanner s = new Scanner(System.in);
        System.out.println("시작단을 입력해 주세요");
        ret[0] = s.nextInt();
        System.out.println("끝단을 입력해 주세요");
        ret[1] = s.nextInt();
        s.close();
        return ret;
    }

    static void printGugudan(int num) {
        System.out.println("=======" + num + " Dan ========" );
        for(int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d\t", num, i, num * i);
            if (i %3 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int[] darr = getGugudanInputFromKeyboard();

        for (int i = darr[0]; i <= darr[1]; i++) {
            printGugudan(i);
        }
    }
}
