package menusPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import algebraPackage.AlgebraMatrix;
import filipondiosUtils.Print;
import graphicsPackage.Graphics;
import mathMainPackage.Mathallmainclass;

/**Class that allows the user the selection of the operations with matrices. This loads a menu,
 * which waits for an integer entry that represents the option chosen by the user. In case 
 * that the entry is not correct, the user will be returned to Mathall main menu {@link Mathallmainclass}. 
 * @author Filipondios
 * @version 18.10.2022*/
public class MatrixMenu {
	Scanner sc = new Scanner(System.in);
	AlgebraMatrix Al = new AlgebraMatrix();
	
	/**Method that prints in console the matrix operations selection menu and 
	 * depending on the user's choice, a determinated method of the class {@link AlgebraMatrix}
	 * is initialized.*/
	public void MenuOnMatrices() {
		boolean KeepModule=true;
		
		while(KeepModule) {
			try {
			    Print.menu("MATRIX OPERATIONS MENU", 
			            "Exit menu",
			            "Addition or subtraction of any two matrix",
			            "Product of any two matrix",
			            "Power of any matrix",
			            "Determinant of any square matrix",
			            "Rank any matrix",
			            "Row echelon form - Gauss Method of any matrix",
			            "Inverse of any square matrix",
			            "Transpose of any matrix");

				Print.prompt(); int entry=sc.nextInt(); 
				Graphics.ClearConsole();

				switch (entry) {
					case 0:KeepModule=false;break;
					case 1:Al.MatrixAddSub();break;
					case 2:Al.MatrixProduct();break;
					case 3:Al.MatrixPower();break;
					case 4:Al.MatrixDeterminant();break;
					case 5:Al.MatrixRank();break;
					case 6:Al.RowEchelon();break;
					case 7:Al.InverseMatrix();break;
					case 8:Al.TransposeMatrix();break;
					default:break;
				}
			}
			catch(InputMismatchException e) {
				sc.nextLine(); 
				KeepModule=false;
				Print.warning("Check your input: its not accepted\n\n");
			}
		}
	}
}

