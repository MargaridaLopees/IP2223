import java.util.Scanner;

public class Main {

	// Constants referring to the possible numbers of Chords
	private static final int CHORD_FOUR = 4;
	private static final int CHORD_THREE = 3;
	private static final int CHORD_TWO = 2;
	private static final int CHORD_ONE = 1;
	
	// Constants referring to the possible command options
	private static final String POP = "POP";
	private static final String OCT = "OCT";
	private static final String UNI = "UNI";
	private static final String MIN = "MIN";
	private static final String MAJ = "MAJ";
	private static final String TRP = "TRP";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Chord c1 = createChord(in);
		Chord c2 = createChord(in);
		Chord c3 = createChord(in);
		Chord c4 = createChord(in);
				
		executeOption(in, c1, c2, c3, c4);
		executeOption(in, c1, c2, c3, c4);
		executeOption(in, c1, c2, c3, c4);
		executeOption(in, c1, c2, c3, c4);
		executeOption(in, c1, c2, c3, c4);
		
		in.close();
	}
	

	// Method responsible for the creation of a Chord object
	private static Chord createChord(Scanner in) {
		int fst = in.nextInt();
		int snd = in.nextInt();
		int third = in.nextInt();
		in.nextLine();
			
		return new Chord(fst, snd, third);
	}
	
	// Method responsible for the interpretation of one command
	private static void executeOption(Scanner in, Chord c1, Chord c2, Chord c3, Chord c4) {
		String option = in.next();
		
		switch(option) {
			case TRP:
				processTranspose(in, c1, c2, c3, c4);
				break;
			case MAJ:
				processMajor(in, c1, c2, c3, c4);
				break;
			case MIN:
				processMinor(in, c1, c2, c3, c4);
				break;
			case UNI:
				processUnison(in, c1, c2, c3, c4);
				break;
			case OCT:
				processOctave(in, c1, c2, c3, c4);
				break;
			case POP:
				processPop(c1, c2, c3, c4);
				break;
		}
		in.nextLine();
	}
	 
	// Method to obtain the respective Chord object
	private static Chord selectedChord(int n, Chord c1, Chord c2, Chord c3, Chord c4) {
		Chord chord = null;
		switch(n) {
			case CHORD_ONE:
				chord = c1;
				break;
			case CHORD_TWO:
				chord = c2;
				break;
			case CHORD_THREE:
				chord = c3;
				break;
			case CHORD_FOUR:
				chord = c4;
				break;
		}
		return chord;	
	}
	

	// Method responsible for the processing of POP command
	private static void processPop(Chord c1, Chord c2, Chord c3, Chord c4) {
		if(c1.isPopProgression(c2, c3, c4)) {
			System.out.println("É um exemplo da progressão pop.");
		}
		else {
			System.out.println("Não é um exemplo da progressão pop.");
		}
	}

	// Method responsible for the processing of OCT command
	private static void processOctave(Scanner in, Chord c1, Chord c2, Chord c3, Chord c4) {
		int n = in.nextInt();
		int m = in.nextInt();
		
		Chord cn = selectedChord(n, c1, c2, c3, c4);
		Chord cm = selectedChord(m, c1, c2, c3, c4);
		
		if(cn.formsTwoOctave(cm)) {
			System.out.println("As notas formam um acorde de duas oitavas.");
		}
		else {
			System.out.println("As notas não formam um acorde de duas oitavas.");
		}
	}

	// Method responsible for the processing of UNI command
	private static void processUnison(Scanner in, Chord c1, Chord c2, Chord c3, Chord c4) {
		int n = in.nextInt();
		int m = in.nextInt();
		
		Chord cn = selectedChord(n, c1, c2, c3, c4);
		Chord cm = selectedChord(m, c1, c2, c3, c4);
		
		if(cn.isUnison(cm)) {
			System.out.println("Os acordes são uníssonos.");
		}
		else {
			System.out.println("Os acordes não são uníssonos.");
		}
	}

	// Method responsible for the processing of MIN command
	private static void processMinor(Scanner in, Chord c1, Chord c2, Chord c3, Chord c4) {
		int n = in.nextInt();
		
		Chord c = selectedChord(n, c1, c2, c3, c4);
		
		if(c.isMinor()) {
			System.out.println("O acorde "+n+" é um acorde menor.");
		}
		else {
			System.out.println("O acorde "+n+" não é um acorde menor.");
		}
	}

	// Method responsible for the processing of MAJ command
	private static void processMajor(Scanner in, Chord c1, Chord c2, Chord c3, Chord c4) {
		int n = in.nextInt();
		
		Chord c = selectedChord(n, c1, c2, c3, c4);
		
		if(c.isMajor()) {
			System.out.println("O acorde "+n+" é um acorde maior.");
		}
		else {
			System.out.println("O acorde "+n+" não é um acorde maior.");
		}
	}
		
	//  Method responsible for the processing of TRP command
	private static void processTranspose(Scanner in, Chord c1, Chord c2, Chord c3, Chord c4) {
		int n = in.nextInt();
		int k = in.nextInt();
		
		Chord c = selectedChord(n, c1, c2, c3, c4);
		c.transpose(k);
		
		System.out.println("O acorde "+n+" foi transposto "+k+" semi-tons.");
	}

}
