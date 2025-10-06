
public class Book {

	int[] book;

	public Book(String book) {
		this.book = convertCharArrayToInt(book.toCharArray());
	}

	private int[] convertCharArrayToInt(char[] bookChar) {
		int[] tempBook = new int[bookChar.length];
		for (int i = 0; i < bookChar.length; i++) {
			tempBook[i] = Character.getNumericValue(bookChar[i]);
		}
		return tempBook;
	}

	private int division() {
		int sum = 0;
		for (int i = 0; i < book.length - 1; i++) {
			int a = 0;
			if ((i + 1) % 2 == 0) {
				a = book[i] * 3;
			} else {
				a = book[i];
			}

			sum = sum + a;
		}
		return sum;
	}

	private int controlDigit(int sum) {
		return (10 - (sum % 10));
	}

	public int getControlDigit() {
		int controlDigit = controlDigit(division());
		if (controlDigit == 10) {
			return 0;
		} else {
			return controlDigit;
		}
	}

	public boolean isValidControlDigit() {
		return (getControlDigit() == book[(book.length - 1)]);
	}
}
