import java.rmi.*;
import java.util.*;

public class PowClient {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String serverURL = "rmi://localhost/PowServer";
			PowIntf powIntf = (PowIntf) Naming.lookup(serverURL);
			
			System.out.print("Enter exponent value (n for 2^n): ");
		        int exponent = sc.nextInt();
		        
		        System.out.println("--------------- Results ---------------");
		        System.out.println("2 raised to the power " +exponent + " = " + powIntf.calculatePower(exponent));
		} catch (Exception e) {
			System.out.println("Exception Occurred At Client!" + e.getMessage());
		}
	}
}
