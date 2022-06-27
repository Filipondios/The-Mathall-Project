package menusPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import algebraPackage.AlgebraMatrix;
import graphicsPackage.Graphics;
import mathMainPackage.Mathallmainclass;
import userDataPackage.UserData;

/**Class that allows the user the selection of the operations with matrices. This loads a menu,
 * which waits for an integer entry that represents the option chosen by the user. In case 
 * that the entry is not correct, the user will be returned to Mathall main menu {@link Mathallmainclass}. 
 * @author Filipondios
 * @version 27.06.2022*/
public class MatrixMenu {
	Scanner sc=new Scanner(System.in);
	AlgebraMatrix Al = new AlgebraMatrix();
	Graphics Gr = new Graphics();
	
	/**Method that prints in console the matrix operations selection menu and 
	 * depending on the user's choice, a determinated method of the class {@link AlgebraMatrix}
	 * is initialized.*/
	public void MenuOnMatrices() {
		boolean KeepModule=true;
		
		while(KeepModule) {
			try {
				System.out.println("|MATRIX OPERATIONS MENU|\n"
				+ "├─[0]─ Exit menu\n"
				+ "├─[1]─ Addition or subtraction of any two matrix\n"
				+ "├─[2]─ Product of any two matrix\n"
				+ "├─[3]─ Power of any matrix\n"
				+ "├─[4]─ Determinant of any square matrix\n"
				+ "├─[5]─ Rank any matrix\n"
				+ "├─[6]─ Row echelon form - Gauss Method of any matrix\n"
				+ "├─[7]─ Inverse of any square matrix\n"
				+ "└─[8]─ Transpose of any matrix\n");

				System.out.print(Gr.red+"user"+Gr.white+"@"+UserData.Username+"~# ");int entry=sc.nextInt(); 
				System.out.println();

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
				System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
			}
		}
	}
}

