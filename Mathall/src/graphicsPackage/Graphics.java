package graphicsPackage;
import userDataPackage.UserData;
/**Class that implements certain methods and variables that allow
 * certain modifications to be made to the console outputs.
 * @author Filipondios
 * @version 26.06.2022*/
public class Graphics {
	
	/**Object of type {@link String} that storages a token wich changes the output's
	 * color that comes out after in the console into bold.*/
	public String bold="\033[0;1m";
	/**Object of type {@link String} that storages a token wich changes the output's
	 * color that comes out after in the console into red.*/
	public String red="\033[31m";
	/**Object of type {@link String} that storages a token wich changes the output's
	 * color that comes out after in the console into white.*/
	public String white="\033[37m";
	/**Object of type {@link String} that storages a token wich changes the output's
	 * color that comes out after in the console into purple.*/
	public String purple="\033[35m";
	UserData data= new UserData();
	
	/**Method that prints Mathall's logo and first menu.*/
	public void GraphicsMenu() {
		System.out.println(white+" |MATHALL MAIN MENU|                          "+purple+"█   █    █  █████ █   █    █    █    █");
		System.out.println(white+" ├─[0]─ Exit Mathall                          "+purple+"██ ██   █ █   █   █   █   █ █   █    █");
		System.out.println(white+" ├─[1]─ Matrix Operations                     "+purple+"█ █ █  █   █  █   █████  █   █  █    █");
		System.out.println(white+" └─[2]─ Equations Systems Resolution          "+purple+"█   █  █████  █   █   █  █████  █    █");
		System.out.println("                                              "+purple+"█   █  █   █  █   █   █  █   █  ███  ███ @2.2.0");
	}
	
	/**I method that cleans the console, and depending on the user’s OS, it does it 
	 * one way or another. If it is the Windows console, it will completely clean the
	 * console if it leave a trace, but if the OS is Linux or another, it will simply
	 * repeatedly make a backspace.*/
	public void ClearConsole() {
		try {
			if (data.OS.equals("Windows")){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else{
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {/*Do nothing*/}
	}
	
	/**Method that is called ONLY if the user's SO is Windows, and sets the codepage to CHCP 65001.
	 * This is because there are special characters that needs te be printed in console and with the
	 * default Windows codepage its not possible to represent them.*/
	public void setCodepage() {
		try {
			if (data.OS.equals("Windows")){
				new ProcessBuilder("cmd", "/c", "CHCP 65001").inheritIO().start().waitFor();
			}
		} catch (Exception e) {/*Do nothing*/}
	}
}