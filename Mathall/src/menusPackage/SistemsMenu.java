package menusPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import algebraPackage.AlgebraEcuations;
import graphicsPackage.Graphics;
import mathMainPackage.Mathallmainclass;
import userDataPackage.UserData;
/**Class that allows the user the selection of the resolution of ecuation systems. This loads a menu,
 * which waits for an integer entry that represents the option chosen by the user. In case 
 * that the entry is not correct, the user will be returned to Mathall main menu {@link Mathallmainclass}. 
 * @author Filipondios
 * @version 26.06.2022*/
public class SistemsMenu {

	Scanner sc = new Scanner(System.in);
	AlgebraEcuations Al = new AlgebraEcuations();
	Graphics Gr = new Graphics();
	
	/**Method that prints in console the ecuation systems resolution selection menu and 
	 * depending on the user's choice, a determinated method of the class {@link AlgebraEcuations}
	 * is initialized.*/
	public void MenuOnSistemas() {
		boolean KeepModule = true;

		while (KeepModule) {
			try {
				System.out.println(" |EQUATION SYSTEMS RESOLUTION MENU |\n"
					+" ├─[0]─ Exit menu\n"
					+" └─[1]─ Resolution of second grade equations\n");
				
				System.out.print(Gr.red+" user"+Gr.white+"@"+UserData.Username+"~# ");int entry = sc.nextInt(); 
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
				System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: Check your input: its not accepted.\n");
			}
		}
	}
}
