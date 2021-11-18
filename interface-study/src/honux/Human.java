package honux;

public abstract class Human
{
    private String name;
    private double weight;

    public Human(String name, double weight) {
        this.name = name;
        this.weight = weight;
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
        h.sayHi("안녕~~~", h);
        System.out.println(h);
    }
}
