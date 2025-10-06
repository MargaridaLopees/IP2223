// authors: Margarida Lopes (64557) and Bernardo Gracioso (65284)
// Contains the square information of the board.

public class Square {

	private int type;
	private int fine;

	// Crates an object Square of the type NORMAL, DEATH, CRAB, HELL and GEESE;
	// these types of squares don't have a defined value of penalty.
	// pre: type >= 0 && type < 5
	public Square(int type) {
		this.type = type;
		this.fine = 0;
	}

	// Creates an object Square of the type FINE.
	// pre: type = 5 && fine >= 1 && fine <= 4
	public Square(int type, int fine) {
		this.type = type;
		this.fine = fine;
	}

	// Returns the correspondent value of the type of the square.
	public int getType() {
		return type;
	}

	// Returns the value of the fine to apply, in case of the square equals to a
	// fine square.
	// pre: type = Board.FINE
	public int getFineToApply() {
		return fine;
	}

	// Changes the type of the square DEATH after being used.
	// pre: type = Board.DEATH
	public void setType() {
		type = Board.NORMAL;
	}

}
