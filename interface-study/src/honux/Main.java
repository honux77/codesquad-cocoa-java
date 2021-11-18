package honux;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Student h = new Student("쏘니", 55);
        Animal c = new Animal("고양이", 5);
        Human h2 = new Teacher("호눅스", 22);

        Food f = new Food("참치캔", 100);

        run(c, f);
        run(h, f);
        //run(h2, f); error


    }

    public static void run(Eatable e, Food f) {
        e.eat(f);
    }
}
