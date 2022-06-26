package menusPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

import algebraPackage.AlgebraEcuations;
import graphicsPackage.Graphics;
import userDataPackage.UserData;

import java.io.IOException;

public class SistemsMenu {

	Scanner sc = new Scanner(System.in);
	AlgebraEcuations Al = new AlgebraEcuations();
	Graphics Gr = new Graphics();

	public void MenuOnSistemas() throws IOException, InterruptedException {

		boolean KeepModule = true;

		while (KeepModule) {
			try {
				System.out.println("|EQUATION SYSTEMS RESOLUTION MENU |\n"
					+"├─[0]─ Exit menu\n"
					+"└─[1]─ Resolution of second grade equations\n");
				
				System.out.print(Gr.red+"user"+Gr.white+"@"+UserData.Username+"~# ");int entry = sc.nextInt(); 
				System.out.println();

				switch (entry) {
					case 0:KeepModule=false;break;
					case 1:Al.SecondGradeEquation();break;
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
