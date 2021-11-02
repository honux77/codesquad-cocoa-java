public class Method {
	public static void boo() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(i + ", " + j);
				if (i == 10) {
					return;
				}
			}
		}
	}
	public static int foo(int i) {
		return  i * 2;
	}
	public static void main(String[] args) {
		int x = foo(5);
		System.out.println(x);
		boo();
	}
}
