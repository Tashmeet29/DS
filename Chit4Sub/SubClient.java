import java.rmi.*;
import java.util.*;

public class SubClient {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String serverURL = "rmi://localhost/SubServer";
			SubIntf subIntf = (SubIntf) Naming.lookup(serverURL);
			
			System.out.print("Enter first number: ");
		        int a = sc.nextInt();
		        System.out.print("Enter second number: ");
		        int b = sc.nextInt();
		        
		        System.out.println("--------------- Results ---------------");
		        System.out.println("Subtraction is: " + subIntf.sub(a,b));
		} catch (Exception e) {
			System.out.println("Exception Occurred At Client!" + e.getMessage());
		}
	}
}
