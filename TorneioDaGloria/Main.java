// authors: Margarida Lopes (64557) and Bernardo Gracioso (65284)
// Responsible for the interaction with the user. 

import java.io.*;
import java.util.Scanner;

public class Main {

	private static final String PLAYER = "player";
	private static final String SQUARE = "square";
	private static final String STATUS = "status";
	private static final String RANKING = "ranking";
	private static final String DICE = "dice";
	private static final String EXIT = "exit";
	private static final int MIN_DICE = 1;
	private static final int MAX_DICE = 6;

	private static final String CUP_OVER = "The cup is over";
	private static final String CUP_NOT_OVER = "The cup was not over yet...";
	private static final String NEXT = "Next to play: %s\n";
	private static final String NONEXISTENT = "Nonexistent player";
	private static final String ELIMINATED = "Eliminated player";
	private static final String ON_SQUARE = "%s is on square %d\n";
	private static final String CAN_ROLL = "%s can roll the dice\n";
	private static final String CANNOT_ROLL = "%s cannot roll the dice\n";
	private static final String INVALID_DICE = "Invalid dice";
	private static final String RANK = "%s: %d games won; on square %d.\n";
	private static final String RANK_ELIM = "%s: %d games won; eliminated.\n";
	private static final String WINNER = "%s won the cup!\n";
	private static final String INVALID_COMMAND = "Invalid command";

	// Responsible for receive the inputs from the user and writes the results in
	// the console.
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		Cup cup = createCup(in);
		writeToConsole(in, cup);
		in.close();
	}

	// Returns an object Cup with the data given by the user.
	// pre: in != null
	private static Cup createCup(Scanner in) throws FileNotFoundException {
		String names = in.nextLine();
		int nBoard = getIntValue(in);
		return new Cup(names, nBoard);
	}

	// Returns an int value, changing line.
	// pre: in != null
	private static int getIntValue(Scanner in) {
		int res = in.nextInt();
		in.nextLine();
		return res;
	}

	// Reads the commands given by the user and writes the results in the console.
	// pre: in != null && cup != null
	private static void writeToConsole(Scanner in, Cup cup) {
		String option = null;
		do {
			option = in.next();
			executeOption(in, cup, option);
		} while (!option.equals(EXIT));
	}

	// Executes the command given by the user.
	// pre: in != null && cup != null
	private static void executeOption(Scanner in, Cup cup, String option) {
		switch (option) {
		case PLAYER:
			processPlayer(in, cup);
			break;
		case SQUARE:
			processSquare(in, cup);
			break;
		case STATUS:
			processStatus(in, cup);
			break;
		case RANKING:
			processRanking(in, cup);
			break;
		case DICE:
			processDice(in, cup);
			break;
		case EXIT:
			processExit(in, cup);
			break;
		default:
			processDefault(in);
		}
	}

	// Prints the next player to play if the cup is not over.
	// pre: in != null && cup != null
	private static void processPlayer(Scanner in, Cup cup) {
		if (cup.isCupOver())
			System.out.println(CUP_OVER);
		else
			System.out.printf(NEXT, cup.getNextToPlay());
		in.nextLine();
	}

	// Prints the position of the given player in the board if the player is valid
	// and is not eliminated.
	// pre: in != null && cup != null
	private static void processSquare(Scanner in, Cup cup) {
		String name = in.nextLine().trim();
		if (!cup.isNameValid(name))
			System.out.println(NONEXISTENT);
		else if (cup.isElim(name))
			System.out.println(ELIMINATED);
		else
			System.out.printf(ON_SQUARE, name, cup.getPosition(name));
	}

	// Prints the status of a given player (if the player can or cannot roll the
	// dices) if the player is valid, the cup is not over and the player is not
	// eliminated.
	// pre: in != null && cup != null
	private static void processStatus(Scanner in, Cup cup) {
		String name = in.nextLine().trim();
		if (!cup.isNameValid(name))
			System.out.println(NONEXISTENT);
		else if (cup.isCupOver())
			System.out.println(CUP_OVER);
		else if (cup.isElim(name))
			System.out.println(ELIMINATED);
		else if (cup.canRollDice(name))
			System.out.printf(CAN_ROLL, name);
		else
			System.out.printf(CANNOT_ROLL, name);
	}

	// Prints the actual ranking of the game.
	// pre: in != null && cup != null
	private static void processRanking(Scanner in, Cup cup) {
		Iterator it = cup.sortedIterator();
		while (it.hasNext()) {
			Player next = it.next();
			if (!next.isElim())
				System.out.printf(RANK, next.getName(), next.getGamesWon(), next.getPosition());
			else
				System.out.printf(RANK_ELIM, next.getName(), next.getGamesWon());
		}
		in.nextLine();
	}

	// Command that moves the player in the board, taking into account the veracity
	// of the dices and the status of the cup.
	// pre: in != null && cup != null
	private static void processDice(Scanner in, Cup cup) {
		int p1 = in.nextInt();
		int p2 = in.nextInt();
		if (!isValidDice(p1, p2))
			System.out.println(INVALID_DICE);
		else if (cup.isCupOver())
			System.out.println(CUP_OVER);
		else
			cup.rollDice(p1, p2);
		in.nextLine();
	}

	// Returns "true" if the value of the dices are valid.
	private static boolean isValidDice(int p1, int p2) {
		return p1 >= MIN_DICE && p1 <= MAX_DICE && p2 >= MIN_DICE && p2 <= MAX_DICE;
	}

	// Command that ends the interaction with the user, printing the status of the
	// cup.
	// pre: cup != null
	private static void processExit(Scanner in, Cup cup) {
		if (cup.isCupOver())
			System.out.printf(WINNER, cup.getCupWinnerName());
		else
			System.out.println(CUP_NOT_OVER);
		in.nextLine();
	}

	// Alerts the user that the command given is not valid.
	// pre: in != null
	private static void processDefault(Scanner in) {
		System.out.println(INVALID_COMMAND);
		in.nextLine();
	}
}
