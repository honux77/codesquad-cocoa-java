package net.honux;

import java.util.Scanner;

public class Gugudan {

    public int start;
    public int end;

    public void init() {
        Scanner s = new Scanner(System.in);
        System.out.println("시작단을 입력해 주세요");
        this.start = s.nextInt();
        System.out.println("끝단을 입력해 주세요");
        this.end = s.nextInt();
        s.close();
    }

    private void printGugudan(int num) {
        System.out.println("=======" + num + " Dan ========" );
        for(int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d\t", num, i, num * i);
            if (i %3 == 0) System.out.println();
        }
        System.out.println();
    }
    
    public void printAll() {
        for(int i = this.start; i <= this.end; i++) {
            printGugudan(i);
        }
    }

    public static void main(String[] args) {
        Gugudan gugu = new Gugudan();
        gugu.init();
        gugu.printAll();
    }
}
