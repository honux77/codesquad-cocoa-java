package net.honux;

import java.util.Objects;

public class Point implements Comparable{
    public int x;
    public int y;
    public int value;

    public static int one = 65535;

    public Point(int x, int y, int v) {
        this.x = x;
        this.y = y;
        value = v;
    }

    public final void sayPos() {
        System.out.println("나는"
                + this.x +"에 있어요!");
    }

    public static void say() {
        System.out.println("I am point" + one);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return value == point.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Object o) {
        Point p = (Point) o;
        return this.x - p.x;
    }
}
