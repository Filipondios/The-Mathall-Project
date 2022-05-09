package AlgebraPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import FormatPackage.fraccion;
import java.io.IOException;

import GraphicsPackage.graphics;

public class algebraEcuaciones {

	Scanner sc = new Scanner(System.in);
	graphics Gr = new graphics();

	public void SecondGradeEquation() throws IOException, InterruptedException {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████"
				+ "███████████████████████████ SECOND GRADE EQUATIONS RESOLUTION ███████████████████████████████\n"
				+ "█████████████████████████████████████████████████████████████████████████████████████████████\\n");

			System.out.println("Type the equaton's value of the co-efficients a,b,c: ax^2 + bx + c =0");
			System.out.print("--> a = ");
			double a = sc.nextInt();
			System.out.print("--> b = ");
			double b = sc.nextInt();
			System.out.print("--> c = ");
			double c = sc.nextInt();

			System.out.println("\nYour second-grade equation is: " + a + "x^2 + " + b + "x + " + c + " = 0");
			double discriminante = Math.pow(b, 2) - 4 * a * c;

			if(discriminante<0) {System.out.println("There is no real solution to this equation.");}

			else {  
				double x1= -b+Math.sqrt(discriminante); int den=(int)(2*a);
				double x2= -b-Math.sqrt(discriminante);

				if(isInt(Math.sqrt(discriminante))){

					fraccion Solucion1 = new fraccion(x1,den);
					fraccion Solucion2 = new fraccion(x2,den);

					Solucion1.simplificarDouble(Solucion1);
					Solucion1.simplificarDouble(Solucion2);

					if(x1==x2){
						System.out.println("Equation with only one solution.\n");
						System.out.println("          |\nSolution  |x= "+Solucion1.toStringDouble());
						System.out.println("          |");
					}
					else{
						System.out.println("Equation with two solutions.\n");
						System.out.println("          |x1= "+Solucion1.toStringDouble()+"\nSolution|");
						System.out.println("          |x2= "+Solucion2.getnumeradorDouble());
					}
				}
				else{

					a=2*a;b=-b;
					System.out.println("Equation with two solutions.\n");

					if (b==0) {
						System.out.printf("          |x1= [sqrt(%.0f)]/[%.0f]\nSolutions|\n",discriminante,a);
						System.out.printf("          |x2= [-sqrt(%.0f)]/[%.0f]\n",discriminante,a);
					}else{
						System.out.printf("          |x1= [%.0f + sqrt(%.0f)]/[%.0f]\nSolutions|\n",b,discriminante,a);
						System.out.printf("          |x2= [%.0f - sqrt(%.0f)]/[%.0f]\n",b,discriminante,a);
					}
				}
				System.out.println("");
			}
		
		}catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}


	public void EquationSistems(){
		
		try {
			Gr.ClearConsole();

			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
				+ "█████████████████████████████ 2x2 OR 3x3 SYSTEMS RESOLUTION █████████████████████████████████\n"
				+ "█████████████████████████████████████████████████████████████████████████████████████████████\n");

			System.out.println("Type the number of variables and equations (2&2 or 3&3). If you type any other combination,"
			+"the solution won't be correct.");

			System.out.print("Variables: "); int coef = sc.nextInt(); 
			System.out.print("Equations: "); int equations = sc.nextInt();

			System.out.println();

			double matrix [][] = new double [equations][coef+1];
			readMatrix(matrix);

			System.out.println("Initial Augmented Matrix is : \n");
			PrintMatrix(matrix);
			System.out.println("");

			// Order of Matrix(n)
			int solvFlag = 0;

			// Performing Matrix transformation
			solvFlag = PerformOperation(matrix, matrix.length);

			if (solvFlag == 1) { solvFlag = TypeOfSolution(matrix, matrix.length, solvFlag); }

			// Printing Final Matrix
			System.out.println("Final Augmented Matrix is : \n");
			PrintMatrix(matrix);
			System.out.println("");

			// Printing Solutions(if exist)
			PrintResult(matrix, matrix.length, solvFlag);
			System.out.println();

		} catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
	
	// reduce matrix to reduced row echelon form
	static int PerformOperation(double matrix[][], int rows)	{
		int i, j, k = 0, c, solvFlag = 0;

		// Performing elementary operations
		for (i = 0; i < rows; i++) {
			if (matrix[i][i] == 0) { //First element of the first row cant be 0.
				c = 1;
				while ((i + c) < rows && matrix[i + c][i] == 0) { c++; }

				if ((i + c) == rows) {
					solvFlag = 1;
					break;
				}
				//Switching rows
				for (j = i, k = 0; k <= rows; k++) {
					double temp =matrix[j][k];
					matrix[j][k] = matrix[j+c][k];
					matrix[j+c][k] = temp;
				}
			}
			
			//reducing rows into row echelon form
			for (j = 0; j < rows; j++) {
				if (j != i) {
					double LCM = matrix[j][i] / matrix[i][i]; //LCM = Less Common Multiple
					for (k = 0; k <= rows; k++) { matrix[j][k] = matrix[j][k] - (matrix[i][k]) * LCM; }            
				}
			}
		}
		return solvFlag;
	}

	// To check whether infinite solutions
	// exists or no solution exists
	// solvFlag == 2 for infinite solution
	// solvFlag == 3 for No solution
	static int TypeOfSolution(double matrix[][], int rows, int solvFlag) {
		int i, j;
		double counter;

		solvFlag = 3;
		for (i = 0; i < rows; i++) {
			counter = 0;
			for (j = 0; j < rows; j++) { counter += matrix[i][j]; }
			if (counter == matrix[i][j]) { solvFlag = 2; }    
		}
		return solvFlag;
	}

	// Function to print the matrix
	public static boolean negativeLocatedInColumn(double [][] matrix, int column) {
		boolean negative = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][column] < 0) { negative=true;break;}
		}
		return negative;
	}

	public static boolean isInt(double number) {
		if (number - (int) number == 0) { return true; }
		else return false;
	}

	public static void PrintMatrix(double [][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				if (negativeLocatedInColumn(matrix,j) && matrix[i][j]>=0) { 
					if (isInt(matrix[i][j])) { System.out.print(" "+ (int) matrix[i][j] +"\t");}
					else System.out.print(" "+matrix[i][j]+"\t"); 
				}
				else { 
					if (isInt(matrix[i][j])) { System.out.print((int) matrix[i][j]+"\t");}
					else System.out.print(matrix[i][j]+"\t"); }
			}System.out.println();
		}		
	}

	// Function to print the desired result
	// if unique solutions exists, otherwise
	// prints no solution or infinite solutions
	// depending upon the input given.

	static void PrintResult(double a[][], int rows, int solvFlag){

		System.out.println("The final result, in order is : \n");

		if (solvFlag == 2) { System.out.println("Infinite Solutions Exists"); }
		else if (solvFlag == 3) { System.out.println("No Solution Exists"); }
		
		
		else for (int i = 0; i < rows; i++) {
			if (isInt(a[i][rows] / a[i][i])) { System.out.println("--| "+ (int) (a[i][rows] / a[i][i]));}
			else System.out.println("--| "+a[i][rows] / a[i][i]);
		}    
	}

	public void readMatrix(double [][]matrix) {
		@SuppressWarnings("resource") Scanner sc =new Scanner(System.in);

		for (int i = 0; i < matrix.length; i++) {
			System.out.println("-----------------------------------------ROW "+(i+1)+"-----------------------------------------------\n");
			for (int j = 0; j < matrix[i].length; j++) {
				if (j == matrix[i].length-1) { System.out.print("--> Type this row's single term: "); matrix[i][j]=sc.nextInt(); }
				else { System.out.print("--> Type the co-efficient ["+(j+1)+"]: "); matrix[i][j]=sc.nextInt(); }
			}System.out.println();
		}
	}
}