import java.rmi.*;
import java.util.*;

public class Client {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String serverURL = "rmi://localhost/Server";
			StringIntf stringIntf = (StringIntf) Naming.lookup(serverURL);
			
			System.out.print("Enter first string: ");
		        String str1 = sc.nextLine();
		        System.out.print("Enter second string: ");
		        String str2 = sc.nextLine();
		        	  
		        System.out.println("--------------- Results ---------------");
		        System.out.println("Lexographically Largest String is: " + stringIntf.getLargestStr(str1, str2));
		} catch (Exception e) {
			System.out.println("Exception Occurred At Client!" + e.getMessage());
		}
	}
}
