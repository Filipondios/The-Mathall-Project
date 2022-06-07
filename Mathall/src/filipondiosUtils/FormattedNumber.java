package filipondiosUtils;

import java.util.ArrayList;
/**
 * Class that creates objets symulating fraction numbers and int numbers by parsing a String input with or without
 * the character "/". This allows to the user to type any number as n/m or n.
 * @author Filipondios
 * @version 07.06.2022
 */
public class FormattedNumber implements Comparable<FormattedNumber>{
	private ArrayList <String> Input = new ArrayList<String>();
	private int numerator;
	private int denominator;

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

	/** Contructor with a String as parameter. It parses a String with or without a "/" character to symulate a
	 * fraction or a int number.
	 * @param chainNumber String input that must be a chain of numbers with or without the character "/"
	 * 		in a different position than first and last. */
	public FormattedNumber(String chainNumber) {
		for (int i = 0; i < chainNumber.length() ; i++) 
			Input.add(String.valueOf(chainNumber.charAt(i))); 
		
		Input.trimToSize();

		if (containSlash(Input)) {
			int limit = Integer.parseInt(Input.get(Input.size()-1));
			this.numerator = stringListToInt(Input,0,limit,true);
			this.denominator = stringListToInt(Input,limit+1,Input.size()-1,true);
		}else {
			this.numerator = stringListToInt(Input,0,Input.size()-1,false);
			this.denominator = 1;
		}	
	}
	
	/**Searches in a Array List the character "/". In the case that exists a "/" in the List, the position where
	 * this character is located is added is the last position of the List. This method will be used to know if
	 * the character that we are looking for is in the List, and where it is. The main use of this method will be
	 * to know how long the numerator is, and where the denominator of a fraction begins if it exists.
	 * @param list Array List of String type
	 * @return True If there is a "/" character in the list, false if dont.*/
	private boolean containSlash(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("/")) {
				list.add(String.valueOf(i));
				return true; 
			}
		}
		return false;
	}

	/**Converts a sectuion of a String Array List into a int number. The method's parameters need to be the start,
	 * and end of the list and another boolean parameter called "flag" that will indicate if the String list to parse
	 * has a "/" character (See the variables description below to know when "flag" will take the values true and false.
	 * Like it was said before, the main use of this method will be parsing the string chain of numbers of the list
	 * to int, being possible to separate the denominator and numerator of a fraction. Example, for the String
	 * that represent the fraction 12/57, this method must be called 2 times, one for parsing from 1 to "/" and
	 * another from "/" to 7 without counting the "/". The calls will be like stringListToInt(list,0,2,true) 
	 * and stringListToInt(list,2,list.size()-1,true) (Remember that the positions in ArrayLists goes from 0 to lenght-1).
	 * If the String to parse is a normal number, for example: 321, then there will be only one call, in this case  
	 * stringListToInt(list,0,list.size()-1,false).
	 * 
	 * @param list Array List of String type.
	 * @param first Parsing starting point.
	 * @param last Parsing end point.
	 * @param flag Variable that have to indicate if the String list has a "/" character. 
	 * 				True if it has a ""/" character - False if dont.
	 * @return Parsed number
	 */
	private int stringListToInt(ArrayList<String> list,int first, int last, boolean flag) {
		int num=0, jFirst=last;
		boolean minus = false;		
		
		if (list.get(first).equals("-")) {
			if (!flag) { jFirst--;}
			first++; minus = true;
		}
		
		if (flag) {
			for (int i = first,j=last-first-1; i < last; i++,j--)
				num += Integer.parseInt(list.get(i))*Math.pow(10, j);
		}else {
			for (int i = first,j=jFirst; i <= last; i++,j--)
				num += Integer.parseInt(list.get(i))*Math.pow(10,j);
		}
		
		if (minus) { return num*(-1); }
		return num;
	}
	
	/**Method that makes the addition of two FormattedNumbers.
	 * @param number FormattedNumber.
	 * @return FormattedNumber - Addition of the calling Object and the FormattedNumber parameter.*/
	public FormattedNumber add (FormattedNumber number) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.denominator=this.denominator*number.denominator;
		formatted.numerator=this.numerator*number.denominator+number.numerator*this.denominator;
		return formatted;
	}
	
	/**Method that makes the addition of two FormattedNumbers.
	 * @param number1 FormattedNumber.
	 * @param number2 FormattedNumber.
	 * @return FormattedNumber - Addition of the two FormattedNumber parameters.*/
	public FormattedNumber additionOf (FormattedNumber number1, FormattedNumber number2) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.denominator=number1.denominator*number2.denominator;
		formatted.numerator=number1.numerator*number2.denominator+number2.numerator*number1.denominator;
		return formatted;
	}

	/**Method that makes the substract of two FormattedNumbers.
	 * @param number FormattedNumber.
	 * @return FormattedNumber - Substract of the calling Object and the FormattedNumber parameter.*/
	public FormattedNumber substract (FormattedNumber number) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.denominator=this.denominator*number.denominator;
		formatted.numerator=this.numerator*number.denominator - number.numerator*this.denominator;
		return formatted;
	}
	
	/**Method that makes the substract of two FormattedNumbers.
	 * @param number1 FormattedNumber.
	 * @param number2 FormattedNumber.
	 * @return FormattedNumber - Substract of the two FormattedNumber parameters.*/
	public FormattedNumber substractOf (FormattedNumber number1, FormattedNumber number2) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.denominator=number1.denominator*number2.denominator;
		formatted.numerator=number1.numerator*number2.denominator - number2.numerator*number1.denominator;
		return formatted;
	}
	
	/**Method that makes the product of two FormattedNumbers.
	 * @param number FormattedNumber.
	 * @return FormattedNumber - Product of the calling Object and the FormattedNumber parameter.*/
	public FormattedNumber product (FormattedNumber number) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.numerator=this.numerator*number.numerator;
		formatted.denominator=this.denominator*number.denominator;
		return formatted;
	}
	
	/**Method that makes the product of two FormattedNumbers.
	 * @param number1 FormattedNumber.
	 * @param number2 FormattedNumber.
	 * @return FormattedNumber - Product of the two FormattedNumber parameters.*/
	public FormattedNumber productOf (FormattedNumber number1, FormattedNumber number2) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.numerator=number1.numerator*number2.numerator;
		formatted.denominator=number1.denominator*number2.denominator;
		return formatted;
	}

	/**Method that makes the division of the calling FormattedNumbers.
	 * @param number FormattedNumber.
	 * @return FormattedNumber - Division of the calling Object and the FormattedNumber parameter.*/
	public FormattedNumber division (FormattedNumber number) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.numerator=this.numerator*number.denominator;
		formatted.denominator=this.denominator*number.numerator;
		return formatted;
	}
	
	/**Method that makes the division of two FormattedNumbers.
	 * @param number1 FormattedNumber.
	 * @param number2 FormattedNumber.
	 * @return FormattedNumber - Division of the two FormattedNumber parameters.*/
	public FormattedNumber divisionOf (FormattedNumber number1, FormattedNumber number2) {
		FormattedNumber  formatted = new FormattedNumber();
		formatted.numerator=number1.numerator*number2.denominator;
		formatted.denominator=number1.denominator*number2.numerator;
		return formatted;
	}
	
	/**
	 * Method that calculates the pow given by the parameter to the calling Object.
	 * @param pow Int number that describes the pow to make.
	 * @return FormattedNumber - Nth Pow of the calling Object.
	 */
	public FormattedNumber pow(int pow) {
		FormattedNumber formatted = new FormattedNumber();
		formatted.numerator = (int) Math.pow(this.numerator,pow);
		formatted.denominator = (int) Math.pow(this.denominator,pow);	
		return formatted;
	}
	
	/**Method that calculates the pow given by the parameter to the calling Object.
	 * @param number FormattedNumber.
	 * @param pow Int number that describes the pow to make.
	 * @return FormattedNumber - Nth Pow of the FormattedNumber parameter. */
	public FormattedNumber pow(FormattedNumber number, int pow) {
		FormattedNumber formatted = new FormattedNumber();
		formatted.numerator = (int) Math.pow(number.numerator,pow);
		formatted.denominator = (int) Math.pow(number.denominator,pow);
		return formatted;
	}
	
	/** Method that calculates the square root of a FormattedNumber. Because
	 * FormattedNumber are made by two int numbers, this method wont be able to
	 * return the exact result of the square root at least if the results are int,
	 * for example sqrt(4).
	 * @return Square root of the calling Object.
	 */
	public FormattedNumber sqrt() {
		FormattedNumber formatted = new FormattedNumber();
		formatted.numerator = (int) (Math.sqrt(this.numerator));
		formatted.denominator = (int) (Math.sqrt(this.denominator));
		return formatted;
	}
	
	/**Method that simplifies a FormattedNumber like a fraction should be.
	 * @param number FormattedNumber*/
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

	/** Method that returns the double value of a FormattedNumber.
	 * @return The real Double value of the calling FormattedNumber Object.*/
	public double doubleValue() { return (double) (this.numerator/this.denominator); }

	/** Method that returns the double value of a FormattedNumber.
	 * @return The real Double value of the FormattedNumber parameter.*/
	public double doubleValue(FormattedNumber number) { 
		return (double) (number.numerator/number.denominator); 
	}
	
	/** Method that returns the float value of a FormattedNumber.
	 * @return The real Float value of the calling FormattedNumber Object.*/
	public double floatValue() { return (float) (this.numerator/this.denominator); }

	/** Method that returns the float value of a FormattedNumber.
	 * @return The real Float value of the FormattedNumber parameter.*/
	public double floatValue(FormattedNumber number) { 
		return (float) (number.numerator/number.denominator); 
	}
	
	/** Method that returns the int value of a FormattedNumber.
	 * @return The real Int value of the calling FormattedNumber Object.*/
	public double intValue() { return (int) (this.numerator/this.denominator); }

	/** Method that returns the int value of a FormattedNumber.
	 * @return The real Int value of the FormattedNumber parameter.*/
	public double intValue(FormattedNumber number) { 
		return (int) (number.numerator/number.denominator); 
	}
	
	/** Method that return the long value of the possible fraccion.
	 * @return The real Long value of the FormattedNumber*/
	public long longValue() { return (long) (this.numerator/this.denominator); }
	
	/** Method that returns the long value of a FormattedNumber.
	 * @return The real Long value of the FormattedNumber parameter.*/
	public double longValue(FormattedNumber number) { 
		return (long) (number.numerator/number.denominator); 
	}

	/** Method that checks if a FormattedNumber is a fraction or not.
	 * @return False if the property denominator equals 1, true if dont*/
	public boolean isFraction() {
		simplify(this);
		return	(this.denominator == 1);
	}

	/**Indicates whether some other FormattedNumber object is "equal to" the calling one. 
	 * @param obj FormattedNumber.
	 * @return True if are equal - False if dont.*/
	public boolean equals(FormattedNumber obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) {	return false; }
		FormattedNumber other = obj;
		if (Input == null) {
			if (other.Input != null) { return false; }
		} else if (!Input.equals(other.Input)) { return false; }
		if (denominator != other.denominator) { return false; }
		if (numerator != other.numerator) { return false; }
		return true;
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