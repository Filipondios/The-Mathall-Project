package AlgebraPackage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import GraphicsPackage.graphics;

public class algebraMatrices {
	Scanner sc =new Scanner(System.in);
	graphics Gr=new graphics();
	
	/*------------------------------------METODOS-FUNCIONES PARA SUMA-RESTA DE MATRICES-----------------------------*/
	public void SumaRestaMatrices() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println("███████████████████████████████████████ SUMA DE MATRICES ████████████████████████████████████");
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println();

			int m=0,n=0,opcion=69;
			System.out.println("Introduce las dimensiones de las matrices:");
			System.out.print("Filas: ");m=sc.nextInt();System.out.print("Columnas: ");n=sc.nextInt();System.out.println();
			int matriz1 [][]=new int [m][n];
			int matriz2 [][]=new int [m][n];

			System.out.println("Introduce los elementos de la matriz 1:\n");
			leerMatriz(matriz1);

			System.out.println("Introduce los elementos de la matriz 2:\n");
			leerMatriz(matriz2);

			System.out.println("\nSelecciona una operacion a realizar [0/1]");
			System.out.println("#0-Suma de Matriz1 y Matriz2");
			System.out.println("#1-Resta de Matriz2 a Matriz1");opcion=sc.nextInt();

			while (opcion!=0 && opcion!=1){
				System.out.println("\nEntrada no valida: Introduce 0 o 1.");
				System.out.println("\nSelecciona una operacion a realizar [0/1]");
				System.out.println("#0-Suma de Matriz1 y Matriz2");
				System.out.println("#1-Resta de Matriz2 a Matriz1");opcion=sc.nextInt();
			}

			if (opcion==0) {
				int Resultante[][]=new int [m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j <n; j++) {
						Resultante[i][j]=matriz1[i][j]+matriz2[i][j];
					}
				}

				System.out.println("La matriz resultante es :");
				for (int i=0; i<m; i++) {
					for (int j=0; j<n; j++) {
						System.out.print(Resultante[i][j]+"    ");
					}System.out.print("\n");
				}
			}
			if(opcion==1) {
				int Resultante[][]=new int [m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j <n; j++) {
						Resultante[i][j]=matriz1[i][j]-matriz2[i][j];
					}
				}

				System.out.println("La matriz resultante es :");
				mostrarMatriz(Resultante);
				System.out.println("");
			}
		
		}catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println("\033[31mMathall-System.\033[37moutput~#: Revisa tu entrada: no es valida.\n");
		}
	}
	/*------------------------------------METODOS-FUNCIONES PARA PRODUCTO DE MATRICES-------------------------------*/
	public void ProductoMatrices() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println("█████████████████████████████████████ PRODUCTO DE MATRICES ██████████████████████████████████");
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println();

			int F1,C1,F2,C2;
			System.out.println("¿Que dimension quieres para tu primera Matriz?.");
			System.out.print("Filas: ");F1=sc.nextInt();
			System.out.print("Columnas: ");C1=sc.nextInt();

			System.out.println("¿Que dimension quieres para tu segunda Matriz?.");
			System.out.print("Filas: ");F2=sc.nextInt();
			System.out.print("Columnas: ");C2=sc.nextInt();

			//CONTROL DE ERRORES EN DATOS

			while((F1<=0 || C1<=0)||(F2<=0 || C2<=0)||(C1!=F2)) {
				if (F1<=0 || C1<=0) {
					System.out.println("Introduce un numero de filas y columnas valido:");
					System.out.print("Filas: ");F1=sc.nextInt();
					System.out.print("Columnas: ");C1=sc.nextInt();
				}
				if (F2<=0 || C2<=0) {
					System.out.println("Introduce un numero de filas y columnas valido:");
					System.out.print("Filas: ");F2=sc.nextInt();
					System.out.print("Columnas: ");C2=sc.nextInt();
				}
				if ((C1!=F2)) {
					System.out.println("El numero de columnas de la primera matriz y filas de la segunda no pueden ser distintas.");
					System.out.println("Introduce un numero de filas (para la segunda) y columnas (para la primera) valido:");
					System.out.print("Filas: ");F2=sc.nextInt();
					System.out.print("Columnas: ");C1=sc.nextInt();
				}
			}

			//CREAR MATRICES N,M,C DE N+M=C
			int[][] matriz=new int[F1][C1];//PRIMERA MATRIZ
			int[][] matriz2=new int[F2][C2];//SEGUNDA MATRIZ
			int[][] matrizRes=new int[F1][C2];//MATRIZ RESULTANTE

			//SET-UP DE LAS MATRICES (LECTURA DE DATOS POR POSICIONES)
			//LEER PRIMERA MATRIZ
			System.out.println("\nFormacion de la primera matriz N para la operacion N*M\n");
			leerMatriz(matriz);

			//LEER SEGUNDA MATRIZ
			System.out.println("\nFormacion de la segunda matriz M para la operacion N*M\n");
			leerMatriz(matriz2);

			//VISION DE LAS MATRICES Y COMPROBACION
			System.out.println("Aqui esta la primera matriz N:");
			mostrarMatriz(matriz);
			System.out.println("");

			System.out.println("Aqui esta la segunda matriz M:");
			mostrarMatriz(matriz2);
			System.out.println(" ");

			//MULTIPLICACION
			matrizRes=multiplicacion(matriz,matriz2);

			//VISION DEL RESULTADO FINAL
			System.out.println("Aqui esta matriz resultante del producto de las matrices N y M:");
			mostrarMatriz(matrizRes);
			System.out.println();
			
		}catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println("\033[31mMathall-System.\033[37moutput~#: Revisa tu entrada: no es valida.\n");
		}
	}
	/*------------------------------------METODOS-FUNCIONES PARA POTENCIA DE MATRICES-------------------------------*/
	public void PotenciaMatrices() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println("████████████████████████████████████  POTENCIA DE MATRICES ██████████████████████████████████");
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println();
			System.out.print("Filas o Columnas (Filas=Columnas): ");int longitude=sc.nextInt();
			System.out.print("Introduce el numero de la potencia: ");int potencia=sc.nextInt();
			System.out.println();

			int matriz [][]=new int [longitude][longitude];
			int matrizIni[][]=matriz;
			System.out.print("");
			leerMatriz(matriz);

			System.out.println("\nLa mariz inicial es:");
			mostrarMatriz(matriz);
			System.out.println("\nLa matriz en potencia de "+potencia+": ");
			for (int i=0; i<potencia-1; i++) {
				matriz=multiplicacion(matriz,matrizIni);
			}
			mostrarMatriz(matriz);
			System.out.println();
		
		}catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println("\033[31mMathall-System.\033[37moutput~#: Revisa tu entrada: no es valida.\n");
		}
	}
	/*------------------------------------METODOS-FUNCIONES PARA DETERMINANTES DE MATRICES--------------------------*/
	public void DeterminanteMatrices() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println("███████████████████████████████████ DETERMINANTE DE MATRICES ████████████████████████████████");
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println();
			int matriz[][];
			int orden;

			System.out.println("|AVISO|: Al calcular determinantes de orden mayor a 20 puede llegar a experimentar lentitud.");
			System.out.print("Introduce el orden de la matriz [máximo recomendable: " + 20 + "]: ");
			orden = sc.nextInt();

			while (orden<=0) {
				System.out.println("\nEl orden de la matriz no puede ser menor o igual que 0 ni mayor que "+20+".");
				System.out.printf("Introduce el orden de la matriz [máximo:" + 20 + "]:");
				orden = sc.nextInt();
			}

			matriz = new int[orden][orden];
			System.out.print("");
			System.out.printf("\nIntroduce los elementos de la matriz:\n\n");
			leerMatriz(matriz);

			System.out.printf("\nAqui tienes tu matriz de Orden: "+orden+"\n");
			mostrarMatriz(matriz);

			System.out.printf("\nEl determinante es: %d\n", determinante(matriz));
			System.out.println();
		
		}catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println("\033[31mMathall-System.\033[37moutput~#: Revisa tu entrada: no es valida.\n");
		}
	}
	/*------------------------------------METODOS-FUNCIONES PARA RANGO DE MATRICES----------------------------------*/
	public void RangoMatrices() throws IOException, InterruptedException{
		Gr.ClearConsole();
		try {
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println("███████████████████████████████████████ RANGO DE MATRICES ███████████████████████████████████");
			System.out.println("█████████████████████████████████████████████████████████████████████████████████████████████");
			System.out.println();

			int Dimension,Ran=1;
			System.out.print("¿Que dimension quieres para tu Matriz? (2x2 o 3x3):");Dimension= sc.nextInt();

			while (Dimension!=2 && Dimension!=3){
				System.out.println("La dimension no puede ser distinta de 2 o 3.");
				System.out.print("¿Que dimension quieres para tu Matriz? (2x2 o 3x3):");Dimension= sc.nextInt();
				System.out.println();
			}

			int[][] matriz=new int[Dimension][Dimension];
			System.out.print("\n");
			leerMatriz(matriz);

			System.out.println("Aqui esta su matriz:");
			mostrarMatriz(matriz);
			System.out.println(" ");

			//DISTINCION DE DIMENSION Y RESOLUCION

			if (Dimension==2) {//SI DIMENSION DE M=2
				if (determinante(matriz)==0) {
					Ran=2;
				}else Ran=1;
				System.out.println("El rango de tu matriz es: "+Ran);
			}

			if (Dimension==3) {//SI DIMENSION DE M=3
				if (determinante(matriz)!=0) {
					Ran=3;
					System.out.println("El rango de tu matriz es: "+Ran);
				}
				if (determinante(matriz)==0) {

					int[]Adjuntos=new int[6];
					Adjuntos[0]=(matriz[0][0]*matriz[1][1]-(matriz[0][1]*matriz[1][0]));
					Adjuntos[1]=(matriz[0][0]*matriz[1][2]-(matriz[0][2]*matriz[1][0]));
					Adjuntos[2]=(matriz[0][1]*matriz[1][2]-(matriz[1][1]*matriz[0][2]));
					Adjuntos[3]=(matriz[1][0]*matriz[2][1]-(matriz[1][1]*matriz[2][0]));
					Adjuntos[4]=(matriz[1][0]*matriz[2][2]-(matriz[1][2]*matriz[2][0]));
					Adjuntos[5]=(matriz[1][1]*matriz[2][2]-(matriz[1][2]*matriz[2][1]));

					for (int i = 0; i<Adjuntos.length; i++) {
						if (Adjuntos[i]!=0) {
							Ran=2;
						}else System.out.println("El rango de la matriz es: "+Ran);//Ran es 1 por default
					}
				}   
			}
			System.out.println();
		
		}catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println("\033[31mMathall-System.\033[37moutput~#: Revisa tu entrada: no es valida.\n");
		}
	}
	/*------------------------------------METODOS-FUNCIONES COMUNES A TODOS LOS OTROS METODOS-----------------------*/
	public void mostrarMatriz(int [][]matriz) {
		for (int k = 0; k < matriz.length; k++) {
			System.out.print("\n");
			for (int l = 0; l < matriz[k].length; l++) {
				System.out.print(matriz[k][l]+"\t");
			}
		}System.out.println();
	}
	public void leerMatriz(int [][]matriz) {
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		for (int i = 0; i < matriz.length; i++) {
			System.out.println("-----------------------------------------FILA "+(i+1)+"-----------------------------------------------\n");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print("--> Introduce el valor de la posicion ["+(i+1)+","+(j+1)+"]:");matriz[i][j]=sc.nextInt();
			}System.out.println();
		}
	}
	public int[][] multiplicacion(int [ ][ ] matriz1,int [][]matriz2) {
		int MatrizRes[][]=new int [matriz1.length][matriz2[0].length];
		for (int a = 0; a < matriz2[0].length; a++) {
			for (int i = 0; i < matriz1.length; i++) {
				int suma = 0;
				for (int j = 0; j < matriz1[0].length; j++) {
					suma += matriz1[i][j] * matriz2[j][a];
				}
				MatrizRes[i][a] = suma;
			}
		}
		return MatrizRes;
	}

	public int determinante(int matriz[][]) {
		int determinante = 0;

		if (matriz.length == 1) {return matriz[0][0];} 
		if (matriz.length == 2) {
			determinante=matriz[0][0]*matriz[1][1]-(matriz[0][1]*matriz[1][0]);
			return determinante;
		}
		else {
			for (int i = 0; i < matriz.length; i++) {
				determinante= determinante+matriz[0][i]*cofactor(matriz,0,i);
			}
		}
		return determinante;
	}

	public int cofactor(int matriz[][], int fila, int columna) {

		int submatriz[][];
		int n = matriz.length - 1;

		submatriz = new int[n][n];
		int x = 0;
		int y = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (i != fila && j != columna) {
					submatriz[x][y] = matriz[i][j];
					y++;
					if (y>=n) {
						x++;
						y=0;
					}
				}
			}
		}
		return (int)Math.pow(-1.0, fila + columna)*determinante(submatriz);
	}
}
