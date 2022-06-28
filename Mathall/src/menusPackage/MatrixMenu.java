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
				System.out.println(" |MATRIX OPERATIONS MENU|\n"
				+ " ├─["+Gr.yellow+"0"+Gr.white+"]─ Exit menu\n"
				+ " ├─["+Gr.yellow+"1"+Gr.white+"]─ Addition or subtraction of any two matrix\n"
				+ " ├─["+Gr.yellow+"2"+Gr.white+"]─ Product of any two matrix\n"
				+ " ├─["+Gr.yellow+"3"+Gr.white+"]─ Power of any matrix\n"
				+ " ├─["+Gr.yellow+"4"+Gr.white+"]─ Determinant of any square matrix\n"
				+ " ├─["+Gr.yellow+"5"+Gr.white+"]─ Rank any matrix\n"
				+ " ├─["+Gr.yellow+"6"+Gr.white+"]─ Row echelon form - Gauss Method of any matrix\n"
				+ " ├─["+Gr.yellow+"7"+Gr.white+"]─ Inverse of any square matrix\n"
				+ " └─["+Gr.yellow+"8"+Gr.white+"]─ Transpose of any matrix\n");

				System.out.print(Gr.red+" user"+Gr.white+"@"+UserData.Username+"~# ");int entry=sc.nextInt(); 
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
				System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
			}
		}
	}
}

