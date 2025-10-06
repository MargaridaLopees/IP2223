
public class Lamp {
	
	private boolean lampIsOn;
	public Lamp() { lampIsOn = false; }
	public void turnOn() { lampIsOn = true; }
	public void turnOff() { lampIsOn = false; }
	public boolean isOn() { return lampIsOn; }
	
}
