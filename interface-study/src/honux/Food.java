package honux;

public class Food {
    private String name;
    private double cal;

    public Food(String name, double cal) {
        this.name = name;
        this.cal = cal;
    }

    public String getName() {
        return name;
    }

    public double getCal() {
        return cal;
    }
}
