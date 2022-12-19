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
		String term = " ";
        
		int chars = 9; System.out.print("\n "+Graphics.yellow+"* "+Graphics.green+"NOTE : "+Graphics.white);
		
		for (int i = 0; i < arr.length; i++) {
            if (i==arr.length-1) term = "\n";
            
            if (arr[i].length()+chars+1<94) {
                System.out.print(arr[i]+term);
                chars+=arr[i].length()+1;
                continue;
            }
            System.out.print(Graphics.yellow+"\n * "+Graphics.white+arr[i]+term);
            chars=arr[i].length()+4;
        }
    }
    
    /**Method that prints a warning message in the console. Each note line must have 94
     * chars or less. 
     * @param message String that represents the message to post as a warning.*/
    public static void warning(final String message) {
        String[] arr = message.split(" ");
        String term = " ";
        
        int chars = 11; System.out.print("\n "+Graphics.red+"WARNING : "+Graphics.white);
        
        for (int i = 0; i < arr.length; i++) {
            if (i==arr.length-1) term = "\n";
            
            if (arr[i].length()+chars+1<94) {
                System.out.print(arr[i]+term);
                chars+=arr[i].length()+1;
                continue;
            }
            System.out.print("\n "+arr[i]+term);
            chars=arr[i].length()+2;
        }
    }
    
    /** Method that creates a menu based in the parameters.
     * @param options Group of parameters storaged in a String array.**/
    public static void menu(String ... options) {        
        for (int i = 0; i < options.length; i++) {
           if(i==0) System.out.println(" |"+options[i]);
           else if(i<options.length-1) System.out.println(" ├─["+Graphics.yellow+(i-1)+Graphics.white+"]- "+options[i]);
           else System.out.println(" └─["+Graphics.yellow+(i-1)+Graphics.white+"]- "+options[i]);
        }
    }
    
    public static void result(String message) {
        String[] arr = message.split(" ");
        String term = " ";
        
        int chars = 9; System.out.print("\n "+Graphics.yellow+"* RESULT : "+Graphics.white);
        
        for (int i = 0; i < arr.length; i++) {
            if (i==arr.length-1) term = "\n";
            
            if (arr[i].length()+chars+1<94) {
                System.out.print(arr[i]+term);
                chars+=arr[i].length()+1;
                continue;
            }
            System.out.print(Graphics.yellow+"\n * "+Graphics.white+arr[i]+term);
            chars=arr[i].length()+4;
        }
    }
    
    /**Creates a prompt for the Mathall user. You can change this by modifiying the different
     * parts of it. Be aware that you must let a space before the string that represents the prompt
     * because all the program outputs has it.*/
    public static void prompt() {
        System.out.print(Graphics.red+"\n user"+Graphics.white+"@"+UserData.Username+"~# ");
    }
}
