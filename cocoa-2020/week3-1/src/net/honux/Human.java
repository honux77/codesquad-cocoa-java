package net.honux;

import java.util.*;

public class Human {
    public String name;
    public Long money;

    static Map<Long, Human> codeSquad = new HashMap<>();
    static List<Human> codeSquadList = new ArrayList<>();

    public Human(String name, Long money) {
        this.name = name;
        this.money = money;
    }

     static void insert(Human h) {
        codeSquad.put(h.money, h);
        codeSquadList.add(h);
    }

    static void useMap() {
        //MapTest.main(null); 실행은 되지만 이렇게 쓰지 말자.

        //HashMap과 HashTable은 어떤 차이가 있을까? 공부해 보자.
        //TreeMap도 있는데 가끔 사용한다. 역시 알아보자.

        Human h1 = new Human("honux", 1000L);
        insert(h1);

        codeSquad.put(500000L, new Human("yeon", 500000L));

        //get의 장점은 빠르게 탐색이 가능한 자료구조입니다.
        //O(1) -> 충돌이 나면 O(n)
        //해시 자료구조를 내부적으로 사용합니다.
        Human h = codeSquad.get(100L);
        //null 체크
        //Optional을 사용하는 것도 좋은 방법이다. 한 번 공부해 본다.
        if (h != null) {
            System.out.println(h.name);
        } else {
            System.out.println("없음");
        }
    }

    static void iterateMap() {
        System.out.println("===========맵 순회하기 ====");
        for (var k: codeSquad.keySet()) {
            System.out.println(codeSquad.get(k));
        }

        System.out.println("===========맵 순회하기 2 ====");
        for (var k: codeSquad.entrySet()) {
            System.out.println(k.getValue());
        }
    }
    public static void main(String[] args) {
        useMap();
        iterateMap();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
