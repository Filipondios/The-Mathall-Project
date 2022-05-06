package MathMainPackage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import MenusPackage.*;
import GraphicsPackage.graphics;

public class mathallmainclass {

	public static void main(String[] args) throws IOException, InterruptedException {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		matricesMenu Mm=new matricesMenu();
		sistemasMenu Ms=new sistemasMenu();
		graphics Gr=new graphics();

		String Username=new String(System.getProperty("user.name"));
		boolean KeepModule=true, RuntimeErrors=false;
		
		while(KeepModule) {
			try {
				Gr.ClearConsole(); Gr.Graphics();
				System.out.print("\033[0;1m\033[31muser\033[37m@"+Username+"~# ");int entrada=sc.nextInt();System.out.println();

				switch (entrada) {
					case 0:KeepModule=false; break;
					case 1:Mm.MenuOnMatrices();break; 
					case 2:Ms.MenuOnSistemas();break; 
					default:break;
				}
			}
			catch(InputMismatchException e) {
				sc.nextLine(); 
				KeepModule=false; RuntimeErrors=true;
				System.out.println("\033[31mMathall-System.\033[37moutput~#: El programa finalizo con con errores.");
				System.out.println("\033[31mMathall-System.\033[37moutput~#: Revise sus entradas de teclado y asegurese que no es provocado por Mathall.");
			}
		}
		if (!RuntimeErrors) {
			System.out.println("\033[31mMathall-System.\033[37moutput~#: El programa finalizo con exito.");
			System.out.println("\033[31mMathall-System.\033[37moutput~#: Para volver a ejecutar el programa, utilice de nuevo el ejecutable o revise el archivo README.txt");
		}
		Thread.sleep(10*1000);
	}
}
