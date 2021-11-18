package honux;

public class Student extends Human implements Eatable {

    public Student(String name, double weight) {
        super(name, weight);
    }

    @Override
    public void sayHi(String s, Human other) {
        System.out.println(s + "하3?" + other.getName());
    }

    public static void main(String[] args) {
        Human s1 = new Student("한세", 44 );
        Human s2 = new Student("피오", 20 );
        Human s3 = new Teacher("호눅스", 0.5);
        s1.sayHi("안녕", s2);
        s3.sayHi("좋은 아침입니다.", s1);
    }

    @Override
    public void eat(Food f) {
        System.out.println("냠냠 " + f.getName());
    }
}
