package filipondiosUtils;

import graphicsPackage.Graphics;
import userDataPackage.UserData;
/**Class that allows to create Notes, Warnings and Menus inside the application and
 * show them in the console.
 * @author Filipondios
 * @version 01.10.2022*/
public class Print {
    
    /**Method that prints a note message in the console. Each note line must have 94
     * chars or less. 
     * @param message String that represents the message to post as a note.*/
    public static void note(final String message){
        String[] arr = message.split(" ");
		
		int chars = 9; System.out.print("\n "+Graphics.yellow+"* "+Graphics.green+"NOTE :"+Graphics.white);
		for (String str : arr) {
			if (str.length()+chars+1<94) {
				System.out.print(str+" ");
				chars+=str.length()+1;
				continue;
			}
			System.out.print(Graphics.yellow+"\n * "+Graphics.white+str+" ");
			chars=str.length()+4;
		}
    }
    
    /**Method that prints a warning message in the console. Each note line must have 94
     * chars or less. 
     * @param message String that represents the message to post as a warning.*/
    public static void warning(final String message) {
        String[] arr = message.split(" ");
        
        int chars = 11; System.out.print("\n "+Graphics.red+"WARNING : "+Graphics.white);
        for (String str : arr) {
            if (str.length()+chars+1<94) {
                System.out.print(str+" ");
                chars+=str.length()+1;
                continue;
            }
            System.out.print("\n "+str+" ");
            chars=str.length()+2;
        }
    }
    
    /** Method that creates a menu based in the parameters.
     * @param options Group of parameters storaged in a String array.**/
    public static void menu(String ... options) {
        for (int i = 0; i < options.length; i++) {
           if(i==0) System.out.println(" |"+options[i]);
           else if(i<options.length-1) System.out.println(" ├─["+i+"]- "+options[i]);
           else System.out.println(" └─["+i+"]- "+options[i]);
        }
    }
    
    /**Creates a prompt for the Mathall user. You can change this by modifiying the different
     * parts of it. Be aware that you must let a space before the string that represents the prompt
     * because all the program outputs has it.*/
    public static void prompt() {
        System.out.print(Graphics.red+" user"+Graphics.white+"@"+UserData.Username+"~# ");
    }
}
