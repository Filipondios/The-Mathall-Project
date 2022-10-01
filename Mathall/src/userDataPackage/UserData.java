package userDataPackage;
/***Class that storages some information about the user's machine. This class is mainly used 
 * in the {@link graphicsPackage.Graphics Graphics} class, because different implementations are required in the functions 
 * since it is not the same to give an instruction for a Linux system than for a Windows or MacOS system.
 * @author Filipondios
 * @version 26.06.2022*/
public class UserData {
	/**String object that storages the actual username of the user's machine.*/
    public static final String Username = System.getProperty("user.name");
    /**String object that storages the OS name of the user's machine.*/
    public static final String OS = (System.getProperty("os.name").contains("Windows")) ? "Windows" : "Linux/MacOS";
}
