package filipondiosUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix{
	Scanner sc =new Scanner(System.in);
	FormattedNumber fn = new FormattedNumber();
	
	public Matrix() {}
	
	public void readMatrix(FormattedNumber [][] matrix) throws InputMismatchException{
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("──────────────────────────────────[ROW "+(i+1)+"]\n");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print("==> Type the value of the position ["+(i+1)+","+(j+1)+"]: "); matrix[i][j]=new FormattedNumber(sc.next());
			}System.out.println();
		}
	}

	public void printMatrix(FormattedNumber [][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+"\t");
			}System.out.println();
		}		
	}
	
	public void gaussMethod(FormattedNumber[][] matrix) {
		gaussSetup(matrix);
		for (int i = 0; i <= matrix[0].length-3; i++) { // Colummns
			for (int j = i+1; j < matrix.length; j++) { // Rows	
				gaussRowOperations(matrix,j,i,i);
			}
		}
	}
	
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
	
	private int gaussNotCeroPositionInColumn(FormattedNumber[][] matrix) {
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0].doubleValue() != 0) { return i; }
		}
		return -1;
	}
	
	private void gaussRowOperations(FormattedNumber[][] matrix, int fila, int columna, int filaFija) {
		if (matrix[fila][columna].doubleValue() != 0) { 
			FormattedNumber MCM = fn.divisionOf(matrix[fila][columna],matrix[filaFija][columna]);
			for (int i = columna; i < matrix[0].length; i++) {
				matrix[fila][i] =  fn.substractOf(matrix[fila][i],fn.productOf(matrix[filaFija][i],MCM));
			}
		}
	}
	
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

	public FormattedNumber cofactor(FormattedNumber matrix[][], int row, int column) {

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

