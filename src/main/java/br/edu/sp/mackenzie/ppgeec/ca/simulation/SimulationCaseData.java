package br.edu.sp.mackenzie.ppgeec.ca.simulation;

public class SimulationCaseData {

	// K
	private double k1;
	private double k2;
	private double k3;
	private double k4;
	private double k5;

	// cura
	private double beta1;
	private double beta2;
	private double beta;

	private double b1;
	private double b2;

	// morte doenca
	private double c1;
	private double c2;

	private double gamma1;
	private double gamma2;

	private double gamma;

	// morte outras causas
	private double e;
	private double e1;
	private double e2;

	private double epsilon;
	
	// VACINA
	private double v;

	public double getK1() {
		return k1;
	}

	public void setK1(double k1) {
		this.k1 = k1;
	}

	public double getK2() {
		return k2;
	}

	public void setK2(double k2) {
		this.k2 = k2;
	}

	public double getK3() {
		return k3;
	}

	public void setK3(double k3) {
		this.k3 = k3;
	}

	public double getK4() {
		return k4;
	}

	public void setK4(double k4) {
		this.k4 = k4;
	}

	public double getK5() {
		return k5;
	}

	public void setK5(double k5) {
		this.k5 = k5;
	}

	public double getBeta1() {
		return beta1;
	}

	public void setBeta1(double beta1) {
		this.beta1 = beta1;
	}

	public double getBeta2() {
		return beta2;
	}

	public void setBeta2(double beta2) {
		this.beta2 = beta2;
	}

	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public double getB1() {
		return b1;
	}

	public void setB1(double b1) {
		this.b1 = b1;
	}

	public double getB2() {
		return b2;
	}

	public void setB2(double b2) {
		this.b2 = b2;
	}

	public double getC1() {
		return c1;
	}

	public void setC1(double c1) {
		this.c1 = c1;
	}

	public double getC2() {
		return c2;
	}

	public void setC2(double c2) {
		this.c2 = c2;
	}

	public double getGamma1() {
		return gamma1;
	}

	public void setGamma1(double gamma1) {
		this.gamma1 = gamma1;
	}

	public double getGamma2() {
		return gamma2;
	}

	public void setGamma2(double gamma2) {
		this.gamma2 = gamma2;
	}

	public double getGamma() {
		return gamma;
	}

	public void setGamma(double gamma) {
		this.gamma = gamma;
	}

	public double getE() {
		return e;
	}

	public void setE(double e) {
		this.e = e;
	}

	public double getE1() {
		return e1;
	}

	public void setE1(double e1) {
		this.e1 = e1;
	}

	public double getE2() {
		return e2;
	}

	public void setE2(double e2) {
		this.e2 = e2;
	}

	public double getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(b1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(b2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(beta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(beta1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(beta2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(c1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(c2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(e);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(e1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(e2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(epsilon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(gamma);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(gamma1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(gamma2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(k1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(k2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(k3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(k4);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(k5);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(v);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimulationCaseData other = (SimulationCaseData) obj;
		if (Double.doubleToLongBits(b1) != Double.doubleToLongBits(other.b1))
			return false;
		if (Double.doubleToLongBits(b2) != Double.doubleToLongBits(other.b2))
			return false;
		if (Double.doubleToLongBits(beta) != Double.doubleToLongBits(other.beta))
			return false;
		if (Double.doubleToLongBits(beta1) != Double.doubleToLongBits(other.beta1))
			return false;
		if (Double.doubleToLongBits(beta2) != Double.doubleToLongBits(other.beta2))
			return false;
		if (Double.doubleToLongBits(c1) != Double.doubleToLongBits(other.c1))
			return false;
		if (Double.doubleToLongBits(c2) != Double.doubleToLongBits(other.c2))
			return false;
		if (Double.doubleToLongBits(e) != Double.doubleToLongBits(other.e))
			return false;
		if (Double.doubleToLongBits(e1) != Double.doubleToLongBits(other.e1))
			return false;
		if (Double.doubleToLongBits(e2) != Double.doubleToLongBits(other.e2))
			return false;
		if (Double.doubleToLongBits(epsilon) != Double.doubleToLongBits(other.epsilon))
			return false;
		if (Double.doubleToLongBits(gamma) != Double.doubleToLongBits(other.gamma))
			return false;
		if (Double.doubleToLongBits(gamma1) != Double.doubleToLongBits(other.gamma1))
			return false;
		if (Double.doubleToLongBits(gamma2) != Double.doubleToLongBits(other.gamma2))
			return false;
		if (Double.doubleToLongBits(k1) != Double.doubleToLongBits(other.k1))
			return false;
		if (Double.doubleToLongBits(k2) != Double.doubleToLongBits(other.k2))
			return false;
		if (Double.doubleToLongBits(k3) != Double.doubleToLongBits(other.k3))
			return false;
		if (Double.doubleToLongBits(k4) != Double.doubleToLongBits(other.k4))
			return false;
		if (Double.doubleToLongBits(k5) != Double.doubleToLongBits(other.k5))
			return false;
		if (Double.doubleToLongBits(v) != Double.doubleToLongBits(other.v))
			return false;
		return true;
	}

}
