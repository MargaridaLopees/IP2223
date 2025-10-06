// authors: Margarida Lopes (64557) and Bernardo Gracioso (65284)
// Iterates the given array. 

public class Iterator {

	private Player[] pSorted;
	private int nextIdx;

	// An object Iterator is created giving the copy of the sorted array of players.
	// pre: pSorted != null && pSorted[i].compareTo(pSorted[i+1]) > 0,
	// with i belonging to [0,pSorted.length-1[
	public Iterator(Player[] pSorted) {
		this.pSorted = pSorted;
		nextIdx = 0;
	}

	// Returns "true" if there are still any players to iterate.
	public boolean hasNext() {
		return nextIdx < pSorted.length;
	}

	// Returns the next player to iterate.
	// pre: this.hasNext()
	public Player next() {
		return pSorted[nextIdx++];
	}

}
