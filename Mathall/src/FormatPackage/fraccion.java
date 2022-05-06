package FormatPackage;

public class fraccion {
	private int numerador;
	private int denominador;
	
	///***CONSTRUCTORES***///
	public fraccion() {
		this.numerador=0;
		this.denominador=1;
	}
	public fraccion(int numerador, int denominador) {
		super();
		this.denominador=denominador;
		this.numerador=numerador;
	}
	
	public fraccion(fraccion fraccion) {
		super();
		this.numerador=fraccion.numerador;
		this.denominador=fraccion.denominador;
	}
	///***CONSTRUCTORES***///
	
	//***GETTERS***//
	public int getNumerador() {
		return numerador;
	}
	public int getDenominador() {
		return denominador;
	}
	//***GETTERS***//
	
	
	//**METODOS DE OPERACIONES CON FRACCIONES**//
	public fraccion sumar (fraccion fraccion) {
		fraccion nueva = new fraccion();
		nueva.numerador=this.numerador*fraccion.denominador+this.denominador*fraccion.numerador;
		nueva.denominador=this.denominador*fraccion.denominador;
		return nueva;
	}
	public fraccion restar (fraccion fraccion) {
		fraccion nueva = new fraccion();
		nueva.denominador=this.denominador*fraccion.denominador;
		nueva.numerador=this.numerador*fraccion.denominador-this.denominador*fraccion.numerador;
		return nueva;
	}
	public static fraccion sumar (fraccion frac1,fraccion frac2) {
		fraccion f1 =new fraccion();
		f1.denominador=frac1.denominador*frac2.denominador;
		f1.numerador=frac1.numerador*frac2.denominador+frac2.numerador*frac1.denominador;
		return f1;
	}
	public fraccion producto (fraccion fraccion) {
		fraccion nueva = new fraccion();
		nueva.denominador=this.denominador*fraccion.denominador;
		nueva.numerador=this.numerador*fraccion.numerador;
		return nueva;
	}
	public fraccion division (fraccion fraccion) {
		fraccion nueva = new fraccion();
		nueva.numerador=this.numerador*fraccion.denominador;
		nueva.denominador=this.denominador*fraccion.numerador;
		return nueva;
	}
	
	public int mcd(int x, int y) {
		int aux;
		while (x%y != 0) {
			aux=y;
			y=x%y;
			x=aux;
		}
		int mcd=y;
		return mcd;
	}
	public fraccion simplificar(fraccion fraccion) {
		int a=fraccion.numerador;
		int b=fraccion.denominador;
		fraccion.numerador=a/(mcd(a,b));
		fraccion.denominador=b/(mcd(a,b));
		
		if (fraccion.denominador<0) {
			fraccion.numerador=-fraccion.numerador;
			fraccion.denominador=Math.abs(fraccion.denominador);
			return fraccion;
		}
		return fraccion;
	}
	//**METODOS DE OPERACIONES CON FRACCIONES**//
	
	
	///***OTROS METODOS***///
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		fraccion other = (fraccion) obj;
		if (denominador != other.denominador)
			return false;
		if (numerador != other.numerador)
			return false;
		return true;
	}
	@Override
	public String toString() {
		if (denominador==1) {return numerador+"";}
		if (numerador==0) {return "0";}
		return numerador+"/"+denominador;
        }
}