import java.util.Scanner;

public class Main {


	private static int processUberX(Uber n, int s, int t, int d) {
		return n.uberX(t, d);
	}

	private static int processUberXL(Uber n, int s, int t, int d) {
		return n.uberXL(t, d);
	}


		
	
	private static void executeOption(Scanner in, int S, int T, int D) {

		switch (S) {
		case 1:	
			System.out.println(processUberX(new Uber(S,T,D), S, T, D));
			break;

		case 2:
			System.out.println(processUberXL(new Uber(S,T,D), S, T, D));
			break;
			
		default:
			return;
			
		}
	}

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int S = in.nextInt();
		int T = in.nextInt();
		int D = in.nextInt();
	

		executeOption(in, S, T, D);

		in.close();

	}

}
