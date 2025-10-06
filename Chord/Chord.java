

public class Chord {
	
    // Constants referring to the Intervals of musical notes 
    private static final int UNISSONOUS = 0;
    private static final int MAJOR_SECOND = 2;
    private static final int MINOR_THIRD = 3;
    private static final int MAJOR_THIRD = 4;
    private static final int PERFECT_FOURTH = 5;
    private static final int PERFECT_FIFTH = 7;
    private static final int MAJOR_SIXTH = 9;
    private static final int MAJOR_SEVENTH = 11;
    private static final int OCTAVE = 12;
	
    // Instance variables
    private int root, second, third;
	
    // Constructor of Chord Class. Receives the first, second and third note and initialize the instance variables
    public Chord(int fst, int snd, int third) {
    	this.root = fst;
    	this.second = snd;
    	this.third = third; 
    }

    // Method to get the first note value
    public int getRoot() {
    	return root;
    }
    
    // Method to get the second note value
    public int getSecond() {
    	return second;
    }
    
    // Method to get the third note value
    public int getThird() {
    	return third;
    }
    
    // Method that returns if it is a Major Chord
    public boolean isMajor() {
    	return Math.abs(second - root) == MAJOR_THIRD && Math.abs(third - root) == PERFECT_FIFTH;
    }
    
    // Method that returns if it is a Minor Chord
    public boolean isMinor() {
    	return Math.abs(second - root) == MINOR_THIRD && Math.abs(third - root) == PERFECT_FIFTH;
    }
    
    // Method that returns if the Chords are equal
    public boolean isUnison(Chord other) {
    	return root == other.getRoot() && second == other.getSecond() && third == other.getThird();
    }

    // Method that returns if the Chords form two octaves
    public boolean formsTwoOctave(Chord other) {
    	return Math.abs(root - other.getRoot()) == OCTAVE && Math.abs(second - other.getSecond()) == OCTAVE && Math.abs(third - other.getThird()) == OCTAVE;
    }

    // Method that returns if the Chords form a pop progression
    public boolean isPopProgression(Chord c2, Chord c3, Chord c4) {
    	return isMajor() && c2.isMajor() && c4.isMajor() && c3.isMinor() && Math.abs(root - c2.getRoot()) == PERFECT_FIFTH &&
    			Math.abs(root - c3.getRoot()) == MAJOR_SIXTH && Math.abs(root - c4.getRoot()) == PERFECT_FOURTH;
    }

    // Method for transposing the Chord notes
    public void transpose(int halfsteps) {
    	root = root + halfsteps;
    	second = second + halfsteps;
    	third = third + halfsteps;
    }

}
