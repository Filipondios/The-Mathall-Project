package algebraPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import filipondiosUtils.*;
import graphicsPackage.Graphics;
import menusPackage.MatrixMenu;
/**Class that contains different methods to make operations and transformations to matrices.
 * This loads a method that was chosen by the user in {@link MatrixMenu}. In case that the entry
 * in any method is not correct, the user will be returned to Mathall main menu {@link MatrixMenu}. 
 * @author Filipondios
 * @version 18.10.2022*/
public class AlgebraMatrix {
	Scanner sc = new Scanner(System.in);
	Graphics Gr = new Graphics();
	MatrixUtils mt = new MatrixUtils();
	
	/**Method that calculates the addition or the substraction of two matrices given by the user's inputs.*/
	public void MatrixAddSub() {
		try {
		    Print.note("To make an addition or difference of two matrices, you have to make a input with two"
		            + "matrices with dimensions mxn and mxn (Dimension = RowsxColumns).");
		    
			int m = 0, n = 0, option = 69;
			System.out.println("\n Type the dimensions of both matrix:");
			System.out.print(" Rows: "); m=sc.nextInt();
			System.out.print(" Columns: "); n=sc.nextInt();
			
			System.out.println("\n\t\t\t TYPE THE ELEMENTS OF THE FIRST MATRIX:\n");
			FormattedNumber[][] m1 = new FormattedNumber[m][n];
			mt.readMatrix(m1);

			System.out.println("\n\t\t\t TYPE THE ELEMENTS OF THE SECOND MATRIX:\n");
			FormattedNumber[][] m2 = new FormattedNumber[m][n];
			mt.readMatrix(m2);

			Print.menu("Choose the operation to do [0/1]",
			        "Addition of Matrix1 and Matrix2",
			        "Diference between Matrix2 and Matrix1 [Matrix2-Matrix1]");
			Print.prompt();
			option = sc.nextInt();

			while (option!=0 && option!=1){
			    Print.warning("Not valid input: Type 0 o 1.\n");
			    
			    Print.menu("Choose the operation to do [0/1]",
	                    "Addition of Matrix1 and Matrix2",
	                    "Diference between Matrix2 and Matrix1 [Matrix2-Matrix1]");
	            Print.prompt();
	            option = sc.nextInt();
			}
			
			if (option == 0) {
				for (int i = 0; i < m; i++)
					for (int j = 0; j <n; j++)
						m1[i][j]= m1[i][j].add(m2[i][j]);			
			}
			else if(option == 1) {
				for (int i = 0; i < m; i++)
					for (int j = 0; j <n; j++)
						m1[i][j]= m1[i][j].substract(m2[i][j]);
			}
			
			Print.result("The final matrix is:");
			mt.printMatrix(m1);
			System.out.println();
		
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			Print.warning("Check your input: its not accepted.\n");
		}
	}
	
	/**Method that calculates the product of two matrices given by the user's inputs.*/
	public void MatrixProduct() {
		try {
			Print.note("To make a product of two matrices, you have to make a input with two matrices with dimensions axb"
					+ "and bxc (Dimension=RowsxColumns)");
			
			int F1, C1, F2, C2;
			System.out.println("\n ¿What dimension do you want for the first matrix?.");
			System.out.print(" Rows: "); F1=sc.nextInt();
			System.out.print(" Columns: "); C1=sc.nextInt();

			System.out.println("\n ¿What dimension do you want for the first matrix?.");
			System.out.print(" Rows: "); F2=sc.nextInt();
			System.out.print(" Columns: "); C2=sc.nextInt();

			while((F1 <= 0 || C1 <= 0 ||F2 <= 0 || C2 <= 0)||(C1 != F2)) {
					Print.warning("Wrong matrices input. Check your input and type them again.");
					System.out.println("\n ¿What dimension do you want for the first matrix?.");
					System.out.print(" Rows: ");F1=sc.nextInt();
					System.out.print(" Columns: ");C1=sc.nextInt();

					System.out.println("\n ¿What dimension do you want for the first matrix?.");
					System.out.print(" Rows: ");F2=sc.nextInt();
					System.out.print(" Columns: ");C2=sc.nextInt();
			}

			FormattedNumber[][] matrix = new FormattedNumber[F1][C1]; 
			FormattedNumber[][] matrix2 = new FormattedNumber[F2][C2]; 

			System.out.println("\n Formation of the first matrix N for the operation N*M\n");
			mt.readMatrix(matrix);

			System.out.println("\n Formation of the second matrix M for the operation N*M\n");
			mt.readMatrix(matrix2);

			Print.note("The first argumented matrix (N) is:");
			mt.printMatrix(matrix);

			Print.note("The second argumented matrix (M) is:");
			mt.printMatrix(matrix2);

			matrix = mt.matrixProduct(matrix,matrix2);

			Print.result("The resultant matrix of the product between N and M (N·M):");
			mt.printMatrix(matrix);
			System.out.println();
			
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			Print.warning("Check your input: its not accepted.\n");
		}
	}

	/**Method that calculates a determinate power of a matrix given by the user's input.*/
	public void MatrixPower() {
		try {
			Print.note("To make the power of a matrix, you have to make a input with any square matrix"
					+ "with dimension nxn. (Dimension=RowsxColumns)\n");
			
			System.out.print(" Type Rows or Columns (Rows=Columns): "); int longitude=sc.nextInt();
			System.out.print(" Type the number of the power: "); int power=sc.nextInt();
			System.out.println();

			FormattedNumber matrix [][] = new FormattedNumber [longitude][longitude];
			FormattedNumber matrixIni[][] = matrix;
			
			mt.readMatrix(matrix);

			Print.note("The initial argumented matrix is:");
			mt.printMatrix(matrix);

			Print.result("The original matrix powered by" + power + " is:");
			for (int i=0; i<power-1; i++)
				matrix = mt.matrixProduct(matrix,matrixIni);

			mt.printMatrix(matrix);
			System.out.println();
		
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			Print.warning("Check your input: its not accepted.\n");
		}
	}

	/**Method that calculates the determinant of a matrix given by the user's input.*/
	public void MatrixDeterminant() {
		try {
			Print.note("To make the power of a matrix, you have to make a input with any square matrix"
					+ "with dimension nxn. (Dimension=RowsxColumns)");
			
			Print.warning("When calculating determinants of big matrices, depending on your computer"
					+ "power, your may slowness in your computer.\n");
						
			System.out.print(" Type the dimension of the matrix : ");
			int dimension = sc.nextInt();

			while (dimension<=0) {
				System.out.println("\n The matrix dimension can't be less or equal to 0.");
				System.out.printf(" Type the dimension of the matrix : ");
				dimension = sc.nextInt();
			}

			FormattedNumber matrix[][] = new FormattedNumber[dimension][dimension];
			System.out.println("\n Type the elements of the matrix:\n");
			mt.readMatrix(matrix);

			Print.note("Your argumented matrix of dimension "+dimension+":");
			mt.printMatrix(matrix);

			Print.result("The determinant of the matrix is: "+mt.determinant(matrix));
			System.out.println();
		
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			Print.warning("Check your input: its not accepted.\n");
		}
	}

	/**Method that calculates the range of a matrix given by the user's input.*/
	public void MatrixRank() {
		try {
			Print.note("There are no restrictions for any matrix when calculating its rank.\n");
			
			int F=0,C=0;
			System.out.println(" Type the dimensions of the matrix:");
			System.out.print(" Rows: ");F=sc.nextInt();
			System.out.print(" Columns: ");C=sc.nextInt();

			while (F<=1 || C<=1){
				System.out.println(" The rows or the columns of the matrix can't be 1 or less.");
				System.out.println(" Type the dimensions of the matrix:");
				System.out.print(" Rows: ");F=sc.nextInt();
				System.out.print(" Columns: ");C=sc.nextInt();
			}

			FormattedNumber[][] matrix=new FormattedNumber[F][C];
			System.out.println();
			mt.readMatrix(matrix);

			Print.note("Your argumented matrix is:");
			mt.printMatrix(matrix);
			Print.result("The rank of the given matrix is: "+ mt.matrixRank(matrix) + "\n");
					
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			Print.warning("Check your input: its not accepted.\n");
		}
	}
	
	/**Method that calculates the traspose of a matrix given by the user's input.*/
	public void TransposeMatrix() {
		try {
			Print.note("There are no restrictions for any matrix when calculating its rank.\n");
			
			int F=0,C=0;
			System.out.println(" Type the dimensions of the matrix:");
			System.out.print(" Rows: "); F=sc.nextInt();
			System.out.print(" Columns: "); C=sc.nextInt();

			while (F<=0 || C<=0){
				System.out.println(" Type the dimensions of the matrix:");
				System.out.print(" Rows: ");F=sc.nextInt();
				System.out.print(" Columns: ");C=sc.nextInt();
			}

			FormattedNumber[][] matrix=new FormattedNumber[F][C];
			System.out.println();
			mt.readMatrix(matrix);

			Print.note("Your argumented matrix is:");
			mt.printMatrix(matrix);
			
			Print.result("The transpose of the original matrix is:");
			FormattedNumber[][] transpose  = mt.transposeOf(matrix);
			mt.printMatrix(transpose);
			System.out.println();
			
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			Print.warning("Check your input: its not accepted.\n");
		}
	}
	
	/**Method that calculates the row echelon form of a matrix given by the user's input.*/
	public void RowEchelon() {
		try {
			Print.note("There are no restrictions for any matrix when calculating its rank.\n");
			
			int F=0,C=0;
			System.out.println(" Type the dimensions of the matrix:");
			System.out.print(" Rows: ");F=sc.nextInt();
			System.out.print(" Columns: ");C=sc.nextInt();

			while (F<=1 || C<=1){
				System.out.println(" The rows or the columns of the matrix can't be 1 or less.");
				System.out.println(" Type the dimensions of the matrix:");
				System.out.print(" Rows: ");F=sc.nextInt();
				System.out.print(" Columns: ");C=sc.nextInt();
			}

			FormattedNumber[][] matrix = new FormattedNumber[F][C];
			System.out.println();
			mt.readMatrix(matrix);

			Print.note("Your argumented matrix is:");
			mt.printMatrix(matrix);
			
			Print.result("The row echelon form of the original matrix is:");
			mt.gaussMethod(matrix);
			mt.printMatrix(matrix);
			System.out.println();
			
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			Print.warning("Check your input: its not accepted.\n");
		}
	}
	
	/**Method that calculates the inverse of a matrix given by the user's input.*/
	public void InverseMatrix() {
		try {
			Print.note("To make the power of a matrix, you have to make a input with any square matrix"
					+ "with dimension nxn. (Dimension=RowsxColumns)");
			
			Print.warning("When calculating the inverse of big matrices, depending on your computer"
					+ "power, your may slowness in your computer.\n");

			int D = 0;
			System.out.print(" Type the dimension of the matrix: "); D = sc.nextInt();

			while (D<=1){
				System.out.println("\n The dimension of the matrix can't be 1 or less.");
				System.out.print(" Type the dimension of the matrix: "); D = sc.nextInt();
			}

			FormattedNumber[][] matrix = new FormattedNumber[D][D];
			System.out.println();
			mt.readMatrix(matrix);

			Print.note("Your argumented matrix is:");
			mt.printMatrix(matrix);
			
			try {
				FormattedNumber[][] inverse = mt.inverseMatrixOf(matrix);
				Print.result("The inverse of the original matrix is:");
				mt.printMatrix(inverse);
			} catch (Exception e) {
				Print.result(e.getMessage());
			}
			
			System.out.println();
			
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			Print.warning("Check your input: its not accepted.\n");
		}
	}
}
