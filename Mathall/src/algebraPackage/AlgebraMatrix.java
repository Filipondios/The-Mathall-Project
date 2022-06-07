package algebraPackage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import filipondiosUtils.*;
import graphicsPackage.Graphics;

public class AlgebraMatrix {
	Scanner sc = new Scanner(System.in);
	Graphics Gr = new Graphics();
	Matrix mt = new Matrix();
	
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

	public void MatrixRange() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████\n"
			+"█████████████████████████████████████████ MATRIX RANGE ██████████████████████████████████████\n"
			+"█████████████████████████████████████████████████████████████████████████████████████████████\n");

			int Dimension,Ran=1;
			System.out.print("¿What dimension do you want for your matrix? (2x2 o 3x3):");Dimension= sc.nextInt();

			while (Dimension!=2 && Dimension!=3){
				System.out.println("The dimension of the matrix can't be different of 2 or 3.");
				System.out.print("¿What dimension do you want for your matrix? (2x2 o 3x3):");Dimension= sc.nextInt();
				System.out.println();
			}

			FormattedNumber[][] matrix=new FormattedNumber[Dimension][Dimension];
			System.out.print("\n");
			mt.readMatrix(matrix);

			System.out.println("Your argumented matrix is:");
			mt.printMatrix(matrix);
			System.out.println();


			if (Dimension==2) {
				if (mt.determinant(matrix).doubleValue()==0) {
					Ran=2;
				}else Ran=1;
				System.out.println("The range of your matrix is: "+Ran);
			}

			if (Dimension==3) {
				if (mt.determinant(matrix).doubleValue()!=0) {
					Ran=3;
					System.out.println("The range of your matrix is: "+Ran);
				}
				if (mt.determinant(matrix).doubleValue()==0) {

					FormattedNumber[]attached=new FormattedNumber[6];
					attached[0]=attached[0].productOf(matrix[0][0].product(matrix[1][1]), matrix[0][1].product(matrix[1][0]));
					attached[1]=attached[1].productOf(matrix[0][0].product(matrix[1][2]), matrix[0][2].product(matrix[1][0]));
					attached[2]=attached[2].productOf(matrix[0][1].product(matrix[1][2]), matrix[1][1].product(matrix[0][2]));
					attached[3]=attached[3].productOf(matrix[1][0].product(matrix[2][1]), matrix[1][1].product(matrix[2][0]));
					attached[4]=attached[4].productOf(matrix[1][0].product(matrix[2][2]), matrix[1][2].product(matrix[2][0]));
					attached[5]=attached[5].productOf(matrix[1][1].product(matrix[2][2]), matrix[1][2].product(matrix[2][1]));
					
					for (int i = 0; i<attached.length; i++) {
						if (attached[i].doubleValue()!=0) {
							Ran=2;
						}else System.out.println("The range of your matrix is: "+Ran);
					}
				}   
			}
			System.out.println();
		
		}catch (InputMismatchException | NumberFormatException e) {
			sc.nextLine();
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
}
