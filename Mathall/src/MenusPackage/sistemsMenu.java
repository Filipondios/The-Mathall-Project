package MenusPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import AlgebraPackage.algebraEcuaciones;
import GraphicsPackage.graphics;
import UserDataPackage.userData;

import java.io.IOException;

public class sistemsMenu {

	Scanner sc = new Scanner(System.in);
	algebraEcuaciones Al = new algebraEcuaciones();
	graphics Gr = new graphics();

	public void MenuOnSistemas() throws IOException, InterruptedException {

		boolean KeepModule = true;

		while (KeepModule) {
			try {
				System.out.println("|EQUATION SYSTEMS RESOLUTION MENU |");
				System.out.println("#0- Exit menu");
                System.out.println("#1- Resolution of second grade equations");
				System.out.println("#2- Resolution 2x2 or 3x3 systems\n");
                               
				System.out.print(Gr.red+"user"+Gr.white+"@"+userData.Username+"~# ");int entry = sc.nextInt(); 
				System.out.println();

				switch (entry) {
					case 1:Al.SecondGradeEquation();break;
                	case 2:Al.EquationSistems();break;
					default:break;
				}
			}
			catch(InputMismatchException e) {
				sc.nextLine(); 
				KeepModule = false;
				System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
			}
		}
	}
}
