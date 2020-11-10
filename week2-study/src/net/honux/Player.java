package net.honux;

public class Player {

    private final static int START_HP = 100;
    private final static int START_POWER = 40;

    private String name;
    private int hp;
    private int exp;
    private int power;

    public Player(String name) {
        this.name = name;
        this.hp = START_HP;
        this.exp = 0;
        this.power = START_POWER;
        System.out.println("플레이어 " + this + "초기화 완료되었습니다.");
    }

    public void attack(Monster m) {
        System.out.println(m.getName() + "을 공격!");

        int exp = m.getDamaged(power);

        if (exp > 0) {
            this.exp += exp;
            System.out.println("오예 잡았습니다");
        } else if(exp == 0){
            System.out.println("효과는 미미합니다.");
        } else {
            System.out.println("어이쿠 효과가 전혀 없습니다.");
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", exp=" + exp +
                ", power=" + power +
                '}';
    }
}
