package filipondiosUtils;
/**
 * Class that creates objets symulating fraction numbers and int numbers by parsing a String input with or without
 * the character "/". This allows to the user to type any number as n/m or n.
 * @author Filipondios
 * @version 07.06.2022
 */
public class FormattedNumber implements Comparable<FormattedNumber>{
	private int numerator;
	private int denominator;
	private int slashPosition;

	/**Default constructor - Sets numerator to 0 and denominator to 1 so simulate a fracion 0/1=0*/
	public FormattedNumber() {
		this.numerator = 0;
		this.denominator = 1;
	}
	
	/**Constructor that creates a non fraction number based in the given parameter.
	 * @param number Int number*/
	public FormattedNumber(int number) {
		this.numerator = number;
		this.denominator = 1;
	}
	
	/**Constructor that creates a fraction number based in the given parameters.
	 * @param numerator Numerator of the fraction number.
	 * @param denominator Denominator of the fraction number.*/
	public FormattedNumber(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/** Contructor with a String as parameter. It parses a String with or without a '/' character to symulate a
	 * fraction or a int number.
	 * @param chainNumber String input that must be a chain of numbers with or without the character '/'
	 * 		in a different position than first and last. */
	public FormattedNumber(String number) {

		if (containSlash(number)) {
			this.numerator = stringListToInt(number,0,this.slashPosition,true);
			this.denominator = stringListToInt(number,this.slashPosition+1,number.length(),true);
		}else {
			this.numerator = stringListToInt(number,0,number.length()-1,false);
			this.denominator = 1;
		}	
	}
	
	/**Searches in a String character '/'. This method will be used to know if the character that we are
	 * looking for is in the String, and where it is. The main use of this method will be
	 * to know how long the numerator is, and where the denominator of a fraction begins if it exists.
	 * @param number String object that represents a number.
	 * @return True If there is a '/' character in the list, false if dont.*/
	private boolean containSlash(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i)=='/') {
				this.slashPosition = i;
				return true; 
			}
		}
		return false;
	}

	/**Converts a section of a String into a int number. The method's parameters need to be the start,
	 * and end of the list and another boolean parameter called "flag" that will indicate if the String list to parse
	 * has a '/' character (See the variables description below to know when "flag" will take the values true and false).
	 * Like it was said before, the main use of this method will be parsing the string chain of numbers of a String object
	 * to int, being possible to separate the denominator and numerator of a fraction. For example, for the String
	 * that represent the fraction 12/57, this method must be called 2 times, one for parsing from 0 to '/' and
	 * another from '/' to 4 without counting the '/'. The calls will be like stringListToInt(number,0,slashPosition,true) 
	 * and stringListToInt(number,slashPosition+1,number.length(),true).
	 * If the String to parse is a normal number, for example: 321, then there will be only one call, in this case  
	 * stringListToInt(number,0,number.length()-1,false).
	 * 
	 * @param number String object to parse.
	 * @param first Parsing starting point.
	 * @param last Parsing end point.
	 * @param flag Variable that have to indicate if the String list has a '/' character. 
	 * 				True if it has a '/' character - False if dont.
	 * @return Parsed number
	 */
	private int stringListToInt(String number,int first, int last, boolean flag) {
		int num=0, jFirst=last;
		boolean minus = false;		
		
		if (number.charAt(first)=='-') {
			if (!flag) { jFirst--;}
			first++; minus = true;
		}
		
		if (flag) {
			for (int i = first,j=last-first-1; i < last; i++,j--)
				num += Integer.parseInt(number.charAt(i)+"")*Math.pow(10, j);
		}else {
			for (int i = first,j=jFirst; i <= last; i++,j--)
				num += Integer.parseInt(number.charAt(i)+"")*Math.pow(10,j);
		}
		
		if (minus) { return num*(-1); }
		return num;
	}
	
	/**Method that makes the addition of two FormattedNumbers.
	 * @param number {@link FormattedNumber}.
	 * @return {@link FormattedNumber} - Addition of the calling Object and the {@link FormattedNumber} parameter.*/
	public FormattedNumber add (FormattedNumber number) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.denominator=this.denominator*number.denominator;
		formatted.numerator=this.numerator*number.denominator+number.numerator*this.denominator;
		return formatted;
	}
	
	/**Method that makes the addition of two FormattedNumbers.
	 * @param number1 {@link FormattedNumber}.
	 * @param number2 {@link FormattedNumber}.
	 * @return {@link FormattedNumber} - Addition of the two {@link FormattedNumber} parameters.*/
	public FormattedNumber additionOf (FormattedNumber number1, FormattedNumber number2) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.denominator=number1.denominator*number2.denominator;
		formatted.numerator=number1.numerator*number2.denominator+number2.numerator*number1.denominator;
		return formatted;
	}

	/**Method that makes the substract of two FormattedNumbers.
	 * @param number {@link FormattedNumber}.
	 * @return {@link FormattedNumber} - Substract of the calling Object and the {@link FormattedNumber} parameter.*/
	public FormattedNumber substract (FormattedNumber number) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.denominator=this.denominator*number.denominator;
		formatted.numerator=this.numerator*number.denominator - number.numerator*this.denominator;
		return formatted;
	}
	
	/**Method that makes the substract of two FormattedNumbers.
	 * @param number1 {@link FormattedNumber}.
	 * @param number2 {@link FormattedNumber}.
	 * @return {@link FormattedNumber} - Substract of the two {@link FormattedNumber} parameters.*/
	public FormattedNumber substractOf (FormattedNumber number1, FormattedNumber number2) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.denominator=number1.denominator*number2.denominator;
		formatted.numerator=number1.numerator*number2.denominator - number2.numerator*number1.denominator;
		return formatted;
	}
	
	/**Method that makes the product of two FormattedNumbers.
	 * @param number {@link FormattedNumber}.
	 * @return FormattedNumber - Product of the calling Object and the {@link FormattedNumber} parameter.*/
	public FormattedNumber product (FormattedNumber number) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.numerator=this.numerator*number.numerator;
		formatted.denominator=this.denominator*number.denominator;
		return formatted;
	}
	
	/**Method that makes the product of two FormattedNumbers.
	 * @param number1 {@link FormattedNumber}.
	 * @param number2 {@link FormattedNumber}.
	 * @return {@link FormattedNumber} - Product of the two {@link FormattedNumber} parameters.*/
	public FormattedNumber productOf (FormattedNumber number1, FormattedNumber number2) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.numerator=number1.numerator*number2.numerator;
		formatted.denominator=number1.denominator*number2.denominator;
		return formatted;
	}

	/**Method that makes the division of the calling FormattedNumbers.
	 * @param number {@link FormattedNumber}.
	 * @return {@link FormattedNumber} - Division of the calling Object and the {@link FormattedNumber} parameter.*/
	public FormattedNumber division (FormattedNumber number) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.numerator=this.numerator*number.denominator;
		formatted.denominator=this.denominator*number.numerator;
		return formatted;
	}
	
	/**Method that makes the division of two FormattedNumbers.
	 * @param number1 {@link FormattedNumber}.
	 * @param number2 {@link FormattedNumber}.
	 * @return {@link FormattedNumber} - Division of the two FormattedNumber parameters.*/
	public FormattedNumber divisionOf (FormattedNumber number1, FormattedNumber number2) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.numerator=number1.numerator*number2.denominator;
		formatted.denominator=number1.denominator*number2.numerator;
		return formatted;
	}
	
	/**
	 * Method that calculates the pow given by the parameter to the calling Object.
	 * @param pow Int number that describes the pow to make.
	 * @return {@link FormattedNumber} - Nth Pow of the calling Object.
	 */
	public FormattedNumber pow(int pow) {
		FormattedNumber formatted = new FormattedNumber();
		formatted.numerator = (int) Math.pow(this.numerator,pow);
		formatted.denominator = (int) Math.pow(this.denominator,pow);	
		return formatted;
	}
	
	/**Method that calculates the pow given by the parameter to the calling Object.
	 * @param number {@link FormattedNumber}.
	 * @param pow Int number that describes the pow to make.
	 * @return {@link FormattedNumber} - Nth Pow of the {@link FormattedNumber} parameter. */
	public FormattedNumber pow(FormattedNumber number, int pow) {
		FormattedNumber formatted = new FormattedNumber();
		formatted.numerator = (int) Math.pow(number.numerator,pow);
		formatted.denominator = (int) Math.pow(number.denominator,pow);
		return formatted;
	}
	
	/** Method that calculates the square root of a {@link FormattedNumber}. Because
	 * {@link FormattedNumber} are made by two int numbers, this method wont be able to
	 * return the exact result of the square root at least if the results are int,
	 * for example sqrt(4).
	 * @return Square root of the {@link FormattedNumber} parameter.*/
	public FormattedNumber sqrt(FormattedNumber number) {
		FormattedNumber formatted = new FormattedNumber();
		formatted.numerator = (int) (Math.sqrt(number.numerator));
		formatted.denominator = (int) (Math.sqrt(number.denominator));
		return formatted;
	}
	
	/** Method that calculates the square root of a {@link FormattedNumber}.
	 * @return Double value os the square root of the calling Object.*/
	public double sqrt() {
		return Math.sqrt(this.doubleValue());
	}
	
	/**Method that simplifies a {@link FormattedNumber} like a fraction should be.
	 * @param number {@link FormattedNumber}*/
	public void simplify(FormattedNumber number) {
		int a=number.numerator;
		int b=number.denominator;
		number.numerator=a/(gcd(a,b));
		number.denominator=b/(gcd(a,b));

		if (number.denominator<0) {
			number.numerator=-number.numerator;
			number.denominator=Math.abs(number.denominator);
		}
	}

	/** Method that calculates the greatest common divisor of two int numbers.
	 * @param x Int number
	 * @param y Int number
	 * @return Greatest common divisor of the parameters */
	private static int gcd(int x, int y) {
		int aux;
		while (x%y != 0) {
			aux=y;
			y=x%y;
			x=aux;
		}
		int gcd=y;
		return gcd;
	}

	/** Method that returns the double value of a {@link FormattedNumber}.
	 * @return The real Double value of the calling {@link FormattedNumber} Object.*/
	public double doubleValue() { return ((double)this.numerator/(double)this.denominator); }

	/** Method that returns the double value of a {@link FormattedNumber}.
	 * @return The real Double value of the {@link FormattedNumber} parameter.*/
	public double doubleValue(FormattedNumber number) { 
		return ((double)number.numerator/(double)number.denominator); 
	}
	
	/** Method that returns the float value of a {@link FormattedNumber}.
	 * @return The real Float value of the calling {@link FormattedNumber} Object.*/
	public float floatValue() { return ((float)this.numerator/(float)this.denominator); }

	/** Method that returns the float value of a {@link FormattedNumber}.
	 * @return The real Float value of the {@link FormattedNumber} parameter.*/
	public float floatValue(FormattedNumber number) { 
		return ((float)number.numerator/(float)number.denominator); 
	}
	
	/** Method that returns the int value of a {@link FormattedNumber}.
	 * @return The real Int value of the calling {@link FormattedNumber} Object.*/
	public int intValue() { return (this.numerator/this.denominator); }

	/** Method that returns the int value of a {@link FormattedNumber}.
	 * @return The real Int value of the {@link FormattedNumber} parameter.*/
	public int intValue(FormattedNumber number) { 
		return (number.numerator/number.denominator); 
	}
	
	/** Method that return the long value of the possible fraccion.
	 * @return The real Long value of the {@link FormattedNumber}*/
	public long longValue() { return ((long)this.numerator/(long)this.denominator); }
	
	/** Method that returns the long value of a {@link FormattedNumber}.
	 * @return The real Long value of the {@link FormattedNumber} parameter.*/
	public long longValue(FormattedNumber number) { 
		return ((long)number.numerator/(long)number.denominator); 
	}

	/** Method that checks if a {@link FormattedNumber} is a fraction or not.
	 * @return False if the property denominator equals 1, true if dont*/
	public boolean isFraction() {
		simplify(this);
		return	(this.denominator == 1);
	}
	
	/**Method that checks if the calling {@link FormattedNumber} object is a Integer number.*/
	public boolean isInt() {
		return (this.doubleValue()-this.intValue()==0);
	}

	/**Method that checks if a {@link FormattedNumber} is a Integer number.*/
	public boolean isInt(FormattedNumber number) {
		return (number.doubleValue()-number.intValue()==0);
	}
		
	/**Indicates whether some other {@link FormattedNumber} object is "equal to" the calling one. 
	 * @param obj {@link FormattedNumber}.
	 * @return True if are equal - False if dont.*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormattedNumber other = (FormattedNumber) obj;
		return denominator == other.denominator && numerator == other.numerator && slashPosition == other.slashPosition;
	}

	/**Comapares two FormattedNumbers and indicates if the calling one is greater, less or equal than
	 * the specified parameter one.
	 * @return 0 if the Objects are equal, 1 if the calling one is greater and -1 if its the parameter.*/
	@Override
	public int compareTo(FormattedNumber o) {
		if (doubleValue(this)>doubleValue(o)) { return 1; }
		else if (doubleValue(this)<doubleValue(o)) { return -1; }
		return 0;
	}	

	@Override
	public String toString() {
		simplify(this);
		if (denominator==1) {return numerator+"";}
		if (numerator==0) {return "0";}
		return numerator+"/"+denominator;
	}	
}