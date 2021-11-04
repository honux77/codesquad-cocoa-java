package net.honux;


import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        //래퍼 클래스 이야기
        //Long x = new Long(100);
        //long lx = 100L;
        //Long objX = lx; //100L = 리터럴
        //long lx2 = objX;

        //KV 구조
        //유사어: 딕셔너리 - python, Object - JS, map, HashMap
        Map<String, Long> map = new HashMap<>();

        String name = "Honux";
        Long score = 1000000L;

        //Insert
        //map.put("Honux", new Long(100L));
        //autoboxing
        map.put(name, score);
        //Get
        //Long score = map.get("Honux");
        long result = map.get(name); //unboxing
        System.out.println(result == score);
        System.out.println(map.size() == 1);

        map.put("jk", 90L);
        System.out.println(map.size() == 2);

        //키를 중복 저장할 수 없다. 값이 덮어쓰기 된다.
        map.put(name, score + 100);
        System.out.println(map.size());
        System.out.println(map.get(name) == score + 100);

        //없는 값 찾기
        System.out.println(map.get("crong"));

    }
}
