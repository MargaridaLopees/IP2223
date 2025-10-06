// authors: Margarida Lopes (64557) and Bernardo Gracioso (65284)
// Contains the information about the players.

public class Player {

	public static final int NOT_ELIM = 0;
	private static final int REMOVE_FINE = 1;
	public static final int DEFAULT_FINE = 0;

	private String name;
	private int order;
	private int square;
	private int gamesWon;
	private int fine;
	private int elim;
	private boolean firstPlay;

	// An object Player is created with the name given (color of the piece) and the
	// order of the play; starts in the position 1 of the board (index 0 of the
	// array); each player starts with no fine, zero games won, without being
	// eliminated (NOT_ELIM) and starts every game in the first play (firstPlay =
	// true).
	// pre: name != null && order >= 0
	public Player(String name, int order) {
		this.name = name;
		this.order = order;
		square = 0;
		gamesWon = 0;
		fine = 0;
		elim = NOT_ELIM;
		firstPlay = true;
	}

	// Returns the name of the player (color of the piece).
	public String getName() {
		return name;
	}

	// Returns the order of the play.
	public int getOrder() {
		return order;
	}

	// Returns the array position of the player.
	public int getSquareIdx() {
		return square;
	}

	// Returns the board position of the player.
	public int getPosition() {
		return square + 1;
	}

	// Returns the number of games won by the player.
	public int getGamesWon() {
		return gamesWon;
	}

	// Returns the penalty value of the player.
	public int getFine() {
		return fine;
	}

	// Returns the number elimination value of the player
	// (if elim = 0, the player is still in the game).
	public int getElim() {
		return elim;
	}

	// Returns "true" if the player is eliminated.
	public boolean isElim() {
		return (elim != NOT_ELIM);
	}

	// Returns "true" if it is the first play of the player in a specific game.
	public boolean isFirstPlay() {
		return firstPlay;
	}

	// Compares an object Player with another in ascending order of elimination, in
	// case of a tie, compares in descending order of games won, in case of a tie,
	// in descending order of the position of the player, and in case of a tie, in
	// ascending order of the play.
	// pre: other != null
	public int compareTo(Player other) {
		if (elim < other.getElim())
			return 1;
		if (elim > other.getElim())
			return -1;
		if (gamesWon < other.getGamesWon())
			return -1;
		if (gamesWon > other.getGamesWon())
			return 1;
		if (square < other.getSquareIdx())
			return -1;
		if (square > other.getSquareIdx())
			return 1;
		if (order < other.getOrder())
			return 1;
		if (order > other.getOrder())
			return -1;
		return 0;
	}

	// Compares an object Player with another in ascending order of elimination, in
	// case of a tie, in ascending order of the position of the player, in case of a
	// tie, in descending order of the play.
	// pre: other != null
	public int compareToElim(Player other) {
		if (elim < other.getElim())
			return 1;
		if (elim > other.getElim())
			return -1;
		if (square < other.getSquareIdx())
			return 1;
		if (square > other.getSquareIdx())
			return -1;
		if (order < other.getOrder())
			return -1;
		if (order > other.getOrder())
			return 1;
		return 0;
	}

	// Updates the array position of the player.
	// pre: idxSquare >= 0
	public void setSquare(int idxSquare) {
		square = idxSquare;
	}

	// Increase the value of games won by one unit.
	public void increaseGamesWon() {
		gamesWon++;
	}

	// Applies the value of a given fine to the player.
	// pre: fine == 0 && value >= 1 && value <= 4
	public void setFine(int value) {
		fine = value;
	}

	// Decreases the penalty value of the player by one unit.
	// pre: fine > 0
	public void decreaseFine() {
		fine -= REMOVE_FINE;
	}

	// Eliminates the player from a certain game.
	// pre: elim == 0 && currentGame >= 1 && currentGame < pLen (players.length)
	public void setElim(int currentGame, int pLen) {
		elim = pLen - currentGame;
	}

	// Updates the veracity of the first play in a certain game.
	public void setFirstPlay(boolean fstPlay) {
		firstPlay = fstPlay;
	}
}
