package algebraPackage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import filipondiosUtils.*;
import graphicsPackage.Graphics;
import menusPackage.MatrixMenu;
/**Class that contains different methods to make operations and transformations to matrices.
 * This loads a method that was chosen by the user in {@link MatrixMenu}. In case that the entry
 * in any method is not correct, the user will be returned to Mathall main menu {@link MatrixMenu}. 
 * @author Filipondios
 * @version 27.06.2022*/
public class AlgebraMatrix {
	Scanner sc = new Scanner(System.in);
	Graphics Gr = new Graphics();
	Matrix mt = new Matrix();
	
	/**Method that calculates the addition or the substraction of two matrices given by the user's inputs.*/
	public void MatrixAddSub() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"███████████████████████████████████ MATRIX ADDITION-DIFERENCE ███████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

			int m=0,n=0,option=69;
			System.out.println("Type the dimensions of both matrix:");
			System.out.print("Rows: ");m=sc.nextInt();
			System.out.print("Columns: ");n=sc.nextInt();
			
			System.out.println();

			System.out.println("\t\t\tTYPE THE ELEMENTS OF THE FIRST MATRIX:\n");
			FormattedNumber[][] m1 = new FormattedNumber[m][n];
			mt.readMatrix(m1);

			System.out.println("\n\t\t\tTYPE THE ELEMENTS OF THE SECOND MATRIX:\n");
			FormattedNumber[][] m2 = new FormattedNumber[m][n];
			mt.readMatrix(m2);

			System.out.println("\nChoose the operation to do [0/1]");
			System.out.println("#0- Addition of Matrix1 and Matrix2");
			System.out.println("#1- Diference between Matrix2 and Matrix1 [Matrix2-Matrix1]");option=sc.nextInt();

			while (option!=0 && option!=1){
				System.out.println("\nNot valid input: Type 0 o 1.");
				System.out.println("\nChoose the operation to do [0/1]");
				System.out.println("#0- Addition of Matrix1 and Matrix2.");
				System.out.println("#1- Diference between Matrix1 and Matrix2 (Matrix1-Matrix2).");option=sc.nextInt();
			}
			
			if (option==0) {
				for (int i = 0; i < m; i++)
					for (int j = 0; j <n; j++)
						m1[i][j]= m1[i][j].add(m2[i][j]);			
			}
			else if(option==1) {
				for (int i = 0; i < m; i++)
					for (int j = 0; j <n; j++)
						m1[i][j]= m1[i][j].substract(m2[i][j]);
			}
			
			System.out.println("\nThe final matrix is :");
			mt.printMatrix(m1);
			System.out.println("");
		
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
	
	/**Method that calculates the product of two matrices given by the user's inputs.*/
	public void MatrixProduct() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"████████████████████████████████████████ MATRIX PRODUCT █████████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");
			System.out.println();

			int F1,C1,F2,C2;
			System.out.println("¿What dimension do you want for the first matrix?.");
			System.out.print("Rows: ");F1=sc.nextInt();
			System.out.print("Columns: ");C1=sc.nextInt();

			System.out.println("¿What dimension do you want for the first matrix?.");
			System.out.print("Rows: ");F2=sc.nextInt();
			System.out.print("Columns: ");C2=sc.nextInt();

			while((F1 <= 0 || C1 <= 0)||(F2 <= 0 || C2 <= 0)||(C1 != F2)) {
				if (F1<=0 || C1<=0) {
					System.out.println("Type a correct number of rows and colums for the first matrix:");
					System.out.print("Rows: ");F1=sc.nextInt();
					System.out.print("Columns: ");C1=sc.nextInt();
				}
				if (F2<=0 || C2<=0) {
					System.out.println("Type a correct number of rows and colums for the second matrix:");
					System.out.print("Rows: ");F2=sc.nextInt();
					System.out.print("Columns: ");C2=sc.nextInt();
				}
				if ((C1!=F2)) {
					System.out.println("The number of columns of the first matrix and the number of rows of the second can't be different.");
					System.out.println("Type a valid number of rows (for the second) and columns (for the first):");
					System.out.print("Rows: ");F2=sc.nextInt();
					System.out.print("Columns: ");C1=sc.nextInt();
				}
			}

			FormattedNumber[][] matrix = new FormattedNumber[F1][C1]; 
			FormattedNumber[][] matrix2 = new FormattedNumber[F2][C2]; 

			System.out.println("\nFormation of the first matrix N for the operation N*M\n");
			mt.readMatrix(matrix);

			System.out.println("\nFormation of the second matrix M for the operation N*M\n");
			mt.readMatrix(matrix2);

			System.out.println("The first argumented matrix (N) is:");
			mt.printMatrix(matrix);
			System.out.println();

			System.out.println("The second argumented matrix (M) is:");
			mt.printMatrix(matrix2);
			System.out.println();

			matrix = mt.matrixProduct(matrix,matrix2);

			System.out.println("The resultant matrix of the product between N and M (N·M):");
			mt.printMatrix(matrix);
			System.out.println();
			
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}

	/**Method that calculates a determinate power of a matrix given by the user's input.*/
	public void MatrixPower() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"████████████████████████████████████████  MATRIX POWER ██████████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

			System.out.print("Type Rows or Columns (Rows=Columns): ");int longitude=sc.nextInt();
			System.out.print("Type the number of the power: ");int power=sc.nextInt();
			System.out.println();

			FormattedNumber matrix [][]=new FormattedNumber [longitude][longitude];
			FormattedNumber matrixIni[][]=matrix;
			
			mt.readMatrix(matrix);

			System.out.println("\nThe initial argumented matrix is:");
			mt.printMatrix(matrix);

			System.out.println("\nThe original matrix powered by "+power+" is: ");
			for (int i=0; i<power-1; i++)
				matrix = mt.matrixProduct(matrix,matrixIni);

			mt.printMatrix(matrix);
			System.out.println();
		
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}

	/**Method that calculates the determinant of a matrix given by the user's input.*/
	public void MatrixDeterminant() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"██████████████████████████████████████ MATRIX DETERMINANT ███████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

			System.out.println("|WARNING|: When calculating determinants of a dimension bigger than 20 you may experience slowness in your computer.");
			System.out.print("Type the dimension of the matrix [maximum recommended :20] :");
			int dimension = sc.nextInt();

			while (dimension<=0) {
				System.out.println("\nThe matrix dimension can't be less than 0 or bigger than 20.");
				System.out.printf("Type the dimension of the matrix [maximum recommended :20] :");
				dimension = sc.nextInt();
			}

			FormattedNumber matrix[][] = new FormattedNumber[dimension][dimension];
			System.out.print("");
			System.out.printf("\nType the elements of the matrix:\n\n");
			mt.readMatrix(matrix);

			System.out.printf("\nThis is your argumented matrix of dimension "+dimension+":\n");
			mt.printMatrix(matrix);

			System.out.println("\nThe determinant of the matrix is: "+ mt.determinant(matrix));
			System.out.println();
		
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}

	/**Method that calculates the range of a matrix given by the user's input.*/
	public void MatrixRank() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"█████████████████████████████████████████ MATRIX RANK ███████████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

			int F=0,C=0;
			System.out.println("Type the dimensions of the matrix:");
			System.out.print("Rows: ");F=sc.nextInt();
			System.out.print("Columns: ");C=sc.nextInt();

			while (F<=0 || C<=0){
				System.out.println("Type the dimensions of the matrix:");
				System.out.print("Rows: ");F=sc.nextInt();
				System.out.print("Columns: ");C=sc.nextInt();
			}

			FormattedNumber[][] matrix=new FormattedNumber[F][C];
			System.out.print("\n");
			mt.readMatrix(matrix);

			System.out.println("Your argumented matrix is:");
			mt.printMatrix(matrix);
			System.out.println("\nThe rank of the given matrix is: "+mt.matrixRank(matrix)+"\n");
					
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
}
