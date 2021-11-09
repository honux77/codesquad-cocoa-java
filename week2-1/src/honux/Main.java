package honux;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//코코아 학생 아무나 뽑기
public class Main {
    public static List<String> createList() {
        List cocoaList = new ArrayList<>();
        cocoaList.add("얀");
        cocoaList.add("땃쥐");
        cocoaList.add("준");
        cocoaList.add("필");
        cocoaList.add("호눅스");
        cocoaList.add("몽");
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
    public static void main(String[] args) {
        final int n = 3;
        //학생 리스트(배열)을 만들고
        List<String> cocoaList = createList();
        //잘 섞어서
        shuffle(cocoaList);
        //그 중에 n 명을 뽑는다.
        printN(cocoaList, n);
    }
}
