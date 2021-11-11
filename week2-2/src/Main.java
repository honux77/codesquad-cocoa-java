import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, cocoa!");
        //지역변수, 기본타입
        int a = 4;
        //참조타입 지역변수 honux <- 휴면 클래스의 인스턴스를 만들어서 그 객체의 주소를 저장
        Human honux = new Human("Honux", 20, 65);
        //int 배열, 참조타입 <- 힙에 인트 배열 4개가 생기고 그 주소를 넣어줌
        int[] b = new int[4];
        b[3] = 5;
        System.out.println(b[3]);

        //휴면배열, 참조타입
        Human[] cocoas = new Human[5];
        for (int i = 0; i < 5; i++) {
            cocoas[i] = new Human();
        }
        cocoas[3].setName("땃고양이");

        for (Human h:cocoas) {
            System.out.println(h);
        }

        //ArrayList kk = new ArrayList();
        //Human h = new Student(); (Good)
        //Student s = new Student(); (Not Good)
        //1.5 이전
        List box = new ArrayList();
        box.add(honux);
        box.add(cocoas[0]);
        box.add(cocoas[3]);
        box.add("hello");

        System.out.println("\n----x-----x---------\n");

        for(int i = 0; i < box.size(); i++) {
            if (i == box.size() - 1) {
                String  s = (String) box.get(i);
                System.out.println(s);
            } else {
                Human h = (Human) box.get(i);
                System.out.println(h);
            }
        }

        //1.5 이후 제네릭스 등장!
        List<Human> room = new ArrayList<>();
        room.add(honux);
        room.add(cocoas[3]);
        room.add(cocoas[2]);
        for (Human h: room) {
            System.out.println(h);
        }





    }
}
