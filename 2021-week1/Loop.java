public class Loop {
	
	public static void main(String[] args) {
	
		int j = 1;
		while (j < 10) {
			System.out.println("j = " + j);
			j++;
		}

		for (int i = 1; i < 10; i++) {
			if (i == 3) {
				continue;
			}
			System.out.println("i = " + i);
			if (i == 5) {
				break;
			}
		}
	}
}
