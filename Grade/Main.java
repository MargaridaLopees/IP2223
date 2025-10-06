import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
				
		double p1 = in.nextDouble();
		double p2 = in.nextDouble();
		double t1 = in.nextDouble();
		double t2 = in.nextDouble();
		double e = in.nextDouble();
		double d  = in.nextDouble();
		in.nextLine();
		Grade g = new Grade(p1, p2, t1, t2, e, d);
		if (g.isExceptional())
			System.out.println("Estudante excecional.");
		else 
			System.out.println("Estudante não excecional.");
		p1 = in.nextDouble();
		p2 = in.nextDouble();
		t1 = in.nextDouble();
		t2 = in.nextDouble();
		e = in.nextDouble();
		d  = in.nextDouble();
		in.nextLine();
		g = new Grade(p1, p2, t1, t2, e, d);
		if (g.isExceptional())
			System.out.println("Estudante excecional.");
		else 
			System.out.println("Estudante não excecional.");
		in.close();
	}

}
