package net.honux;

public class ThreadTest {
    public static void main(String[] args) {
        double d = 1.1;
        long count = 0;
        while (true) {
            d *= 1.1;
            count++;
            System.out.println(count + ", " + d);
        }
    }
}
