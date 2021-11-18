package honux;

public class Teacher extends Human{
    public Teacher(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void sayHi(String s, Human other) {
        System.out.printf("숙제했니?" + other.getName());
    }
}
