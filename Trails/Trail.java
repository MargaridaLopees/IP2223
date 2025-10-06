
public class Trail {

	private int[][] trail;
	private int rows;
	private int cols;
	private char[] finalTrail;
	private int sum;
	private int size = 0;

	private static final int DEFAULT = 5000;
	private static final char D = 'D';
	private static final char E = 'E';
	private static final char C = 'C';
	private static final char B = 'B';

	public Trail(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		trail = new int[rows][cols];
		finalTrail = new char[DEFAULT];
		sum = 0;
	}

	public int returnSum() {
		sum = ((trail[0][0]) * (size + 1));
		return sum;
	}

	public char[] returnFinalTrail() {
		return finalTrail;
	}

	public int retunrSize() {
		return size;
	}

	public void addToTrail(int row, int col, int value) {
		trail[row][col] = value;
	}

	private void addToFinalTrail(char a) {
		finalTrail[size] = a;
		size++;
	}

	private int[][] secondTrail() {
		int[][] secondTrail = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				secondTrail[i][j] = trail[i][j];
			}
		}
		return secondTrail;
	}

	public void trailTrack() {
		int[][] secondTrail = secondTrail();
		int value = secondTrail[0][0];
		int c = 0;
		int l = 0;
		while (true) {
			if ((c + 1) <= cols - 1 && secondTrail[l][c + 1] == value) {
				addToFinalTrail(D);
				secondTrail[l][c] = value - 1;
				c = (c + 1);
			} else if ((c - 1) >= 0 && secondTrail[l][c - 1] == value) {
				addToFinalTrail(E);
				secondTrail[l][c] = value - 1;
				c = c - 1;
			} else if ((l + 1) <= rows - 1 && secondTrail[l + 1][c] == value) {
				addToFinalTrail(B);
				secondTrail[l][c] = value - 1;
				l = (l + 1);
			} else if ((l - 1) >= 0 && secondTrail[l - 1][c] == value) {
				addToFinalTrail(C);
				secondTrail[l][c] = value - 1;
				l = (l - 1);
			} else {
				return;
			}
		}
	}

}
