import java.util.Scanner;

public class Main {

	private static final String SYSOUT = "%d";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String suitsString = in.next();
		in.nextLine();
		int jump = in.nextInt();
		Magic magic = new Magic(suitsString, jump);
		in.nextLine();

		String card = in.nextLine();
		while (card.charAt(0) != '0') {
			executePrevCard(card, magic);
			card = in.nextLine();
		}

		in.close();
	}

	private static void executePrevCard(String card, Magic magic) {
		String option[] = card.split(" ");
		int num = Integer.parseInt(option[0]);
		char c = option[1].charAt(0);
		char suit = magic.getNextSuit(c);
		int s = magic.getNumber(num);
		System.out.println(String.format(SYSOUT, s) + " " + suit);
	}
}
