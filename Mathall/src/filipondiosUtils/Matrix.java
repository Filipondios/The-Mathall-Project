package filipondiosUtils;

import java.util.InputMismatchException;
import java.util.Scanner;
/**Class that implements several methods that allow two different transformations
 * and operations to matrices.
 * @author Filipondios
 * @version 26.06.2022*/
public class Matrix{
	Scanner sc =new Scanner(System.in);
	FormattedNumber fn = new FormattedNumber();
		
	/**Method that reads and gives values to the positions of a matrix given by the user inputs.
	 * @param matrix {@link FormattedNumber} matrix.*/
	public void readMatrix(FormattedNumber [][] matrix) throws InputMismatchException{
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("──────────────────────────────────[ROW "+(i+1)+"]\n");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print("==> Type the value of the position ["+(i+1)+","+(j+1)+"]: "); matrix[i][j]=new FormattedNumber(sc.next());
			}System.out.println();
		}
	}
	
	/**Method that prints in console the representation of a matrix.
	 * @param matrix {@link FormattedNumber} matrix.*/
	public void printMatrix(FormattedNumber [][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}System.out.println();
		}		
	}
	
	/**Method that calculates the rank of a matrix. Inlinear algebra, Range can be defined as: given 
	 * some matrix A, its the number of vectors (rows or columns) that can't be expressed as a linear
	 * combination of its rows or columns.
	 * @param matrix {@link FormattedNumber} matrix.
	 * @return Integer number that represents the rank of the matrix.*/
	public int matrixRank(FormattedNumber[][] matrix) {
		gaussMethod(matrix);
		int Ran = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (!rowIsCero(matrix,i)) { Ran++; }
		}
		if (Ran == 0) { return 1; }
		return Ran;
	}
	
	/**Private method that checks if a entire row is cero.
	 * @param matrix {@link FormattedNumber} matrix.
	 * @patam row Integer number that represents the number of the row to check.
	 * @return {@link Boolean} value: True if the row only have 0 as value, false if dont.*/
	private boolean rowIsCero(FormattedNumber[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; i++)
			if (matrix[row][i].doubleValue()!=0) {return false;}
		
		return true;
	}
	
	/**Method that applies the Gauss Method to a matrix. In mathematics, the Gaussian
	 * elimination method is known as the row reduction algorithm for solving linear 
	 * equations systems. It consists of a sequence of operations performed on the 
	 * corresponding matrix of coefficients. This method is applied to the calculus of
	 * matrices rank, ecuation systems resolution, inverse matrices calculus and more. 
	 * @param matrix {@link FormattedNumber} matrix.*/
	public void gaussMethod(FormattedNumber[][] matrix) {
		gaussSetup(matrix);
		for (int i = 0; i <= matrix[0].length-2; i++) { // Colummns
			for (int j = i+1; j < matrix.length; j++) { // Rows	
				gaussRowOperations(matrix,j,i,i);
			}
		}
		if ((matrix[matrix.length-1][matrix[0].length-1].doubleValue()%matrix[matrix.length-1][matrix[0].length-1].doubleValue()==0)
				&&matrix[matrix.length-2][matrix[0].length-2].doubleValue()==0) {
			matrix[matrix.length-1][matrix[0].length-1]=new FormattedNumber(0);
		}
	}
	
	/**Private  method that sets up a matrix to apply Gauss’s method. First, this method checks if the first
	 * position in the first column is different from 0. If it is not, looks for the first row
	 * with an element different than 0 and changes this last row with the first. In the case that all
	 * the first column is 0, the method throws a Runtime Exception.
	 * @param matrix {@link FormattedNumber} matrix.*/
	private void gaussSetup(FormattedNumber[][] matrix){
		if(matrix[0][0].doubleValue() == 0) {
			if (gaussNotCeroPositionInColumn(matrix) == -1) { throw new RuntimeException("Toda la primera columna de la matrix es 0.");}
			else {
				int fila = gaussNotCeroPositionInColumn(matrix);
				for (int i = 0; i < matrix[0].length; i++) {
					FormattedNumber temp = matrix[fila][i];
					matrix[fila][i] = matrix[0][i];
					matrix[0][i] = temp;
				}
			}
		}
	}
	
	/**Method that checks the first row that its first element is different to cero.
	 * @param matrix {@link FormattedNumber} matrix.
	 * @return Integer number that represents the first row that its first element is
	 * different to cero. If all the first column is 0, returns -1.*/
	private int gaussNotCeroPositionInColumn(FormattedNumber[][] matrix) {
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0].doubleValue() != 0) { return i; }
		}
		return -1;
	}
	
	/**Private method that makes the Gauss operations to the rows of a matrix. This method is called
	 * to do operations to all the sub-matrices that the original matrix has.
	 * @param matrix {@link FormattedNumber} matrix. 
	 * @param fila Integer number that represents the row where the method is giong to do the operations.
	 * @param columna Integer number that represents the column of the first element of the submatrix.
	 * @param filaFija Integer number that represents the row that is going to be the reference to do the 
	 * least common multiple and substractin of the parameter row indicated before.*/
	private void gaussRowOperations(FormattedNumber[][] matrix, int fila, int columna, int filaFija) {
		if (matrix[fila][columna].doubleValue() != 0) { 
			FormattedNumber MCM = fn.divisionOf(matrix[fila][columna],matrix[filaFija][columna]);
			for (int i = columna; i < matrix[0].length; i++) {
				matrix[fila][i] =  fn.substractOf(matrix[fila][i],fn.productOf(matrix[filaFija][i],MCM));
			}
		}
	}
	
	/**Method that calculates the product of two matrices.
	 * @param matrix1 {@link FormattedNumber} matrix. 
	 * @param matrix2 {@link FormattedNumber} matrix. 
	 * @return {@link FormattedNumber} matrix that is the result of the operation matrix1 x matrix2.*/
	public FormattedNumber[][] matrixProduct(FormattedNumber [ ][ ] matrix1,FormattedNumber [][]matrix2) {
		FormattedNumber MatrizRes[][]=new FormattedNumber [matrix1.length][matrix2[0].length];
		
		for (int a = 0; a < matrix2[0].length; a++) {
			for (int i = 0; i < matrix1.length; i++) {
				FormattedNumber suma = new FormattedNumber();
				for (int j = 0; j < matrix1[0].length; j++) {
					suma = fn.additionOf(suma, fn.productOf(matrix1[i][j],matrix2[j][a]));
				}
				MatrizRes[i][a] = suma;
			}
		}
		return MatrizRes;
	}

	/**Method that calculates the determinant of a matrix. 
	 * @param matrix {@link FormattedNumber} matrix. 
	 * @return {@link FormattedNumber} that represents the determinant of the parameter matrix.*/
	public FormattedNumber determinant(FormattedNumber matrix[][]) {
		FormattedNumber determinant = new FormattedNumber();

		if (matrix.length == 1) {return matrix[0][0];} 
		if (matrix.length == 2) {
			
			determinant= fn.substractOf(fn.productOf(matrix[0][0], matrix[1][1]), fn.productOf(matrix[0][1], matrix[1][0]));
			return determinant;
		}
		else {
			for (int i = 0; i < matrix.length; i++) {
				determinant= fn.additionOf(determinant, fn.productOf(matrix[0][i], cofactor(matrix,0,i)));
			}
		}
		return determinant;
	}

	/**Private method that calculates the determinant of a co-factor or sub-matrix of a matrix.
	 * @param matrix {@link FormattedNumber} matrix. 
	 * @param row Integer number that represents the row where the submatrix is located.
	 * @param column Integer number that represents the column where the submatrix is located.
	 * @return {@link FormattedNumber} that that represents the determinant of the sub-matrix matrix.*/
	private FormattedNumber cofactor(FormattedNumber matrix[][], int row, int column) {

		FormattedNumber submatrix[][];
		int n = matrix.length - 1;

		submatrix = new FormattedNumber[n][n];
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
		return fn.productOf(new FormattedNumber((int)Math.pow(-1.0, row + column)), determinant(submatrix));
	}
}

