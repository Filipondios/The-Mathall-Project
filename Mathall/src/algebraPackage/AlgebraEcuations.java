package algebraPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import filipondiosUtils.FormattedNumber;
import java.io.IOException;
import graphicsPackage.Graphics;

/**Class that contains different methods to resolve equations and systems. As this class is 
 * implemented today, there is only one method (See it below ).
 * @author Filipondios
 * @version 07.06.2022*/
public class AlgebraEcuations {

	Scanner sc = new Scanner(System.in);
	Graphics Gr = new Graphics();
	/**Method that calculates the roots of second grade equations. It tells the user if there is a single
	 * solution, two or none Real solutions and then solves the equation. This method dont have the option to calculte 
	 * the imaginary solutions of equations in the case that there are not Real solutions, but it will be able to do that some day.
	 * @throws IOException
	 * @throws InterruptedException */
	public void SecondGradeEquation() throws IOException, InterruptedException {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
				+ "███████████████████████████ SECOND GRADE EQUATIONS RESOLUTION ███████████████████████████████\n"
				+ "█████████████████████████████████████████████████████████████████████████████████████████████\n");			
			
			System.out.println("Type the equaton's value of the co-efficients a,b,c: ax\u00B2 + bx + c =0");
			System.out.print(">>> a = "); FormattedNumber a = new FormattedNumber(sc.next());
			System.out.print(">>> b = "); FormattedNumber b = new FormattedNumber(sc.next());
			System.out.print(">>> c = "); FormattedNumber c = new FormattedNumber(sc.next());

			System.out.println("\nYour second-grade equation is: " + a + "x\u00B2 + " + b + "x + " + c + " = 0");
			FormattedNumber dis = a.substractOf(b.pow(2), a.productOf(a.productOf(new FormattedNumber(4),a),c));
			
			if(dis.doubleValue()<0) {System.out.println("There is no real solution to this equation.\n");}
			else {
				b= b.product(new FormattedNumber(-1));
				
				if (Math.sqrt(dis.doubleValue())- (int) (Math.sqrt(dis.doubleValue()))!=0) {
					String chain1 = b+"+\u221A"+dis+"";
					String chain2 = b+"-\u221A"+dis+"";
					String chain3 = a.product(new FormattedNumber(2))+"";
					
					String spaces="", slash="";
					
					if (chain1.length()>chain3.length()) {
						for (int i = 0; i < chain1.length(); i++) {	slash+="─"; }
						
					}else if (chain1.length()<chain3.length() || chain1.length()==chain3.length()){
						for (int i = 0; i < chain2.length(); i++) {	slash+="─"; }
					}
					
					for (int i = 0; i < (chain1.length()-chain3.length())/2; i++) { spaces+=" "; }
					
					System.out.println("There are two solutions to this equation:\n");
					System.out.println(chain1+"\n"+slash+" = x1\n"+spaces+chain3+"\n");
					System.out.println(chain2+"\n"+slash+" = x2\n"+spaces+chain3+"\n");
					
				}else {
					dis = dis.sqrt();
					FormattedNumber result1 = a.divisionOf(b.add(dis), a.product(new FormattedNumber(2)));
					FormattedNumber result2 = a.divisionOf(b.substract(dis), a.product(new FormattedNumber(2)));
					
					if (result1.equals(result2)) {
						System.out.println("There is a double solution to this equation: \nx= "+result1+"\n");
					}else {
						System.out.println("There are two solutions for this equation: \nx1= "+result1+"\nx1= "+result2+"\n");
					}
				}
			}
			
		}catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
}