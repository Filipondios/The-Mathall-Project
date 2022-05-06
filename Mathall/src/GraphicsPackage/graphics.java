package GraphicsPackage;

public class graphics {
	public void Graphics() {
		System.out.println("\033[37m|MENU PRINCIPAL DE MATHALL|                 \033[35m█   █    █  █████ █   █    █    █    █");
		System.out.println("\033[37m#0-Salir de Mathall                         \033[35m██ ██   █ █   █   █   █   █ █   █    █");
		System.out.println("\033[37m#1-Operaciones con Matrices                 \033[35m█ █ █  █   █  █   █████  █   █  █    █");
		System.out.println("\033[37m#2-Resolucion de Sistemas                   \033[35m█   █  █████  █   █   █  █████  █    █");
		System.out.println("                                            \033[35m█   █  █   █  █   █   █  █   █  ███  ███ @2.0.0");
	}

	public void ClearConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows")){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else{
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {/*No hacer nada*/}
	}
}