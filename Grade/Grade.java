
public class Grade {

	private double p1;
	private double p2;
	private double t1;
	private double t2;
	private double edGrade;
	private double tpGrade;

	public Grade(double p1, double p2, double t1, double t2, double e, double d) {
		this.p1 = p1;
		this.p2 = p2;
		this.t1 = t1;
		this.t2 = t2;
		edGrade = e + d;
		tpGrade = ((t1 * 0.20) + (t2 * 0.35)) / 0.55;

	}

	private boolean isProjectExceptional() {
		return (p1 >= 16 && p2 >= 18) || (p1 >= 18 && p2 >= 16);

	}

	private boolean isTestsExceptional() {
		return ((t1 >= 16 && t2 >= 16) && tpGrade > 17);
	}

	public boolean isExceptional() {
		return (isProjectExceptional() && isTestsExceptional() && edGrade == 2);

	}

}
