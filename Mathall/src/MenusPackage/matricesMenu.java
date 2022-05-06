package MenusPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import AlgebraPackage.algebraMatrices;
import java.io.IOException;

public class matricesMenu {

	public void MenuOnMatrices() throws IOException, InterruptedException {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		algebraMatrices Al =new algebraMatrices();
		
		String Username=new String(System.getProperty("user.name"));
		boolean KeepModule=true;
		
		while(KeepModule) {
			try {
				System.out.println("|MENU DE OPERACIONES CON MATRICES|");
				System.out.println("#0-Salir del menu");
				System.out.println("#1-Suma o resta de dos matrices cualquiera");
				System.out.println("#2-Producto de dos matrices cualquiera");
				System.out.println("#3-Potencia de una matriz cualquiera");
				System.out.println("#4-Determinante de cualquier matriz cuadrada de orden menor a 20");
				System.out.println("#5-Rango de una matriz 2x2 o 3x3\n");
				System.out.print("\033[31muser\033[37m@"+Username+"~# ");int entrada=sc.nextInt(); System.out.println();

				switch (entrada) {
					case 0:KeepModule=false;break;
					case 1:Al.SumaRestaMatrices();break;
					case 2:Al.ProductoMatrices();break;
					case 3:Al.PotenciaMatrices();break;
					case 4:Al.DeterminanteMatrices();break;
					case 5:Al.RangoMatrices();break;
					default:break;
				}
			}
			catch(InputMismatchException e) {
				sc.nextLine(); 
				KeepModule=false;
				System.out.println("\033[31mMathall-System.\033[37moutput~#: Revisa tu entrada: no es valida.\n");
			}
		}
	}
}

