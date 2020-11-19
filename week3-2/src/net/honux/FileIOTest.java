package net.honux;

import java.io.File;
import java.io.FileInputStream;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileIOTest {

    //가장 쉬운 방법: 스캐너 사용하기
    //원하는 단위만큼 읽을 수 있다.
    //대신 성능이 좋지 않다.
    public static void readFileWithScanner(String src) throws IOException {
        System.out.println("=== 스캐너를 사용한 읽기 테스트 ===");
        File f = new File(src);
        Scanner s = new Scanner(f);
        int count = 0;
        while(s.hasNext()) {
            count++;
            System.out.println(s.nextLine());
        }
        s.close();
    }

    //캐릭터 스트림은 글자 단위로 읽는다.
    public static void readFileWithFileReader(String src) throws IOException {
        System.out.println("FileReader로 읽기: 캐릭터 스트림 방식");
        File f = new File(src);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        int c;
        int count = 0;
        while((c = br.read()) != -1) {
            count++;
            System.out.print((char)c);
        }

        System.out.println("완료: " + count);
        br.close();
    }

    public static void generateBigFile(String fname, int size) throws IOException {
        File f = new File(fname);
        FileOutputStream fos = new FileOutputStream(f);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte b = 0;

        for (int i = 0; i < size; i++) {
            bos.write(b);
        }

        //주의!close를 안 할 경우 기대한 것보다 파일 크기가 작다.
        bos.close();
        System.out.println("파일 생성 완료. 파일 크기를 확인해 보자.");
    }


    public static void copyFileWithBuffer(String src) throws IOException{
        System.out.println("간단 파일 복사에 버퍼 적용: 메소드 호출 회수가 줄어듭니다.");

        File f = new File(src);
        File f2 = new File("copy_buffer.txt");

        byte[] buf = new byte[16];

        FileInputStream is = new FileInputStream(f);
        FileOutputStream os = new FileOutputStream(f2);
        int count = 0;
        int n;
        while ((n = is.read(buf)) != -1) {
            count++;
            System.out.println(n);
            for (var b: buf) System.out.print((char) b);
        }
        System.out.println("끝: " + count);
        is.close();
    }
    public static void copyFile(String src) throws IOException {
        System.out.println("간단 파일 복사: 화면은 깨져도 내용은 잘 들어갑니다.");
        File f = new File(src);
        File f2 = new File("copy.txt");

        FileInputStream is = new FileInputStream(f);
        FileOutputStream os = new FileOutputStream(f2);

        int c;
        int count = 0;
        while ((c = is.read()) != -1) {
            count++;
            System.out.print((char) c);
            os.write(c);
        }
        System.out.println("끝: " + count);
        is.close();
    }
    public static void main(String[] args) throws IOException {
        String src = "./resources/hello.txt";
        copyFile(src);
        copyFileWithBuffer(src);
        generateBigFile("big.txt", 1024);
        readFileWithFileReader(src);
        readFileWithScanner(src);

    }


}
