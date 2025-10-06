
public class Uber {

	public static final int priceMinX = 10;
	public static final int priceKmX = 80;
	public static final int baseFareX = 100;
	public static final int minFareX = 250;
	
	public static final int priceMinXL = 15;
	public static final int priceKmXL = 120;
	public static final int baseFareXL = 150;
	public static final int minFareXL = 350;
	
	private int service, time, distance;
	
	private int priceX;
	private int priceXL;
	

	public Uber(int S, int T, int D) {
		service = S;
		time = T;
		distance = D;

	}
	
	public boolean isUberX (int s) {
		return (service == 1);
			
	}
	
	public boolean isUberXL (int s) {
		return (service == 2);
	}
	
	
	public int uberX (int t, int d) {
		 return priceX = ((priceMinX * time) + (priceKmX * distance) + baseFareX);
	}
	
	public int uberXL (int t, int d) {
		 return priceXL = ((priceMinXL * time) + (priceKmXL * distance) + baseFareXL);
	}

}
