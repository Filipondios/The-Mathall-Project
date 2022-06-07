package userDataPackage;

public class UserData {
    public static String Username = System.getProperty("user.name");
    public String OS = (System.getProperty("os.name").contains("Windows")) ? "Windows" : "Other";
}
