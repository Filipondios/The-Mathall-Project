package mathMainPackage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import graphicsPackage.Graphics;
import menusPackage.*;
import userDataPackage.UserData;

/**Mathall Main Class. Calls the method that loads the logo and the first menu from {@link Graphics}.
 * @author Filipondios
 * @version 26.06.2022*/
public class Mathallmainclass {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		@SuppressWarnings("resource") Scanner sc = new Scanner(System.in);
		MatrixMenu Mm = new MatrixMenu();
		SistemsMenu Ms = new SistemsMenu();
		Graphics Gr = new Graphics();

		boolean KeepModule = true, RuntimeErrors=false;
		while(KeepModule) {
			try {
				Gr.ClearConsole(); Gr.GraphicsMenu(); 
				System.out.print(Gr.red+"user"+Gr.white+"@"+UserData.Username+"~# "); int input = sc.nextInt();
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
				System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: The program ended due some error."
						+ Gr.red+"\nMathall-System."+Gr.white+"output~#: Check your inputs and make sure it’s not caused by Mathall.");
			}
		}
		if (!RuntimeErrors) {
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: The program ended succesfully.");
		}
		Thread.sleep(5*1000);
	}
}
