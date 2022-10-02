package menusPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import algebraPackage.AlgebraEcuations;
import filipondiosUtils.Print;
import mathMainPackage.Mathallmainclass;
/**Class that allows the user the selection of the resolution of ecuation systems. This loads a menu,
 * which waits for an integer entry that represents the option chosen by the user. In case 
 * that the entry is not correct, the user will be returned to Mathall main menu {@link Mathallmainclass}. 
 * @author Filipondios
 * @version 01.10.2022*/
public class SistemsMenu {

	Scanner sc = new Scanner(System.in);
	AlgebraEcuations Al = new AlgebraEcuations();
	
	/**Method that prints in console the ecuation systems resolution selection menu and 
	 * depending on the user's choice, a determinated method of the class {@link AlgebraEcuations}
	 * is initialized.*/
	public void MenuOnSistemas() {
		boolean KeepModule = true;

		while (KeepModule) {
			try {
			    Print.menu("EQUATION SYSTEMS RESOLUTION MENU",
			            "Exit menu",
			            "Resolution of second grade equations",
			            "Resolution of any linear equation system");
				
				Print.prompt(); int entry = sc.nextInt(); 
				System.out.println();

				switch (entry) {
					case 0:KeepModule=false;break;
					case 1:Al.SecondGradeEquation();break;
					case 2:Al.ecuationSystems();break;
					default:break;
				}
			}
			catch(InputMismatchException e) {
				sc.nextLine(); 
				KeepModule = false;
				Print.warning("Check your input: its not accepted\n\n");
			}
		}
	}
}
