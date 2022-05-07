package MenusPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import AlgebraPackage.algebraMatrices;
import GraphicsPackage.graphics;
import UserDataPackage.userData;

import java.io.IOException;

public class matrixMenu {
	Scanner sc=new Scanner(System.in);
	algebraMatrices Al = new algebraMatrices();
	graphics Gr = new graphics();

	public void MenuOnMatrices() throws IOException, InterruptedException {
		
		boolean KeepModule=true;
		
		while(KeepModule) {
			try {
				System.out.println("|MATRIX OPERATIONS MENU|\n"
				+ "#0- Exit menu\n"
				+ "#1- Addition or subtraction of any two matrix\n"
				+ "#2- Product of any two matrix\n"
				+ "#3- Power of any matrix\n"
				+ "#4- Determinant of any square matrix\n"
				+ "#5- Range of a 2x2 or 3x3 matrix\n");

				System.out.print(Gr.red+"user"+Gr.white+"@"+userData.Username+"~# ");int entry=sc.nextInt(); 
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

