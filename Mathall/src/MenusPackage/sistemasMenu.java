package MenusPackage;

import java.util.Scanner;
import AlgebraPackage.algebraEcuaciones;import java.io.IOException;

public class sistemasMenu {
	public void MenuOnSistemas() throws IOException, InterruptedException {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		algebraEcuaciones Al =new algebraEcuaciones();

		String Username=System.getProperty("user.name");//Cojer nombre de usuario del sistema.
		int entrada=69;//Valor random para entrada -> entrada al bucle do while

		do {
			try {
				System.out.println("|MENU DE RESOLUCION DE SISTEMAS|");
				System.out.println("#0-Salir del menu");
                                System.out.println("#1-Resolucion de ecuaciones de segundo grado");
				System.out.println("#2-Resolucion de sistemas de ecuaciones de 3 incognitas y 3 ecuaciones\n");
                                
				System.out.print("\033[31muser\033[37m@"+Username+"~#");entrada=sc.nextInt();System.out.println();

				switch (entrada) {
				case 1:Al.EcuacionSegundoGrado();break;
                                case 2:Al.Ecuaciones3x3();break;
				default:break;
				}
			}
			catch(java.lang.NumberFormatException e) {
				System.out.println("Mathall-System.output~#: Revisa tu entrada: no es valida.\n");
				entrada=0;
			}
		}while(entrada!=0);
	}
}
