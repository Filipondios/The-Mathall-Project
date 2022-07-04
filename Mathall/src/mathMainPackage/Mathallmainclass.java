package mathMainPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import graphicsPackage.Graphics;
import menusPackage.*;
import userDataPackage.UserData;

/**Mathall Main Class. Calls the method that loads the logo and the first menu from {@link Graphics}.
 * @author Filipondios
 * @version 28.06.2022*/
public class Mathallmainclass {

	public static void main(String[] args) throws Exception, InterruptedException {
		
		@SuppressWarnings("resource") Scanner sc = new Scanner(System.in);
		MatrixMenu Mm = new MatrixMenu();
		SistemsMenu Ms = new SistemsMenu();
		Graphics Gr = new Graphics();
		
		int first=0;
		boolean KeepModule = true, RuntimeErrors=false;
		while(KeepModule) {
			try {
				Gr.ClearConsole(); Gr.GraphicsMenu(); 
				if (first==0) {
					System.out.println(Gr.yellow+"\n * "+Gr.green+"NOTE: "+Gr.white+"To select an option of any menu,"
					+" you have to make a input with the number of the\n"+Gr.yellow+" * "+Gr.white+"desired selection."
					+" If you type 0 in any menu, you will be returned to the previous menu.\n"+Gr.yellow+" * "+Gr.white
					+"It will happen the same if your input is not a integer number greater or equal to 0.\n");
				}
				System.out.print(Gr.red+" user"+Gr.white+"@"+UserData.Username+"~# "); int input = sc.nextInt();
				System.out.println();
				
				switch (input) {
					case 0:KeepModule = false; break;
					case 1:Mm.MenuOnMatrices();break; 
					case 2:Ms.MenuOnSistemas();break; 
					default:break;
				}
				first++;
			} 
			catch(InputMismatchException e) {
				KeepModule = false; RuntimeErrors = true;
				System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: The program ended due some error."
						+ Gr.red+"\n Mathall-System."+Gr.white+"output~#: Check your inputs and make sure it’s not caused by Mathall.");
				Thread.sleep(5*1000);
			}
		}
		if (!RuntimeErrors) {
			System.out.println(Gr.red+" Mathall-System."+Gr.white+"output~#: The program ended succesfully.");
			Thread.sleep(2*1000);
		}
	}
}
