package AlgebraPackage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import GraphicsPackage.graphics;

public class algebraMatrices {
	Scanner sc =new Scanner(System.in);
	graphics Gr=new graphics();
	
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

			int matrix1 [][]=new int [m][n];
			int matrix2 [][]=new int [m][n];

			System.out.println("Type the elements of the first matrix:\n");
			readMatrix(matrix1);

			System.out.println("Type the elements of the second matrix:\n");
			readMatrix(matrix2);

			System.out.println("\nChoose the operation to do [0/1]");
			System.out.println("#0- Addition of Matrix1 and Matrix2");
			System.out.println("#1- Diference between Matrix2 and Matrix1 [Matrix2-Matrix1]");option=sc.nextInt();

			while (option!=0 && option!=1){
				System.out.println("\nNot valid input: Type 0 o 1.");
				System.out.println("\nChoose the operation to do [0/1]");
				System.out.println("#0- Addition of Matrix1 and Matrix2");
				System.out.println("#1- Diference between Matrix2 and Matrix1 [Matrix2-Matrix1]");option=sc.nextInt();
			}

			if (option==0) {
				int Resultant[][]=new int [m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j <n; j++) {
						Resultant[i][j]=matrix1[i][j]+matrix2[i][j];
					}
				}

				System.out.println("The final matrix is :");
				for (int i=0; i<m; i++) {
					for (int j=0; j<n; j++) {
						System.out.print(Resultant[i][j]+"    ");
					}System.out.print("\n");
				}
			}
			if(option==1) {
				int Resultant[][]=new int [m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j <n; j++) {
						Resultant[i][j]=matrix1[i][j]-matrix2[i][j];
					}
				}

				System.out.println("The final matrix is :");
				showMatrix(Resultant);
				System.out.println("");
			}
		
		}catch (InputMismatchException e) {
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

			//CONTROL

			while((F1 <= 0 || C1 <= 0)||(F2 <= 0 || C2 <= 0)||(C1 != F2)) {
				if (F1<=0 || C1<=0) {
					System.out.println("Type a correct number of rows and colums for the first matrix:");
					System.out.print("Rows: ");F1=sc.nextInt();
					System.out.print("Columns: ");C1=sc.nextInt();
				}
				if (F2<=0 || C2<=0) {
					System.out.println("Type a correct number of rows and colums for the first matrix:");
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

			int[][] matrix=new int[F1][C1]; //FIRST matrix
			int[][] matrix2=new int[F2][C2]; //SECOND matrix
			int[][] matrixRes=new int[F1][C2]; //RESULTANT matrix

			//MATRIX SET-UP (MATRIX POSITION READING)

			System.out.println("\nFormation of the first matrix N for the operation N*M\n");
			readMatrix(matrix);

			System.out.println("\nFormation of the second matrix M for the operation N*M\n");
			readMatrix(matrix2);

			System.out.println("The first argumented matrix (N) is:");
			showMatrix(matrix);
			System.out.println();

			System.out.println("The second argumented matrix (M) is:");
			showMatrix(matrix2);
			System.out.println();

			matrixRes=product(matrix,matrix2);

			System.out.println("The resultant matrix of the product between N and M (N·M):");
			showMatrix(matrixRes);
			System.out.println();
			
		}catch (InputMismatchException e) {
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

			int matrix [][]=new int [longitude][longitude];
			int matrixIni[][]=matrix;
			
			readMatrix(matrix);

			System.out.println("\nThe initial argumented matrix is:");
			showMatrix(matrix);

			System.out.println("\nThe original matrix powered by "+power+" is: ");
			for (int i=0; i<power-1; i++) {
				matrix=product(matrix,matrixIni);
			}

			showMatrix(matrix);
			System.out.println();
		
		}catch (InputMismatchException e) {
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

			int matrix[][];
			int dimension;

			System.out.println("|WARNING|: When calculating determinants of a dimension bigger than 20 you may experience slowness in your computer.");
			System.out.print("Type the dimension of the matrix [maximum recommended :20] :");
			dimension = sc.nextInt();

			while (dimension<=0) {
				System.out.println("\nThe matrix dimension can't be less than 0 or bigger than 20.");
				System.out.printf("Type the dimension of the matrix [maximum recommended :20] :");
				dimension = sc.nextInt();
			}

			matrix = new int[dimension][dimension];
			System.out.print("");
			System.out.printf("\nType the elements of the matrix:\n\n");
			readMatrix(matrix);

			System.out.printf("\nThis is your argumented matrix of dimension "+dimension+":\n");
			showMatrix(matrix);

			System.out.printf("\nThe determinant of the argumented matrix is: %d\n", determinant(matrix));
			System.out.println();
		
		}catch (InputMismatchException e) {
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

			int[][] matrix=new int[Dimension][Dimension];
			System.out.print("\n");
			readMatrix(matrix);

			System.out.println("Your argumented matrix is:");
			showMatrix(matrix);
			System.out.println();


			if (Dimension==2) {
				if (determinant(matrix)==0) {
					Ran=2;
				}else Ran=1;
				System.out.println("The range of your matrix is: "+Ran);
			}

			if (Dimension==3) {
				if (determinant(matrix)!=0) {
					Ran=3;
					System.out.println("The range of your matrix is: "+Ran);
				}
				if (determinant(matrix)==0) {

					int[]attached=new int[6];
					attached[0]=(matrix[0][0]*matrix[1][1]-(matrix[0][1]*matrix[1][0]));
					attached[1]=(matrix[0][0]*matrix[1][2]-(matrix[0][2]*matrix[1][0]));
					attached[2]=(matrix[0][1]*matrix[1][2]-(matrix[1][1]*matrix[0][2]));
					attached[3]=(matrix[1][0]*matrix[2][1]-(matrix[1][1]*matrix[2][0]));
					attached[4]=(matrix[1][0]*matrix[2][2]-(matrix[1][2]*matrix[2][0]));
					attached[5]=(matrix[1][1]*matrix[2][2]-(matrix[1][2]*matrix[2][1]));

					for (int i = 0; i<attached.length; i++) {
						if (attached[i]!=0) {
							Ran=2;
						}else System.out.println("The range of your matrix is: "+Ran); //Ran is 1 by default
					}
				}   
			}
			System.out.println();
		
		}catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
		}
	}
	
	/*------------------------------------OTHER METHODS THAT ARE CALLED BY MAIN METHODS-----------------------*/
	public void showMatrix(int [][]matrix) {
		for (int k = 0; k < matrix.length; k++) {
			System.out.print("\n");
			for (int l = 0; l < matrix[k].length; l++) {
				System.out.print(matrix[k][l]+"\t");
			}
		}System.out.println();
	}
	public void readMatrix(int [][]matrix) {
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("-----------------------------------------ROW "+(i+1)+"-----------------------------------------------\n");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print("--> Type the value of the position ["+(i+1)+","+(j+1)+"]: "); matrix[i][j]=sc.nextInt();
			}System.out.println();
		}
	}
	public int[][] product(int [ ][ ] matrix1,int [][]matrix2) {
		int MatrizRes[][]=new int [matrix1.length][matrix2[0].length];
		for (int a = 0; a < matrix2[0].length; a++) {
			for (int i = 0; i < matrix1.length; i++) {
				int suma = 0;
				for (int j = 0; j < matrix1[0].length; j++) {
					suma += matrix1[i][j] * matrix2[j][a];
				}
				MatrizRes[i][a] = suma;
			}
		}
		return MatrizRes;
	}

	public int determinant(int matrix[][]) {
		int determinant = 0;

		if (matrix.length == 1) {return matrix[0][0];} 
		if (matrix.length == 2) {
			determinant=matrix[0][0]*matrix[1][1]-(matrix[0][1]*matrix[1][0]);
			return determinant;
		}
		else {
			for (int i = 0; i < matrix.length; i++) {
				determinant= determinant+matrix[0][i]*cofactor(matrix,0,i);
			}
		}
		return determinant;
	}

	public int cofactor(int matrix[][], int row, int column) {

		int submatrix[][];
		int n = matrix.length - 1;

		submatrix = new int[n][n];
		int x = 0;
		int y = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (i != row && j != column) {
					submatrix[x][y] = matrix[i][j];
					y++;
					if (y>=n) {
						x++;
						y=0;
					}
				}
			}
		}
		return (int)Math.pow(-1.0, row + column)*determinant(submatrix);
	}
}
