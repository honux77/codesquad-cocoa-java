package honux;

import java.io.File;
import java.util.*;

//코코아 학생 아무나 뽑기
public class Main {
    public static List<String> createList() {
        List cocoaList = new ArrayList<>();
        return cocoaList;
    }

    public static void shuffle(List<String> s) {
        Collections.shuffle(s);
    }

    public static void printN(List<String>s, int n) {
     for (int i = 0; i < n; i++) {
         System.out.println(s.get(i));
     }
    }

    public static int input(int m) {
        Scanner s = new Scanner(System.in);
        System.out.print("몇 명 뽑을까요? (1 - " + m + " )");
        int n = s.nextInt();
        s.close();
        return n;
    }

    public static boolean fileTest() {
        File f = new File("./user.csv");
        return f.exists();
    }

    public static void main(String[] args) {
        //System.out.println(fileTest());

        //학생 리스트(배열)을 만들고
        List<String> cocoaList = createList();

        //키보드로 입력을 받는다.
        final int n = input(cocoaList.size());

        //잘 섞어서
        shuffle(cocoaList);

        //그 중에 n 명을 뽑는다.
        printN(cocoaList, n);
    }
}
