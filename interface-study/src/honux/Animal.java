package honux;

public class Animal implements Eatable, Runner {
    private String type;
    private double weight;

    public Animal(String type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public void eat(Food f) {
        this.weight = f.getCal() / 8000;
    }

    @Override
    public void move() {
        System.out.println("따각따각");
    }

    @Override
    public double getPower() {
        return 100;
    }
}
