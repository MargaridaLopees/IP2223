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
		if (!g.hasFreq())
			System.out.println("Não obteve frequência.");
		else {
			double fGrade = g.finalGrade();
			System.out.printf("Obteve a nota final de %.0f valor(es).\n",
							  fGrade);
			if (fGrade < Grade.passingGrade)
				System.out.printf("Precisa de pelo menos %.2f no exame.\n",
								  g.neededExamGrade());
		}
		p1 = in.nextDouble();
		p2 = in.nextDouble();
		t1 = in.nextDouble();
		t2 = in.nextDouble();
		e = in.nextDouble();
		d  = in.nextDouble();
		in.nextLine();
		g = new Grade(p1, p2, t1, t2, e, d);
		if (!g.hasFreq())
			System.out.println("Não obteve frequência.");
		else {
			double fGrade = g.finalGrade();
			System.out.printf("Obteve a nota final de %.0f valor(es).\n",
							  fGrade);
			if (fGrade < Grade.passingGrade)
				System.out.printf("Precisa de pelo menos %.2f no exame.\n",
								  g.neededExamGrade());
		}
		in.close();
	}

}
