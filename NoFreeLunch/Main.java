import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int f = in.nextInt();
		in.nextLine();
		int n = in.nextInt();
		in.nextLine();

		int winner = 0;
		for (int i = 0; i < n; i++) {
			int e = in.nextInt();
			if ((e > winner) && (e <= f)) {
				winner = e;
			}

			in.nextLine();
		}

		winnerPrint(winner);

		in.close();

	}

	private static void winnerPrint(int a) {
		if (a == 0) {
			System.out.println("No free lunch");
		} else {
			System.out.println(a);
		}
	}

}
