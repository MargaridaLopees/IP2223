// authors: Margarida Lopes (64557) and Bernardo Gracioso (65284)
// Class responsible for the cup board. 

public class Board {

	public static final int NORMAL = 0;
	public static final int GEESE = 1;
	public static final int DEATH = 2;
	public static final int CRAB = 3;
	public static final int HELL = 4;
	public static final int FINE = 5;
	public static final int GEESE_FWD = 9;
	private static final int MULTIPLE = 9;

	private int nSquares;
	private Square[] squares;

	// An object Board is created with size = nSquares; every positions are
	// initially filled with squares of the type NORMAL; then the other square
	// types, GEESE, CLIFF (CRAB, DEATH AND HELL) and FINE are placed.
	// pre: nSquares >= 10 && nSquares <= 150 && fine != null && cliff != null &&
	// fine.length >= 1 && fine.length <= (1/3)nSquares && cliff.length >= 1 &&
	// cliff.length <= (1/3)nSquares && fine[i][0] < fine[i+1][0],
	// with i belonging to [0, fine.lenght-1[ && fine[i][1] >= 1 && fine[i][1] <= 4,
	// with i belonging to [0, fine.length[ && cliff[j][1] >= 2 && cliff[j][1] <= 4,
	// with j belonging to [0, cliff.length[ && cliff[j][0] < cliff[j+1][0],
	// with j belonging to [0, cliff.length-1[ && fine[i][0] != cliff[j][0] &&
	// fine[i][0] >= 2 && fine[i][0] <= nSquares-1 && cliff[j][0] >= 2 &&
	// cliff[j][0] <= nSquares-1 && fine[i][0] != 9k && cliff[j][0] != 9k,
	// with i belonging to [0,fine.length[, j belonging to [0, cliff.length[ and k
	// natural
	public Board(int nSquares, int[][] fine, int[][] cliff) {
		this.nSquares = nSquares;
		squares = new Square[nSquares];
		for (int i = 0; i < nSquares; i++)
			squares[i] = new Square(NORMAL);
		int idx = 8;
		while (idx < nSquares - 1) {
			squares[idx] = new Square(GEESE);
			idx += MULTIPLE;
		}
		for (int i = 0; i < cliff.length; i++)
			squares[cliff[i][0] - 1] = new Square(cliff[i][1]);
		for (int i = 0; i < fine.length; i++)
			squares[fine[i][0] - 1] = new Square(FINE, fine[i][1]);
	}

	// Returns the index of the last square.
	public int getWinnerSquareIdx() {
		return nSquares - 1;
	}

	// Returns the asked square type.
	// pre: squareIdx >= 0 && squareIdx < squares.length
	public int getSquareTypeIdx(int squareIdx) {
		return squares[squareIdx].getType();
	}

	// Returns the fine value to apply of a given square.
	// pre: squareIdx >= 0 && squareIdx < squares.length &&
	// this.getSquareTypeIdx(squareIdx) == FINE
	public int getFineValue(int squareIdx) {
		return squares[squareIdx].getFineToApply();
	}

}
