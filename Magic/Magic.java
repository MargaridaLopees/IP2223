
public class Magic {

	private char[] suits;
	private int jump;

	public Magic(String suitsString, int jump) {
		suits = suitsString.toCharArray();
		this.jump = jump;
	}

	private int getSuitNumb(char n) {
		for (int i = 0; i < suits.length; i++) {
			if (suits[i] == n) {
				return i;
			}
		}
		return -1;
	}

	public char getNextSuit(char n) {
		int prev = getSuitNumb(n);
		int next;
		if ((prev - 1) < 0) {
			next = suits.length + (prev - 1);
		} else {
			next = ((prev - 1) % suits.length);
		}

		return suits[next];
	}

	public int getNumber(int card) {
		int n = (card - jump);
		int prevCard;
		if (n <= 0) {
			prevCard = 13 + n;
		} else {
			prevCard = (n % 13);
		}
		return prevCard;
	}
}
