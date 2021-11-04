package honux;

public class Main {

    public static void testMonster() {
        Monster m = new Monster("David(TA)", 99, 63.0);
        System.out.println(m);
        m.eat("순대국", 0.2);
        System.out.println(m);
    }

    public static void testString() {
        int x = 3;
        x = 4;
        String a = "hello";
        System.out.println(a);
        a = "zello";
        System.out.println(a);
    }

    public static void mushroom(Monster m) {
        m.weight = m.weight * 2;
        System.out.println(m);
    }

    public static void main(String[] args) {

        //simple class and object
        //testMonster();

        //simple String test
        //testString();
        //slowStringTest();
        //stringBufferTest();

        //call by value test
        int x = 3;
        int y = myDouble(x);
        System.out.println(x);

        //reference variable
        Monster m = new Monster("Teemo", 5, 10);
        mushroom(m);
        System.out.println(m);

        //array test
        int[] a = new int[5];
        a[0] = 0;
        System.out.println(a[0]);
        boo(a);
        System.out.println(a[0]);
    }

    private static int myDouble(int n) {
        n = n * 2;
        System.out.println(n);
        return n;
    }

    public static void foo(int[] a) {
        a[0] = 100;
    }

    public static void boo(int[] a) {
        a = new int[3];
        a[0] = 100;
        System.out.println(a[0]);
    }

    private static void stringBufferTest() {
        StringBuffer sb = new StringBuffer("A");
        for (int i = 0; i < 1000000; i++) {
            sb.append("a");
        }
        System.out.println(sb.toString());
    }

    private static void slowStringTest() {
        String a = "A";
        for (int i = 0; i < 100000; i++) {
            a += "a";
        }
        a += "h!";
        System.out.println(a);
    }
}
