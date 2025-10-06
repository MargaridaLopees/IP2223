import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int fotos = in.nextInt();
		Girassol girassol = new Girassol();
		in.nextLine();
		for (int i = 0; i < fotos; i++) {
			int first = in.nextInt();
			int second = in.nextInt();
			in.nextLine();
			executeValues(first, second, girassol);
		}
		in.close();

	}

	private static void executeValues(int a, int b, Girassol girassol) {
		if (girassol.validValues(a, b) == -1) {
			System.out.println("FAKE");
		} else if (girassol.validValues(a, b) == -2) {
			System.out.println("OK");
		}
	}

}
