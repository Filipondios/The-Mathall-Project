package AlgebraPackage;

import java.util.InputMismatchException;
import java.util.Scanner;
import FormatPackage.fraccion;
import java.io.IOException;
import GraphicsPackage.graphics;

public class algebraEcuaciones {

	Scanner sc = new Scanner(System.in);
	graphics Gr = new graphics();

	public void EcuacionSegundoGrado() throws IOException, InterruptedException {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println("████████████████████████████████ ECUACIONES DE SEGUNDO GRADO ████████████████████████████████");
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println();

			System.out.println("Introduce los valores de los coeficientes de la ecuacion cuadratica: ax^2 + bx + c =0");
			System.out.print("--> a = ");
			double a = sc.nextInt();
			System.out.print("--> b = ");
			double b = sc.nextInt();
			System.out.print("--> c = ");
			double c = sc.nextInt();

			System.out.println("\nSu ecuacion cuadratica es: " + a + "x^2 + " + b + "x + " + c + " =0");
			double discriminante = Math.pow(b, 2) - 4 * a * c;

			int DISCRIMINANTE=(int)(Math.sqrt(discriminante));

			if(discriminante<0) {System.out.println("No hay solucion real a la ecuacion");}
			else {  
				int x1=(int) (-b+Math.sqrt(discriminante)); int den=(int)(2*a);
				int x2=(int) (-b-Math.sqrt(discriminante));

				if (discriminante-DISCRIMINANTE==0) {
					/*Discriminante es un numero entero entero*/

					fraccion Solucion1 = new fraccion(x1,den);
					fraccion Solucion2 = new fraccion(x2,den);

					Solucion1.simplificar(Solucion1);
					Solucion1.simplificar(Solucion2);

					if(x1==x2){
						System.out.println("Ecuación con una solucion doble.\n");
						System.out.println("          |\nSolucion  |x= "+Solucion1);
						System.out.println("          |");
					}
					else{
						System.out.println("Ecuación con dos soluciones.\n");
						System.out.println("          |x1= "+Solucion1+"\nSoluciones|");
						System.out.println("          |x2= "+Solucion2);
					}
				}
				if (discriminante-DISCRIMINANTE>0) {
					/*Discriminante es un numero con decimales*/
					a=2*a;b=-b;
					System.out.println("Ecuación con dos soluciones.\n");

					if (b==0) {
						System.out.printf("          |x1= [sqrt(%.0f)]/[%.0f]\nSoluciones|\n",discriminante,a);
						System.out.printf("          |x2= [-sqrt(%.0f)]/[%.0f]\n",discriminante,a);
					}else{
						System.out.printf("          |x1= [%.0f + sqrt(%.0f)]/[%.0f]\nSoluciones|\n",b,discriminante,a);
						System.out.printf("          |x2= [%.0f - sqrt(%.0f)]/[%.0f]\n",b,discriminante,a);
					}

				}
				System.out.println("");
			}
		
		}catch (InputMismatchException e) {
			System.out.println("Mathall-System.output~#: Revisa tu entrada: no es valida.\n");
		}
	}

	public void Ecuaciones3x3() throws IOException, InterruptedException {
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println("██████████████████████████████████████ ECUACIONES DE 3X3 ████████████████████████████████████");
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			int sistema[][] = new int[3][4];
			System.out.println("Resolucion de sistemas de 3 ecuaciones y tres incognitas.");
			System.out.println("Introduzca los coeficientes del sistema: ");

			for (int i = 0; i < sistema.length; i++) {
				System.out.println("\nEcuacion numero " + (i + 1) + ": ");
				System.out.print("Introduzca el coeficiente de x: ");
				sistema[i][0] = sc.nextInt();
				System.out.print("Introduzca el coeficiente de y: ");
				sistema[i][1] = sc.nextInt();
				System.out.print("Introduzca el coeficiente de z: ");
				sistema[i][2] = sc.nextInt();
				System.out.print("Introduzca el coeficiente independiente: ");
				sistema[i][3] = sc.nextInt();
			}
			System.out.println();

			int SubMatriz[][] = new int[3][3];

			for (int i = 0; i < SubMatriz.length; i++) {
				for (int j = 0; j < SubMatriz[i].length; j++) {
					SubMatriz[i][j] = sistema[i][j];
				}
			}
			if (DET3x3(SubMatriz) != 0) {
				int MatrizX[][] = new int[3][3];
				copiarA(MatrizX, SubMatriz);
				int MatrizY[][] = new int[3][3];
				copiarA(MatrizY, SubMatriz);
				int MatrizZ[][] = new int[3][3];
				copiarA(MatrizZ, SubMatriz);

				for (int i = 0; i < SubMatriz.length; i++) {
					MatrizX[i][0] = sistema[i][3];
				}
				for (int i = 0; i < SubMatriz.length; i++) {
					MatrizY[i][1] = sistema[i][3];
				}
				for (int i = 0; i < SubMatriz.length; i++) {
					MatrizZ[i][2] = sistema[i][3];
				}

				System.out.print("El sistema es compatible determinado, tiene 1 solucion: ");
				fraccion x = new fraccion(DET3x3(MatrizX), DET3x3(SubMatriz));
				x.simplificar(x);
				System.out.print("(" + x + ", ");

				fraccion y = new fraccion(DET3x3(MatrizY), DET3x3(SubMatriz));
				y.simplificar(y);
				System.out.print(y + ", ");

				fraccion z = new fraccion(DET3x3(MatrizZ), DET3x3(SubMatriz));
				z.simplificar(z);
				System.out.print(z + ")");

				System.out.println();
				System.out.println();
			}
		
		}catch (InputMismatchException e) {
			System.out.println("Mathall-System.output~#: Revisa tu entrada: no es valida.\n");
		}
	}

	/*------------------------------------METODOS-FUNCIONES COMUNES A TODOS LOS OTROS METODOS-----------------------*/
	public void mostrarMatriz(int[][] matriz) {
		for (int k = 0; k < matriz.length; k++) {
			System.out.print("\n");
			for (int l = 0; l < matriz[k].length; l++) {
				System.out.print(matriz[k][l] + "\t");
			}
		}
		System.out.println();
	}

	public void copiarA(int[][] matriz1, int[][] matriz2) {
		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2.length; j++) {
				matriz1[i][j] = matriz2[i][j];
			}
		}
	}

	public int DET3x3(int matriz[][]) {
		int Determinante = matriz[0][0] * matriz[1][1] * matriz[2][2] + matriz[1][0] * matriz[2][1] * matriz[0][2] + matriz[0][1] * matriz[1][2] * matriz[2][0]
				- matriz[0][2] * matriz[1][1] * matriz[2][0] - matriz[0][1] * matriz[1][0] * matriz[2][2] - matriz[1][2] * matriz[2][1] * matriz[0][0];
		return Determinante;
	}
}
