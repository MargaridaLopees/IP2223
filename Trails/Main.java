
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int cols = in.nextInt();
		Trail trail = new Trail(rows, cols);
		in.nextLine();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int value = in.nextInt();
				trail.addToTrail(i, j, value);
			}
			in.nextLine();
		}
		in.close();
		trail.trailTrack();
		returnChar(trail);
		returnValue(trail);
	}

	private static void returnChar(Trail trail) {
		char[] c = trail.returnFinalTrail();
		int size = trail.retunrSize();
		for (int i = 0; i < size; i++) {
			System.out.print(c[i]);
		}
	}

	private static void returnValue(Trail trail) {
		int total = trail.returnSum();
		System.out.println();
		System.out.println(total);
	}

}
