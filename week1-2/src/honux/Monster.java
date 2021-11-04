package honux;

public class Monster {
    public String name;
    public int age;
    public double weight;

    public Monster(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void eat(String food, double w) {
        System.out.println(this.name + "이 " +  food + "를 먹습니다. 냠남");
        this.weight += w;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
