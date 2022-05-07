package FormatPackage;

public class fraccion {
	private int numeradorInt;
	private int denominadorInt;
	private double numeradorDouble;
	private double denominadorDouble;
	
	///***CONSTRUCTORES***///
	public fraccion() {
		this.numeradorInt=0;
		this.denominadorInt=1;
	}

	public fraccion(double numeradorDouble, double denominadorDouble){
		super();
		this.denominadorDouble=denominadorDouble;
		this.numeradorDouble=numeradorDouble;
	}

	public fraccion(int numeradorI, int denominadorInt) {
		super();
		this.denominadorInt=denominadorInt;
		this.numeradorInt=numeradorI;
	}
	
	public fraccion(fraccion fraccion) {
		super();
		this.numeradorInt=fraccion.numeradorInt;
		this.denominadorInt=fraccion.denominadorInt;
	}
	///***CONSTRUCTORES***///
	
	//***GETTERS***//
	public int getnumeradorInt() {
		return numeradorInt;
	}
	public int getDenominadorInt() {
		return denominadorInt;
	}

	public double getnumeradorDouble() {
		return numeradorDouble;
	}
	public double getDenominadorDouble() {
		return denominadorDouble;
	}
	//***GETTERS***//
	
	
	//**METODOS DE OPERACIONES CON FRACCIONES**//
	public fraccion sumar (fraccion fraccion) {
		fraccion nueva = new fraccion();
		nueva.numeradorInt=this.numeradorInt*fraccion.denominadorInt+this.denominadorInt*fraccion.numeradorInt;
		nueva.denominadorInt=this.denominadorInt*fraccion.denominadorInt;
		return nueva;
	}
	public fraccion restar (fraccion fraccion) {
		fraccion nueva = new fraccion();
		nueva.denominadorInt=this.denominadorInt*fraccion.denominadorInt;
		nueva.numeradorInt=this.numeradorInt*fraccion.denominadorInt-this.denominadorInt*fraccion.numeradorInt;
		return nueva;
	}
	public static fraccion sumar (fraccion frac1,fraccion frac2) {
		fraccion f1 =new fraccion();
		f1.denominadorInt=frac1.denominadorInt*frac2.denominadorInt;
		f1.numeradorInt=frac1.numeradorInt*frac2.denominadorInt+frac2.numeradorInt*frac1.denominadorInt;
		return f1;
	}
	public fraccion producto (fraccion fraccion) {
		fraccion nueva = new fraccion();
		nueva.denominadorInt=this.denominadorInt*fraccion.denominadorInt;
		nueva.numeradorInt=this.numeradorInt*fraccion.numeradorInt;
		return nueva;
	}
	public fraccion division (fraccion fraccion) {
		fraccion nueva = new fraccion();
		nueva.numeradorInt=this.numeradorInt*fraccion.denominadorInt;
		nueva.denominadorInt=this.denominadorInt*fraccion.numeradorInt;
		return nueva;
	}
	
	public int mcdInt(int x, int y) {
		int aux;
		while (x%y != 0) {
			aux=y;
			y=x%y;
			x=aux;
		}
		int mcd=y;
		return mcd;
	}

	public double mcdDouble(double x, double y) {
		double aux;
		while (x%y != 0) {
			aux=y;
			y=x%y;
			x=aux;
		}
		double mcd=y;
		return mcd;
	}

	public fraccion simplificarDouble(fraccion fraccion) {
		double a = fraccion.numeradorInt;
		double b = fraccion.denominadorInt;
		fraccion.numeradorDouble = a/(mcdDouble(a,b));
		fraccion.denominadorDouble = b/(mcdDouble(a,b));
		
		if (fraccion.denominadorInt<0) {
			fraccion.numeradorDouble=-fraccion.numeradorInt;
			fraccion.denominadorDouble=Math.abs(fraccion.denominadorInt);
			return fraccion;
		}
		return fraccion;
	}

	public fraccion simplificarInt(fraccion fraccion) {
		int a=fraccion.numeradorInt;
		int b=fraccion.denominadorInt;
		fraccion.numeradorInt = a/(mcdInt(a,b));
		fraccion.denominadorInt = b/(mcdInt(a,b));
		
		if (fraccion.denominadorInt<0) {
			fraccion.numeradorInt = -fraccion.numeradorInt;
			fraccion.denominadorInt = Math.abs(fraccion.denominadorInt);
			return fraccion;
		}
		return fraccion;
	}
	//**METODOS DE OPERACIONES CON FRACCIONES**//
	
	
	///***OTROS METODOS***///

	public static boolean isInt(double number) {
		if (number - (int) number == 0) { return true; }
		else return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		fraccion other = (fraccion) obj;
		if (denominadorInt != other.denominadorInt)
			return false;
		if (numeradorInt != other.numeradorInt)
			return false;
		return true;
	}

	public String toStringInt() {
		if (denominadorInt==1) {return numeradorInt+"";}
		if (numeradorInt==0) {return "0";}
		return numeradorInt+"/"+denominadorInt;
    }

	public String toStringDouble() {

		if (denominadorDouble==1) {return numeradorDouble+"";}
		if (numeradorDouble==0) {return "0";}
		return numeradorDouble+"/"+denominadorDouble;
    }
}