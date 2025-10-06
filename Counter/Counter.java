
public class Counter {
	
	private int status;

	public Counter() {
		status = 0;
	}

	public void inc() {
		status = status + 1;
	}

	public void dec() {
		status = status - 1;
	}

	public int status() {
		return status;
	}

	public void reset() {
		status = 0;
	}

	
}
