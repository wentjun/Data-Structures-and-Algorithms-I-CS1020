// Fraction class

class Fraction {

	/************** Data members **********************/
	private int numer;
	private int denom;

	/************** Constructors **********************/
	public Fraction() {
		setNumer(1);
		setDenom(1);
	}

	public Fraction(int numer, int denom) {
		setNumer(numer);
		setDenom(denom);
	}

	/**************** Accessors ***********************/
	public int getNumer() {
		return numer;
	}

	public int getDenom() {
		return denom;
	}

	/**************** Mutators ************************/
	public void setNumer(int numer) {
		this.numer = numer;
	}

	public void setDenom(int denom) {
		this.denom = denom;
	}

	/***************** Other methods ******************/
	//private int gcf (int a , int b) {
	//	return a%b == 0 ? b : gcf ( b , a%b );
	//}

	private int gcd(int a , int b ) {
		if (a%b == 0) {
			return b; 
		} else {
			return gcd(b, a%b);
		}
	}

	private Fraction simplify() {
		int gcdValue = gcd(numer, denom);

		numer = numer/gcdValue;
		denom = denom/gcdValue;

		return new Fraction(numer, denom);
	}

	public Fraction add(Fraction f) {
		int newNumer = (this.numer * f.denom) + (f.numer * this.denom);
		int newDenom = this.denom * f.denom;
		Fraction newFrac = new Fraction(newNumer, newDenom);
	
		return newFrac.simplify();
	}

	public String toString() {
		return "" + getNumer() + "/" + getDenom();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Fraction) {
			Fraction frac = (Fraction) obj;
			Fraction check1 = this.simplify();
			Fraction check2 = frac.simplify();
			return this.getNumer() == frac.getNumer() &&
				this.getDenom() == frac.getDenom();
		}
		else
			return false;
	}
}

