
public class Grade {

	public static final double passingGrade = 9.50;
	private static final double weightp1 = 0.10;
	private static final double weightp2 = 0.25;
	private static final double weightpGrade = 0.35;
	private static final double weightt1 = 0.20;
	private static final double weightt2 = 0.35;
	private static final double weighttpGrade = 0.55;

	private double e;
	private double d;
	private double pGrade;
	private double tpGrade;

	public Grade(double p1, double p2, double t1, double t2, double e, double d) {
		this.e = e;
		this.d = d;
		pGrade = roundValue(((p1 * weightp1) + (p2 * weightp2)) / weightpGrade);
		tpGrade = roundValue(((t1 * weightt1) + (t2 * weightt2)) / weighttpGrade);

	}

	private double roundValue(double val) {
		return Math.round(val * 100.0) / 100.0;
	}

	public boolean hasFreq() {
		return pGrade >= passingGrade;
	}

	public double finalGrade() {
		if ((tpGrade) < passingGrade) {
			return tpGrade;
		} else {
			return pGrade * weightpGrade + tpGrade * weighttpGrade + e + d;

		}
	}

	public double neededExamGrade() {
		if ((-(((pGrade * weightpGrade) + e + d) - passingGrade) / weighttpGrade) > passingGrade) {
			return (-(((pGrade * weightpGrade) + e + d) - passingGrade) / weighttpGrade);
		} else {
			return passingGrade;
		}

	}

}
