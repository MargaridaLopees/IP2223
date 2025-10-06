
public class Main {

	public static void main(String[] args) {

		Counter c1 = new Counter();
		System.out.println(c1.status());
		c1.inc();
		System.out.println(c1.status());
		c1.inc();
		System.out.println(c1.status());
		c1.dec();
		c1.reset();
		System.out.println(c1.status());

	}

}
