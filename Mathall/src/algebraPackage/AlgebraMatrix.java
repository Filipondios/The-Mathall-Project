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
 * @version 27.06.2022*/
public class AlgebraMatrix {
	Scanner sc = new Scanner(System.in);
	Graphics Gr = new Graphics();
	MatrixUtils mt = new MatrixUtils();
	
	/**Method that calculates the addition or the substraction of two matrices given by the user's inputs.*/
	public void MatrixAddSub() {
		Gr.ClearConsole();
		try {
			System.out.println(" █████████████████████████████████████████████████████████████████████████████████████████████\n"
			+" ███████████████████████████████████ MATRIX ADDITION-DIFERENCE ███████████████████████████████\n"
			+" █████████████████████████████████████████████████████████████████████████████████████████████\n");

			System.out.println(Gr.yellow+" * "+Gr.green+"NOTE: "+Gr.white+"To make an addition or difference of two"
					+" matrices, you have to make a input with two\n"+Gr.yellow+" * "+Gr.white+"matrices with dimensions mxn"
					+" and mxn "+Gr.red+"("+Gr.blue+"Dimension "+Gr.red+"= "+Gr.blue+"Rows"+Gr.red+"x"+Gr.blue+"Columns"+Gr.red+")"+Gr.white+".\n");

			int m=0,n=0,option=69;
			System.out.println(" Type the dimensions of both matrix:");
			System.out.print(" Rows: ");m=sc.nextInt();
			System.out.print(" Columns: ");n=sc.nextInt();
			
			System.out.println();

			System.out.println("\t\t\t TYPE THE ELEMENTS OF THE FIRST MATRIX:\n");
			FormattedNumber[][] m1 = new FormattedNumber[m][n];
			mt.readMatrix(m1);

			System.out.println("\n\t\t\t TYPE THE ELEMENTS OF THE SECOND MATRIX:\n");
			FormattedNumber[][] m2 = new FormattedNumber[m][n];
			mt.readMatrix(m2);

			System.out.println("\n Choose the operation to do [0/1]");
			System.out.println(" #0- Addition of Matrix1 and Matrix2");
			System.out.println(" #1- Diference between Matrix2 and Matrix1 [Matrix2-Matrix1]");option=sc.nextInt();

			while (option!=0 && option!=1){
				System.out.println("\n Not valid input: Type 0 o 1.");
				System.out.println("\n Choose the operation to do [0/1]");
				System.out.println(" #0- Addition of Matrix1 and Matrix2.");
				System.out.println(" #1- Diference between Matrix1 and Matrix2 (Matrix1-Matrix2).");option=sc.nextInt();
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
			
			System.out.println(Gr.yellow+"\n * "+Gr.white+"The final matrix is :");
			mt.printMatrix(m1);
			System.out.println("");
		
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
	
	/**Method that calculates the product of two matrices given by the user's inputs.*/
	public void MatrixProduct() {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"████████████████████████████████████████ MATRIX PRODUCT █████████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

			System.out.println(Gr.yellow+" * "+Gr.green+"NOTE: "+Gr.white+"To make a product of two matrices,"
					+" you have to make a input with two matrices\n"+Gr.yellow+" * "+Gr.white+"with dimensions axb"
					+" and bxc "+Gr.red+"("+Gr.blue+"Dimension "+Gr.red+"= "+Gr.blue+"Rows"+Gr.red+"x"+Gr.blue+"Columns"+Gr.red+")"+Gr.white+".\n");

			int F1,C1,F2,C2;
			System.out.println(" ¿What dimension do you want for the first matrix?.");
			System.out.print(" Rows: ");F1=sc.nextInt();
			System.out.print(" Columns: ");C1=sc.nextInt();

			System.out.println(" ¿What dimension do you want for the first matrix?.");
			System.out.print(" Rows: ");F2=sc.nextInt();
			System.out.print(" Columns: ");C2=sc.nextInt();

			while((F1 <= 0 || C1 <= 0 ||F2 <= 0 || C2 <= 0)||(C1 != F2)) {
				if (F1<=0 || C1<=0) {
					System.out.println("\n Type a correct number of rows and colums for the first matrix:");
					System.out.print(" Rows: ");F1=sc.nextInt();
					System.out.print(" Columns: ");C1=sc.nextInt();
				}
				if (F2<=0 || C2<=0) {
					System.out.println("\n Type a correct number of rows and colums for the second matrix:");
					System.out.print(" Rows: ");F2=sc.nextInt();
					System.out.print(" Columns: ");C2=sc.nextInt();
				}
				if ((C1!=F2)) {
					System.out.println("\n The number of columns of the first matrix and the number of rows of the second can't be different.");
					System.out.println(" Type a valid number of rows (for the second) and columns (for the first):");
					System.out.print(" Rows: ");F2=sc.nextInt();
					System.out.print(" Columns: ");C1=sc.nextInt();
				}
			}

			FormattedNumber[][] matrix = new FormattedNumber[F1][C1]; 
			FormattedNumber[][] matrix2 = new FormattedNumber[F2][C2]; 

			System.out.println("\n Formation of the first matrix N for the operation N*M\n");
			mt.readMatrix(matrix);

			System.out.println("\n Formation of the second matrix M for the operation N*M\n");
			mt.readMatrix(matrix2);

			System.out.println(Gr.yellow+"\n * "+Gr.white+"The first argumented matrix (N) is:");
			mt.printMatrix(matrix);
			System.out.println();

			System.out.println(Gr.yellow+"\n * "+Gr.white+"The second argumented matrix (M) is:");
			mt.printMatrix(matrix2);
			System.out.println();

			matrix = mt.matrixProduct(matrix,matrix2);

			System.out.println(Gr.yellow+"\n * "+Gr.white+"The resultant matrix of the product between N and M (N·M):");
			mt.printMatrix(matrix);
			System.out.println();
			
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}

	/**Method that calculates a determinate power of a matrix given by the user's input.*/
	public void MatrixPower() {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"████████████████████████████████████████  MATRIX POWER ██████████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

			System.out.println(Gr.yellow+" * "+Gr.green+"NOTE: "+Gr.white+"To make the power of a matrix,"
			+"  you have to make a input with any square matrix\n"+Gr.yellow+" * "+Gr.white+"with dimension nxn."
			+" "+Gr.red+"("+Gr.blue+"Dimension "+Gr.red+"= "+Gr.blue+"Rows"+Gr.red+"x"+Gr.blue+"Columns"+Gr.red+")"+Gr.white+".\n");

			System.out.print(" Type Rows or Columns (Rows=Columns): ");int longitude=sc.nextInt();
			System.out.print(" Type the number of the power: ");int power=sc.nextInt();
			System.out.println();

			FormattedNumber matrix [][]=new FormattedNumber [longitude][longitude];
			FormattedNumber matrixIni[][]=matrix;
			
			mt.readMatrix(matrix);

			System.out.println(Gr.yellow+"\n * "+Gr.white+"The initial argumented matrix is:");
			mt.printMatrix(matrix);

			System.out.println(Gr.yellow+"\n * "+Gr.white+"The original matrix powered by "+power+" is: ");
			for (int i=0; i<power-1; i++)
				matrix = mt.matrixProduct(matrix,matrixIni);

			mt.printMatrix(matrix);
			System.out.println();
		
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}

	/**Method that calculates the determinant of a matrix given by the user's input.*/
	public void MatrixDeterminant() {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"██████████████████████████████████████ MATRIX DETERMINANT ███████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

			System.out.println(Gr.yellow+" * "+Gr.green+"NOTE: "+Gr.white+"To make the power of a matrix,"
			+"  you have to make a input with any square matrix\n"+Gr.yellow+" * "+Gr.white+"with dimension nxn."
			+" "+Gr.red+"("+Gr.blue+"Dimension "+Gr.red+"= "+Gr.blue+"Rows"+Gr.red+"x"+Gr.blue+"Columns"+Gr.red+")"+Gr.white+".\n");

			System.out.println(Gr.yellow+" * "+Gr.red+"|WARNING|"+Gr.white+": When calculating determinants of a dimension bigger than 20 you may" 
			+"experience\n"+Gr.yellow+" * "+Gr.white+"slowness in your computer.");
			
			System.out.print("\n Type the dimension of the matrix [maximum recommended: 20] :");
			int dimension = sc.nextInt();

			while (dimension<=0) {
				System.out.println("\n The matrix dimension can't be less or equal to 0.");
				System.out.printf(" Type the dimension of the matrix [maximum recommended :20] : ");
				dimension = sc.nextInt();
			}

			FormattedNumber matrix[][] = new FormattedNumber[dimension][dimension];
			System.out.print("");
			System.out.printf("\n Type the elements of the matrix:\n\n");
			mt.readMatrix(matrix);

			System.out.printf(Gr.yellow+"\n * "+Gr.white+"This is your argumented matrix of dimension "+dimension+":\n");
			mt.printMatrix(matrix);

			System.out.println(Gr.yellow+"\n * "+Gr.white+"The determinant of the matrix is: "+ mt.determinant(matrix));
			System.out.println();
		
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}

	/**Method that calculates the range of a matrix given by the user's input.*/
	public void MatrixRank() {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"█████████████████████████████████████████ MATRIX RANK ███████████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

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
			System.out.print("\n");
			mt.readMatrix(matrix);

			System.out.println(Gr.yellow+"\n * "+Gr.white+"Your argumented matrix is:");
			mt.printMatrix(matrix);
			System.out.println(Gr.yellow+"\n * "+Gr.white+"The rank of the given matrix is: "+mt.matrixRank(matrix)+"\n");
					
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
	
	/**Method that calculates the traspose of a matrix given by the user's input.*/
	public void TransposeMatrix() {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"██████████████████████████████████████ TRANSPOSE MATRIX █████████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

			int F=0,C=0;
			System.out.println(" Type the dimensions of the matrix:");
			System.out.print(" Rows: ");F=sc.nextInt();
			System.out.print(" Columns: ");C=sc.nextInt();

			while (F<=0 || C<=0){
				System.out.println(" Type the dimensions of the matrix:");
				System.out.print(" Rows: ");F=sc.nextInt();
				System.out.print(" Columns: ");C=sc.nextInt();
			}

			FormattedNumber[][] matrix=new FormattedNumber[F][C];
			System.out.print("\n");
			mt.readMatrix(matrix);

			System.out.println(Gr.yellow+"\n * "+Gr.white+"Your argumented matrix is:");
			mt.printMatrix(matrix);
			
			System.out.println(Gr.yellow+"\n * "+Gr.white+"The transpose of the original matrix is:");
			FormattedNumber[][] transpose  = mt.transposeOf(matrix);
			mt.printMatrix(transpose);
			System.out.println();
			
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
	
	/**Method that calculates the row echelon form of a matrix given by the user's input.*/
	public void RowEchelon() {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"████████████████████████████████ ROW ECHELON FORM OF A MATRIX ███████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

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
			System.out.print("\n");
			mt.readMatrix(matrix);

			System.out.println(Gr.yellow+"\n * "+Gr.white+"Your argumented matrix is:");
			mt.printMatrix(matrix);
			
			System.out.println(Gr.yellow+"\n * "+Gr.white+"The row echelon form of the original matrix is:");
			mt.gaussMethod(matrix);
			mt.printMatrix(matrix);
			System.out.println();
			
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
	
	/**Method that calculates the inverse of a matrix given by the user's input.*/
	public void InverseMatrix() {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"█████████████████████████████████████ INVERSE OF A MATRIX ███████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

			System.out.println(Gr.yellow+" * "+Gr.green+"NOTE: "+Gr.white+"To calculate the inverse of a matrix,"
			+"  you have to make a input with any square matrix\n"+Gr.yellow+" * "+Gr.white+"with dimension nxn."
			+" "+Gr.red+"("+Gr.blue+"Dimension "+Gr.red+"= "+Gr.blue+"Rows"+Gr.red+"x"+Gr.blue+"Columns"+Gr.red+")"+Gr.white+".\n");

			System.out.println(Gr.yellow+" * "+Gr.red+"|WARNING|"+Gr.white+": When the matrix dimension is bigger than 20 you may" 
			+"experience\n"+Gr.yellow+" * "+Gr.white+"slowness in your computer.\n");

			int D=0;
			System.out.print(" Type the dimension of the matrix: "); D=sc.nextInt();

			while (D<=1){
				System.out.println("\n The dimension of the matrix can't be 1 or less.");
				System.out.print(" Type the dimension of the matrix: "); D=sc.nextInt();
			}

			FormattedNumber[][] matrix=new FormattedNumber[D][D];
			System.out.print("\n");
			mt.readMatrix(matrix);

			System.out.println(Gr.yellow+"\n * "+Gr.white+"Your argumented matrix is:");
			mt.printMatrix(matrix);
			
			try {
				FormattedNumber[][] inverse = mt.inverseMatrixOf(matrix);
				System.out.println(Gr.yellow+"\n * "+Gr.white+"The inverse of the original matrix is:");
				mt.printMatrix(inverse);
			} catch (Exception e) {
				System.out.println(Gr.yellow+"\n * "+Gr.white+"There is no inverse for the matrix :(");
			}
			System.out.println();
			
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
}
