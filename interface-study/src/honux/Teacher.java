package honux;

public class Teacher extends Human implements Runner{
    public Teacher(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void sayHi(String s, Human other) {
        System.out.printf("숙제했니?" + other.getName());
    }

    @Override
    public void move() {
        System.out.println("에고 힘들어!");
    }

    @Override
    public double getPower() {
        return 50;
    }
}
