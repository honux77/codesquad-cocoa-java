package net.honux;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private static Player player;
    private static List<Monster> monsters;
    private static final String MONS_NAME = "몬스 ";
    private static final int NUM_MONS = 3;
    private static Scanner s;
    private static String cmd;
    private static boolean isRunning;
    private static int turn = 0;

    public static void init() {
        s = new Scanner(System.in);
        initPlayer();
        initMonster(NUM_MONS);
    }

    public static void end() {
        s.close();
    }

    private static void initMonster(int numMonster) {
        monsters = new ArrayList<>();
        for(int i = 0; i < numMonster; i++) {
            monsters.add(new Monster(MONS_NAME + i));
        }
    }

    public static void start() {
        System.out.println("게임을 시작하지!");
        display();

        isRunning = true;
        while(isRunning) {
            turn++;
            runCommnad();
            allDead();
            display();
        }
        System.out.println("Thanks for playing..");
        end();
    }

    private static boolean allDead() {
        boolean allDead = false;
        for (Monster m: monsters) {
            if (!m.isDead()) return false;
        }
        System.out.println("모든 몬스터가 죽었습니다! ");
        isRunning = false;
        return true;
    }

    private static void display() {
        System.out.println("턴 " + turn);
        System.out.println(player);
        System.out.println("-----------------");
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println(monsters.get(i));
        }
    }

    private static void runCommnad() {
        System.out.println("명령을 입력해 주세요.");
        System.out.println("(A): 공격 (E): 종료 ");
        cmd = s.next().toUpperCase();

        switch(cmd) {
            case "A":
                attackMonster();
                break;
            case "E":
                isRunning = false;
            default:
                System.out.println("명령어를 잘못 입력하셨습니다.");
        }
    }

    private static void attackMonster() {
        System.out.printf("몇 번 몬스터를 공격하시겠습니까? (1 - %d)\n", monsters.size());
        int choice = s.nextInt() - 1;
        Monster m = monsters.get(choice);
        player.attack(m);
    }

    private static void initPlayer() {
        System.out.println("이름은?");
        String name = s.next();
        player = new Player(name);
    }
}
