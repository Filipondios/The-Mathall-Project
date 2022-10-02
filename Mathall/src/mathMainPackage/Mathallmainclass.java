package mathMainPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import filipondiosUtils.Print;
import graphicsPackage.Graphics;
import menusPackage.*;

/**Mathall Main Class. Calls the method that loads the logo and the first menu from {@link Graphics}.
 * @author Filipondios
 * @version 01.10.2022*/
public class Mathallmainclass {

	public static void main(String[] args) throws Exception, InterruptedException {
		
		@SuppressWarnings("resource") Scanner sc = new Scanner(System.in);
		MatrixMenu Mm = new MatrixMenu();
		SistemsMenu Ms = new SistemsMenu();
		Graphics.setCodepage();
		
		boolean KeepModule = true, first = true, RuntimeErrors=false;
		while(KeepModule) {
			try {
				Graphics.ClearConsole(); GraphicsMenu(); 
				if (first) {
				    Print.note("To select an option of any menu, you have to make a input with the number of the "
				            + "desired selection. If you type 0 in any menu, you will be returned to the previous menu. "
				            + "It will happen the same if your input is not a integer number greater or equal to 0.");
				    first=!first;
				}
				Print.prompt(); int input = sc.nextInt();
				System.out.println();
				
				switch (input) {
					case 0:KeepModule = false; break;
					case 1:Mm.MenuOnMatrices();break; 
					case 2:Ms.MenuOnSistemas();break; 
					default:break;
				}
			} 
			catch(InputMismatchException e) {
				KeepModule = false; RuntimeErrors = true;
				Print.warning("The program ended due some error.");
				Print.warning("Check your inputs and make sure it’s not caused by Mathall.");
				Thread.sleep(5*1000);
			}
		}
		if (!RuntimeErrors) {
		    Print.note("The program ended succesfully.");
			Thread.sleep(2*1000);
		}
	}
	
	/**Method that prints Mathall's logo and first menu.*/
    public static void GraphicsMenu() {
        System.out.println(Graphics.white+" |MATHALL MAIN MENU"+Graphics.purple+"                    __  __       _   _           _ _ ");
        System.out.println(Graphics.white+" ├─["+Graphics.yellow+"0"+Graphics.white+"]─ Exit Mathall"+Graphics.purple+"                     |  \\/  | __ _| |_| |__   __ _| | |");
        System.out.println(Graphics.white+" ├─["+Graphics.yellow+"1"+Graphics.white+"]─ Matrix Operations"+Graphics.purple+"                | |\\/| |/ _` | __| '_ \\ / _` | | |");
        System.out.println(Graphics.white+" └─["+Graphics.yellow+"2"+Graphics.white+"]─ Equation Systems Resolution"+Graphics.purple+"      | |  | | (_| | |_| | | | (_| | | |");
        System.out.println("                                      "+Graphics.purple+"|_|  |_|\\__,_|\\__|_| |_|\\__,_|_|_| @2.2.1");
    }
}
