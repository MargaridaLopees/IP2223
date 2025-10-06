import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int ticketsAvailable = in.nextInt();
		in.nextLine();
		int friends = in.nextInt();
		in.nextLine();

		Tickets tickets = new Tickets(friends);

		for (int i = 0; i < friends; i++) {
			int numberTickets = in.nextInt();
			tickets.addNumberTickets(numberTickets, i);
		}

		processTickets(tickets.ticketsDistribution(friends, ticketsAvailable));

		in.close();

	}

	private static void processTickets(int[] tickets) {
		int i = 0;
		for (i = 0; i < tickets.length; i++) {
			System.out.println(tickets[i]);
		}

	}

}
