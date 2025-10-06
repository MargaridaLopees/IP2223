
public class Tickets {

	int[] ticketsAsked;

	public Tickets(int size) {
		ticketsAsked = new int[size];
	}

	public void addNumberTickets(int numberTickets, int i) {
		ticketsAsked[i] = numberTickets;
	}

	public int[] ticketsDistribution(int friends, int tickets) {
		averageTickets(friends, tickets);
		int friendsLeft = friends;
		int ticketsLeft = tickets;
		while ((ticketsLeft >= friendsLeft) || (ticketsLeft != 0)) {
			ticketsLeft = tickets - usedTickets(friends, tickets, ticketsAsked);
			friendsLeft = sumFriendsLeft(friends, tickets, ticketsAsked);
		}
		ticketsAsked = cicleTickets(friends, tickets);
		return ticketsAsked;

	}

	public int averageTickets(int friends, int tickets) {
		return (tickets / friends);
	}

	public int[] cicleTickets(int friends, int tickets) {
		averageTickets(friends, tickets);
		int[] finalTicket = new int[ticketsAsked.length];
		for (int i = 0; i < ticketsAsked.length; i++) {
			if (ticketsAsked[i] > averageTickets(friends, tickets)) {
				finalTicket[i] = ticketsAsked[i] - averageTickets(friends, tickets);
			} else {
				finalTicket[i] = ticketsAsked[i];
			}
		}
		return finalTicket;
	}

	public int usedTickets(int friends, int tickets, int[] ticketsAsked) {
		averageTickets(friends, tickets);
		int sum = 0;
		for (int i = 0; i < ticketsAsked.length; i++) {
			if (ticketsAsked[i] <= averageTickets(friends, tickets))
				;
			sum = sum + (ticketsAsked[i]);
		}
		return sum;
	}

	public int sumFriendsLeft(int friends, int tickets, int[] ticketsAsked) {
		averageTickets(friends, tickets);
		int sum = 0;
		for (int i = 0; i < ticketsAsked.length; i++) {
			if (ticketsAsked[i] > averageTickets(friends, tickets))
			
			sum = sum + 1;
		}
		return sum;
	}

}
