package menusPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

import algebraPackage.AlgebraMatrix;
import graphicsPackage.Graphics;
import userDataPackage.UserData;

import java.io.IOException;

public class MatrixMenu {
	Scanner sc=new Scanner(System.in);
	AlgebraMatrix Al = new AlgebraMatrix();
	Graphics Gr = new Graphics();

	public void MenuOnMatrices() throws IOException, InterruptedException {
		
		boolean KeepModule=true;
		
		while(KeepModule) {
			try {
				System.out.println("|MATRIX OPERATIONS MENU|\n"
				+ "├─[0]─ Exit menu\n"
				+ "├─[1]─ Addition or subtraction of any two matrix\n"
				+ "├─[2]─ Product of any two matrix\n"
				+ "├─[3]─ Power of any matrix\n"
				+ "├─[4]─ Determinant of any square matrix\n"
				+ "└─[5]─ Range of a 2x2 or 3x3 matrix\n");

				System.out.print(Gr.red+"user"+Gr.white+"@"+UserData.Username+"~# ");int entry=sc.nextInt(); 
				System.out.println();

				switch (entry) {
					case 0:KeepModule=false;break;
					case 1:Al.MatrixAddSub();break;
					case 2:Al.MatrixProduct();break;
					case 3:Al.MatrixPower();break;
					case 4:Al.MatrixDeterminant();break;
					case 5:Al.MatrixRange();break;
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

