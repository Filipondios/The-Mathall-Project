package GraphicsPackage;

public class graphics {

	public String bold="\033[0;1m"; 
	public String red="\033[31m";
	public String white="\033[37m";
	public String purple="\033[35m";

	public void Graphics() {
		System.out.println(white+"|MATHALL MAIN MENU|                          "+purple+"█   █    █  █████ █   █    █    █    █");
		System.out.println(white+"#0- Exit Mathall                             "+purple+"██ ██   █ █   █   █   █   █ █   █    █");
		System.out.println(white+"#1- Matrix Operations                        "+purple+"█ █ █  █   █  █   █████  █   █  █    █");
		System.out.println(white+"#2- Equations Systems Resolution             "+purple+"█   █  █████  █   █   █  █████  █    █");
		System.out.println("                                             "+purple+"█   █  █   █  █   █   █  █   █  ███  ███ @2.0.0");
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
		} catch (Exception e) {/*Do nothing*/}
	}
}