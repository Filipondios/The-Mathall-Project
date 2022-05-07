package MathMainPackage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import MenusPackage.*;
import UserDataPackage.userData;
import GraphicsPackage.graphics;

public class mathallmainclass {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		@SuppressWarnings("resource") Scanner sc = new Scanner(System.in);
		matrixMenu Mm = new matrixMenu();
		sistemsMenu Ms = new sistemsMenu();
		graphics Gr = new graphics();

		boolean KeepModule = true, RuntimeErrors=false;
		
		while(KeepModule) {
			try {
				Gr.ClearConsole(); Gr.Graphics();
				System.out.print(Gr.red+"user"+Gr.white+"@"+userData.Username+"~# "); int entry = sc.nextInt();
				System.out.println();

				switch (entry) {
					case 0:KeepModule = false; break;
					case 1:Mm.MenuOnMatrices();break; 
					case 2:Ms.MenuOnSistemas();break; 
					default:break;
				}
			}
			catch(InputMismatchException e) {
				sc.nextLine(); 
				KeepModule = false; RuntimeErrors = true;
				System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: The program ended due some error.");
				System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: Check your inputs and make sure it’s not caused by Mathall.");
			}
		}
		if (!RuntimeErrors) {
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: The program ended succesfully.");
			System.out.println(Gr.red+"Mathall-System."+Gr.white+"output~#: To run the program again, use the executable again. Thanks!");
		}
		Thread.sleep(5*1000);
	}
}
