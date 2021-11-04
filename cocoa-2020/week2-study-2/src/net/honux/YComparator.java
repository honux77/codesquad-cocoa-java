package net.honux;

import java.util.Comparator;

public class YComparator implements Comparator <Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return o1.y - o2.y;
    }
}
