package algebraPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import filipondiosUtils.FormattedNumber;
import filipondiosUtils.MatrixUtils;
import filipondiosUtils.Print;
import graphicsPackage.Graphics;
import menusPackage.SistemsMenu;

/**Class that contains different methods to resolve equations and systems. This loads a method
 * that was chosen by the user in {@link SistemsMenu}. In case that the entry in any method is
 * not correct, the user will be returned to Mathall main menu {@link SistemsMenu}. 
 * @author Filipondios
 * @version 19.10.2022*/
public class AlgebraEcuations {

	Scanner sc = new Scanner(System.in);
	Graphics Gr = new Graphics();
	MatrixUtils mu =new MatrixUtils();
	/**Method that calculates the roots of second grade equations. It tells the user if there is a single
	 * solution, two or none Real solutions and then solves the equation. This method dont have the option to calculte 
	 * the imaginary solutions of equations in the case that there are not Real solutions, but it will be able to do that some day.*/
	public void SecondGradeEquation() {
		try {
			Print.note("For Mathall, a second grade equation has 3 values (a,b,c) that represents the 3 co-efficiets "
					+ "of the equation ax\u00B2 + bx + c = 0.\n");
			
			System.out.println(" Type the equaton's value of the co-efficients a,b,c:");
			System.out.print(" >>> a = "); FormattedNumber a = new FormattedNumber(sc.next());
			System.out.print(" >>> b = "); FormattedNumber b = new FormattedNumber(sc.next());
			System.out.print(" >>> c = "); FormattedNumber c = new FormattedNumber(sc.next());

			System.out.println("\n Your second-grade equation is: " + a + "x\u00B2 + " + b + "x + " + c + " = 0");
			FormattedNumber dis = a.substractOf(b.pow(2), a.productOf(a.productOf(new FormattedNumber(4),a),c));

			if(dis.doubleValue()<0) {System.out.println(" There is no real solution to this equation.\n");}
			else {
				b = b.product(new FormattedNumber(-1));

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

					System.out.println(" There are two solutions to this equation:\n");
					System.out.println(chain1+"\n"+slash+" = x1\n"+spaces+chain3+"\n");
					System.out.println(chain2+"\n"+slash+" = x2\n"+spaces+chain3+"\n");

				}else {
					dis = dis.sqrt(dis);
					FormattedNumber result1 = a.divisionOf(b.add(dis), a.product(new FormattedNumber(2)));
					FormattedNumber result2 = a.divisionOf(b.substract(dis), a.product(new FormattedNumber(2)));

					if (result1.equals(result2)) {
						System.out.println(" There is a double solution to this equation: \n x= "+result1+"\n");
					}else {
						System.out.println(" There are two solutions for this equation: \n x1= "+result1+"\n x2= "+result2+"\n");
					}
				}
			}

		}catch (InputMismatchException e) {
			sc.nextLine();
			Print.warning("Check your input: its not accepted.\n");
		}
	}

	/**Method that calculates the solutions of linear equation systems. It tells the user if there are infinite solutions,
	 * a determinated number of solutions or none.*/
	public void ecuationSystems() {
		try {
			Print.note("For Mathall, a linear ecuation system consists on n ecuations with n variables. "
					+"For example, a 3 ecuations system with 3 variables looks like:\n");
			System.out.println("  | ax + by +cz = d\n -| a'x + b'y +c'z = d'\n  | ax'' + b''y + c''z = d''");
			Print.note("a,b,c are constants (numbers) and x,y,z are variables.");		
						
			System.out.print("\n Now, type the number of ecuations and variables: ");
			int Dimension = sc.nextInt();
			System.out.println("\n Type the ecuation system data:\n");

			FormattedNumber[][] system = new FormattedNumber[Dimension][Dimension+1];
			/*Now that we have the system matrix, we need another one that is made by the co-efficents at the left side
			 * of every ecuations. For example, with the values gave before, the matrix would be: 
			 * 
			 * 									a		b		c
			 * 								    a'		b'		c'
			 * 									a''		b''		c''
			 * * *  * * * * *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
			FormattedNumber[][] A = new FormattedNumber[Dimension][Dimension];

			for (int i = 0; i < system.length; i++) {
				System.out.println(" ──────────────────────────────────[ECUATION "+(i+1)+"]\n");
				for (int j = 0; j < system[0].length; j++) {
					if(j==system[i].length-1) { 
						System.out.print(" ==> Type the other side of the ecuation co-efficient: ");
						system[i][j]=new FormattedNumber(sc.next());
					}
					else {
						System.out.print(" ==> Type the co-efficient number ["+(j+1)+"]: ");
						A[i][j] = system[i][j] = new FormattedNumber(sc.next()); //Read both data to save resources
					}
				}System.out.println();
			}
			
			FormattedNumber determinant = mu.determinant(A);
			if (determinant.doubleValue() == 0) { 
				
				int RankSystem = mu.matrixRank(system);
				int RankA = mu.matrixRank(A);
				
				if (RankA == RankSystem) {
					Print.result("The Equation System has infinite solutions.\n");
				}else {
					Print.result("The Equation System has no solution"
					+ "or is not a "+Dimension+" variable ecuation system :(\n");
				}
			}
			else {
				FormattedNumber[] solutions = new FormattedNumber[Dimension]; //Array con las soluciones
				FormattedNumber[] tempCol; //Array con la columna que se va a sustituir
				
				for (int i = 0; i < solutions.length; i++) {
					tempCol = mu.getColumn(A,i); //Se copia la ultima columna del sistema
					
					for (int j = 0; j < A.length; j++)
						A[j][i] = system[j][system[0].length-1];
	
					solutions[i] = new FormattedNumber(mu.determinant(A).division(determinant));
					
					for (int j = 0; j < A.length; j++)
						A[j][i] = tempCol[j];
				}
				
				Print.result("The System is determinate compatible. The solutions are:");
				System.out.print(" (");
				for (int i = 0; i < solutions.length; i++) {
					if (i!=solutions.length-1) { System.out.print(solutions[i]+", "); }
					else System.out.print(solutions[i]+")\n");
				}
				Print.note("The solutions are written in the next format: If you have a system with 2 variables,"
						+ " the solution will be (x,y), if you have a 3 variables system, the solution will be " 
						+ "(x,y,z) and so on...\n");
			}
			
		}catch (InputMismatchException e) {
			sc.nextLine();
			Print.warning("Check your input: its not accepted.\n");
		}
	}
}