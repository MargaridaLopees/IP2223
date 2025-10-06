// authors: Margarida Lopes (64557) and Bernardo Gracioso (65284)
// Responsible for cup management; is the system of our program. 

import java.io.*;
import java.util.Scanner;

public class Cup {

	private static final String FILE_NAME = "boards.txt";
	private static final int COLS = 2;
	private static final String DEATH = "death";
	private static final String CRAB = "crab";
	private static final String HELL = "hell";
	private static final int NOT_FOUND = -1;
	private static final int WD_MIN = 3;
	private static final int WD_MAX = 6;

	private Player[] players;
	private Board game;
	private int currentGame;
	private boolean hasDied;
	private int now;

	// An object Cup is created, determining the cup players and selecting the game
	// board (from a certain file). The Cup starts in the first game (currentGame)
	// and with the squares DEATH yet to use; the first player rolling the dice
	// is the one with index 0 (now = 0).
	// pre: names != null && names.length() >= 3 && names.length() <= 10 &&
	// names.equals(names.toUpperCase()) && names.charAt(i) != names.charAt(i+1),
	// with i belonging to [0, names.length()-1[ && nBoard > 0
	public Cup(String names, int nBoard) throws FileNotFoundException {
		players = new Player[names.length()];
		for (int i = 0; i < names.length(); i++)
			players[i] = new Player(Character.toString(names.charAt(i)), i);
		game = createGame(nBoard);
		currentGame = 1;
		hasDied = false;
		now = 0;
	}

	// Returns the given game board.
	// pre: nBoard > 0
	private static Board createGame(int nBoard) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(FILE_NAME));
		int count = 0;
		int nSquares = 0;
		int[][] fine, cliff = null;
		do {
			nSquares = getIntValue(in);
			fine = createFine(in);
			cliff = createCliff(in);
			count++;
		} while (count < nBoard);
		in.close();
		return new Board(nSquares, fine, cliff);
	}

	// Returns an int value, changing line.
	// pre: in != null
	private static int getIntValue(Scanner in) {
		int res = in.nextInt();
		in.nextLine();
		return res;
	}

	// Returns a matrix of int values, with the values of the FINE squares and
	// respective penalties.
	// pre: in != null
	private static int[][] createFine(Scanner in) {
		int nFines = getIntValue(in);
		int[][] fine = new int[nFines][COLS];
		for (int i = 0; i < nFines; i++) {
			for (int j = 0; j < COLS; j++)
				fine[i][j] = in.nextInt();
			in.nextLine();
		}
		return fine;
	}

	// Returns a matrix of int values, with the values of the CLIFF squares and
	// respective types (int values).
	// pre: in != null
	private static int[][] createCliff(Scanner in) {
		int nCliffs = getIntValue(in);
		int[][] cliff = new int[nCliffs][COLS];
		for (int i = 0; i < nCliffs; i++) {
			cliff[i][0] = in.nextInt();
			cliff[i][1] = convertType(in);
			in.nextLine();
		}
		return cliff;
	}

	// Converts the type of the square CLIFF (String) to an int value.
	// pre: in != null &&
	// type.equals(DEATH) || type.equals(CRAB) || type.equals(HELL)
	private static int convertType(Scanner in) {
		String type = in.next();
		if (type.equals(DEATH))
			return Board.DEATH;
		if (type.equals(CRAB))
			return Board.CRAB;
		if (type.equals(HELL))
			return Board.HELL;
		return 0;
	}

	// Returns a copy of the original array of players.
	private Player[] copyArray() {
		Player[] aux = new Player[players.length];
		for (int i = 0; i < players.length; i++)
			aux[i] = players[i];
		return aux;
	}

	// Returns an iterator of the sorted array.
	public Iterator sortedIterator() {
		Player[] aux = copyArray();
		sort(aux);
		return new Iterator(aux);
	}

	// Sorts the array given by descending order of the compareTo method (from the
	// Class Player).
	// pre: aux != null
	private void sort(Player[] aux) {
		for (int i = 0; i < players.length - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < players.length; j++)
				if (aux[j].compareTo(aux[maxIdx]) > 0)
					maxIdx = j;
			Player tmp = aux[i];
			aux[i] = aux[maxIdx];
			aux[maxIdx] = tmp;
		}
	}

	// Returns the index of the winner player of a certain game.
	private int getGameWinnerIdx() {
		int i = 0;
		while (i < players.length && players[i].getSquareIdx() != game.getWinnerSquareIdx())
			i++;
		if (i < players.length)
			return i;
		else
			return NOT_FOUND;
	}

	// Returns "true" the cup is over.
	public boolean isCupOver() {
		return currentGame == (players.length - 1) && (hasGameWinner() || hasDied);
	}

	// Returns "true" if some player is on the last square of the board.
	private boolean hasGameWinner() {
		return getGameWinnerIdx() != NOT_FOUND;
	}

	// Returns the name of the winner player.
	// pre: this.isCupOver() && !players[i].isElim(),
	// with i belonging to [0, players.length[
	public String getCupWinnerName() {
		return players[getCupWinnerIdx()].getName();
	}

	// Returns the index of the winner player of the cup.
	// pre: this.isCupOver() && !players[i].isElim(),
	// with i belonging to [0, players.length[
	private int getCupWinnerIdx() {
		int i = 0;
		while (players[i].getElim() != Player.NOT_ELIM)
			i++;
		return i;
	}

	// Returns the next player that can roll the dice.
	// pre: !this.isCupOver()
	public String getNextToPlay() {
		return players[now].getName();
	}

	// Returns the index value of a given player name.
	// pre: name != null
	private int getIdxName(String name) {
		int i = 0;
		while (i < players.length && !players[i].getName().equals(name))
			i++;
		if (i < players.length)
			return i;
		else
			return NOT_FOUND;
	}

	// Returns "true" if the given player name exists.
	// pre: name != null
	public boolean isNameValid(String name) {
		return getIdxName(name) != NOT_FOUND;
	}

	// Returns "true" if the given player is eliminated.
	// pre: name != null && this.isNameValid(name)
	public boolean isElim(String name) {
		return players[getIdxName(name)].isElim();
	}

	// Returns the position of a given player in the board.
	// pre: name != null && this.isNameValid(name) && !this.isElim(name)
	public int getPosition(String name) {
		return players[getIdxName(name)].getPosition();
	}

	// Returns "true" if the given player can roll the dice (if the player has no
	// fine).
	// pre: name != null && this.isNameValid(name) && !this.isCupOver() &&
	// !this.isElim(name)
	public boolean canRollDice(String name) {
		return players[getIdxName(name)].getFine() == Player.DEFAULT_FINE;
	}

	// Updates the player index position in the board.
	// pre: p1 >= 1 && p1 <= 6 && p2 >= 1 && p2 <= 6 && !this.isCupOver();
	private void movePlayer(int p1, int p2) {
		if (players[now].isFirstPlay() && winnerDice(p1, p2))
			players[now].setSquare(game.getWinnerSquareIdx());
		else {
			int pPosition = players[now].getSquareIdx() + p1 + p2;
			if (pPosition > game.getWinnerSquareIdx())
				pPosition = game.getWinnerSquareIdx();
			players[now].setSquare(pPosition);
		}
		players[now].setFirstPlay(false);
	}

	// Returns "true" if the dice combination is 3 6 or 6 3.
	// pre: p1 >= 1 && p1 <= 6 && p2 >= 1 && p2 <= 6
	private boolean winnerDice(int p1, int p2) {
		return (p1 == WD_MIN && p2 == WD_MAX) || (p1 == WD_MAX && p2 == WD_MIN);
	}

	// Verifies the square type where the player is after rolling the dices and
	// applies the function of the square.
	// pre: p1 >= 1 && p1 <= 6 && p2 >= 1 && p2 <= 6 && !this.isCupOver();
	private void applySquare(int p1, int p2) {
		int square = game.getSquareTypeIdx(players[now].getSquareIdx());
		switch (square) {
		case Board.GEESE:
			processGeese();
			break;
		case Board.DEATH:
			processDeath();
			break;
		case Board.CRAB:
			processCrab(p1, p2);
			break;
		case Board.HELL:
			processHell();
			break;
		case Board.FINE:
			processFine();
			break;
		}
	}

	// Square GEESE: if possible, adds nine squares to the player index position.
	private void processGeese() {
		int pPosition = players[now].getSquareIdx() + Board.GEESE_FWD;
		if (pPosition > game.getWinnerSquareIdx())
			pPosition = game.getWinnerSquareIdx();
		players[now].setSquare(pPosition);
	}

	// Square DEATH: eliminates the player if any of the square types DEATH have
	// not been used yet.
	private void processDeath() {
		if (!hasDied) {
			players[now].setElim(currentGame, players.length);
			hasDied = true;
		}
	}

	// Square CRAB: remove two times the dices value from the index position of the
	// player, if possible.
	// pre: p1 >= 1 && p1 <= 6 && p2 >= 1 && p2 <= 6
	private void processCrab(int p1, int p2) {
		int pPosition = players[now].getSquareIdx() - 2 * (p1 + p2);
		if (pPosition < 0)
			pPosition = 0;
		players[now].setSquare(pPosition);
	}

	// Square HELL: sets the player index position to the first square (index = 0).
	private void processHell() {
		players[now].setSquare(0);
	}

	// Square FINE: applies the fine value of a certain square to the player.
	private void processFine() {
		players[now].setFine(game.getFineValue(players[now].getSquareIdx()));
	}

	// Processes what happens after a player moves in the board and after being
	// applied a certain square, taking into account the status of the cup in that
	// moment.
	private void next() {
		if (hasGameWinner())
			nextGame();
		else if (currentGame != players.length - 1 || (currentGame == players.length - 1 && !hasDied))
			searchNextToPlay();
		else
			players[getCupWinnerIdx()].increaseGamesWon();
	}

	// Searches the next player that can roll the dice. Sets the value of now (next
	// player) with the index of the next player.
	// pre: !hasGameWinner()
	private void searchNextToPlay() {
		int i = (now + 1) % players.length;
		while (players[i].isElim() || players[i].getFine() > Player.DEFAULT_FINE) {
			if (!players[i].isElim() && players[i].getFine() > Player.DEFAULT_FINE)
				players[i].decreaseFine();
			i = (i + 1) % players.length;
		}
		now = i;
	}

	// Ends a certain game; determines the winner and verifies if can eliminate a
	// player and restart the board.
	// pre: hasGameWinner()
	private void nextGame() {
		if (!hasDied) {
			Player[] aux = copyArray();
			sortElim(aux);
			aux[0].setElim(currentGame, players.length);
		}
		players[getGameWinnerIdx()].increaseGamesWon();
		if (currentGame != players.length - 1)
			resetGame();
	}

	// Resets the board so a new game can start.
	// pre: currentGame != players.length - 1
	private void resetGame() {
		hasDied = false;
		currentGame++;
		resetFines();
		resetNow();
		resetFirstPlays();
		resetPositions();
	}

	// Resets all the players fines to 0 (DEFAULT_FINE).
	// pre: currentGame != players.length - 1
	private void resetFines() {
		for (int i = 0; i < players.length; i++) {
			if (!players[i].isElim())
				players[i].setFine(Player.DEFAULT_FINE);
		}
	}

	// Resets the value of now (the first player thats is not eliminated).
	// pre: !players[i].isElim(), with i belonging to [0, players.length[ &&
	// currentGame != players.length - 1
	private void resetNow() {
		int i = 0;
		while (players[i].isElim())
			i++;
		now = i;
	}

	// Resets the veracity of the first play.
	// currentGame != players.length - 1
	private void resetFirstPlays() {
		for (int i = 0; i < players.length; i++) {
			if (!players[i].isElim())
				players[i].setFirstPlay(true);
		}
	}

	// Resets the index positions of the players that will play in the next game.
	// pre: currentGame != players.length - 1
	private void resetPositions() {
		for (int i = 0; i < players.length; i++) {
			if (!players[i].isElim())
				players[i].setSquare(0);
		}
	}

	// Sorts the array given by descending order of the compareToElim method (from
	// the Class Player).
	// pre: aux != null
	private void sortElim(Player[] aux) {
		for (int i = 0; i < players.length - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < players.length; j++)
				if (aux[j].compareToElim(aux[maxIdx]) > 0)
					maxIdx = j;
			Player tmp = aux[i];
			aux[i] = aux[maxIdx];
			aux[maxIdx] = tmp;
		}
	}

	// Processes the play of a certain player.
	// pre: p1 >= 1 && p1 <= 6 && p2 >= 1 && p2 <= 6 && !isCupOver()
	public void rollDice(int p1, int p2) {
		movePlayer(p1, p2);
		applySquare(p1, p2);
		next();
	}
}
