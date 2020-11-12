package net.honux;

import java.util.*;

public class Main {

    public static Point printPoint(Point p) {
        System.out.println(p.x);
        System.out.println(p.y);
        System.out.println(Point.one);
        Point.say();
        p.sayPos();
        return p;
    }

    public static void main(String[] args) {
        //List로 선언을 하는 게 더 일반적
        //List <Point> l = new LinkedList<>();
        LinkedList<Point> l = new LinkedList<>();

        Random r = new Random();
        //insert
        for (int i = 0; i < 10; i++) {
            l.add(new Point(100 + (i % 5) * 20,
                    r.nextInt(3),
                    r.nextInt(5)));
        }

        l.add(5, new Point(999, 999, 999));

        for (int i = 0; i < l.size(); i++) {
            System.out.println(i + ": " + l.get(i));
        }

        int idx = -1;
        System.out.println("\n====검색=====");
        for (int i = 0; i < l.size(); i++) {
            Point p = l.get(i);
            if (p.value == 999) {
                System.out.println("찾았다! " + p);
                System.out.println("위치: " + i);
                idx = i;
            }
        }

        System.out.println("정렬 1 - implements comparable");
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(i + ": " + l.get(i));
        }

        System.out.println("정렬 2- Comparator 클래스 상속");
        Collections.sort(l, new YComparator());
        for (int i = 0; i < l.size(); i++) {
            System.out.println(i + ": " + l.get(i));
        }

        System.out.println("정렬 3");
        Collections.sort(l, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.y - o1.y;
            }
        });
        for (int i = 0; i < l.size(); i++) {
            System.out.println(i + ": " + l.get(i));
        }

        System.out.println("정렬 4");
        Collections.sort(l, (Point p1, Point p2) -> {
            return p2.value - p1.value;
        });

        for (int i = 0; i < l.size(); i++) {
            System.out.println(i + ": " + l.get(i));
        }

        System.out.println("\n====삭제1=====");

        Point p3 = l.get(5);
        Point p2 = new Point(999, 999, 999);
        boolean isRemove = l.remove(p2);
        System.out.println("삭제여부:" + isRemove);
        System.out.println("==: " + (p3 == p2)); //동일성 검사 false
        System.out.println("equal: " + p3.equals(p2)); //동일성 검사 true


        System.out.println("\n====삭제2=====");

        while (!l.isEmpty()) {
            //LinkedList 전용 메소드 호출
            Point p = l.removeLast();
            System.out.println("size:" + l.size()
                    + " " + p);
        }

    }
}
