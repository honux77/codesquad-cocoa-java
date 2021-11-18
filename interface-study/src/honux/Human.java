package honux;

public abstract  class Human {
    private String name;
    private double weight;

    public Human(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void eat(Food f) {
        System.out.printf("%s(은)는 %s를 먹습니다. 냠냠\n", this.name, f.getName());
        weight += f.getCal() / 8000;
    }

    public String getName() {
        return name;
    }

    public abstract void sayHi(String s, Human other);

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        Human h = new Human("호눅스", 66) {
            @Override
            public void sayHi(String s, Human other) {
                System.out.println(s + " " + other.getName());
            }
        };
        h.eat(new Food("삼계탕", 1000));
        h.sayHi("안녕~~~", h);
        System.out.println(h);
    }
}
