import java.rmi.*;
import java.util.*;

public class DivClient {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String serverURL = "rmi://localhost/DivServer";
			DivIntf divIntf = (DivIntf) Naming.lookup(serverURL);
			
			System.out.print("Enter first number: ");
		        double a = sc.nextDouble();
		        System.out.print("Enter second number: ");
		        double b = sc.nextDouble();
		        
		        System.out.println("--------------- Results ---------------");
		        System.out.println("Division Is: " + divIntf.div(a,b));
		} catch (Exception e) {
			System.out.println("Exception Occurred At Client!" + e.getMessage());
		}
	}
}
