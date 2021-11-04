package net.honux;

public class Monster {

    private final static int START_HP = 30;
    private final static int EXP = 20;

    private int hp;
    private boolean isDead = false;
    private String name;


    public Monster(String name) {
        this.name = name;
        this.hp = START_HP;
        System.out.println(name + "몬스터 생성 완료");
    }


    /*
      죽으면 경험치를 리텀함
     */
    public int getDamaged(int power) {
        if (this.isDead) {
            System.out.println(this + "는 이미 죽었습니다.. 너무하네..");
            return -1;
        }

        this.hp -= power;
        if (this.hp <= 0) {
            isDead = true;
            return EXP;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "hp=" + hp +
                ", isDead=" + isDead +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isDead() {
        return isDead;
    }
}
