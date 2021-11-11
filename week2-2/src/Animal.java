public class Animal {

    //클래스 공통 변수는 static
    //멤버 변수, 클래스 변수
    private static int numLegs;

    //멤버 변수, 인스턴스 변수
    private double weight;
    private String name;

    public Animal(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    //스태틱 메소드는 객체 없이 호출할 수 있다!
    public static void sayHi() {
        System.out.println("왈왈!");
        //클래스 변수도 사용할 수 있다!
        System.out.println("우리의 다리는 " + numLegs);
        //error: 인스턴스 변수는 사용할 수 없다!
       //System.out.println("너의 이름은 " + name);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //스태틱 변수는 객체를 생성하지 않아도 쓸 수 있다!
        Animal.numLegs = 4;
        System.out.println("동물의 다리는 세상이 생기기 전에도 " + Animal.numLegs);


        //지역변수는 자동으로 초기화가 되지 않기 때문에, 초기화하지 않고 사용하면 에러가 납니다!
        //int x;
        //System.out.println(x);

        System.out.println("태초에 태초마을 호눅스가 오박사를 만났다");
        Animal to = new Animal(100, "토끼");
        Animal.sayHi();
        Animal doy = new Animal(3000, "돼지");
        System.out.println(doy.numLegs);
    }
}
