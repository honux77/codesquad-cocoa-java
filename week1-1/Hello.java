public class Hello {

	public static void printGuguLine(int a, int b) {
		System.out.printf("%3d * %3d = %3d\n", a, b, a * b);
	}

	public static void printGugudan(int n) {
		for (int i = 1; i <= 9; i++) {
			printGuguLine(n, i);
		}
	}

	public static void main(String[] args) {
		printGugudan(5);
	}
}
