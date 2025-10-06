
public class Main {

	public static void main(String[] args) {
		Lamp lamp1 = new Lamp();
		Lamp lamp2 = new Lamp();
		System.out.println (lamp1.isOn());
		lamp2.turnOn();
		System.out.println (lamp1.isOn());
		lamp1.turnOn();
		System.out.println (lamp2.isOn());
		System.out.println (lamp1.isOn());
		
	}

}
