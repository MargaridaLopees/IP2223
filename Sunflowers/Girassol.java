
public class Girassol {

	private int[] fibonacci;
	private static final int DEFAULT = 30000;
	private static final int NOT_FOUND = -1;
	private static final int FOUND = -2;

	public Girassol() {
		fibonacci = new int[DEFAULT];
		createFibonacci();
	}

	private int[] createFibonacci() {
		for (int i = 0; i < fibonacci.length; i++) {
			if (i == 0) {
				fibonacci[i] = 0;
			} else if (i == 1) {
				fibonacci[i] = 1;
			} else {
				fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]);
			}
		}
		return fibonacci;
	}

	private int searchFirst(int a) {
		int i = 0;
		while (i < fibonacci.length && fibonacci[i] != a)
			i++;
		if (i < fibonacci.length) {
			return i;
		} else
			return NOT_FOUND;
	}

	public int validValues(int a, int b) {
		int index = searchFirst(a);
		if (index == NOT_FOUND) {
			return NOT_FOUND;
		} else if (fibonacci[index + 1] == b) {
			return FOUND;
		} else if (fibonacci[index - 1] == b) {
			return FOUND;
		} else if (index == 1 && b == 2) {
			return FOUND;
		} else {
			return NOT_FOUND;
		}
	}

}
