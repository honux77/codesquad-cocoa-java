package honux;

import java.util.ArrayList;
import java.util.List;

public class Wagon {
    private double power;
    private List<Runner> runners;

    public Wagon() {
        this.power = 0;
        this.runners = new ArrayList<>();
    }

    public void addRunner(Runner r) {
        this.power += r.getPower();
        this.runners.add(r);
    }

    public void move() {
        if (this.power >= 200) {
            System.out.println("씽씽!");
        } else {
            System.out.printf("드르륵!\n");
        }
        for(Runner r: this.runners) {
            r.move();
        }
    }

    public static void main(String[] args) {
        Wagon w = new Wagon();
        Student s = new Student("노리", 50);
        Animal a = new Animal("페가수스", 50);
        Teacher t = new Teacher("크롱", 100);
        w.addRunner(a);
        w.move();
        w.addRunner(t);
        w.move();
        w.addRunner(t);
        w.move();
    }

}
