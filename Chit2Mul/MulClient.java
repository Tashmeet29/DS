import java.rmi.*;
import java.util.*;

public class MulClient {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String serverURL = "rmi://localhost/MulServer";
			MulIntf mulIntf = (MulIntf) Naming.lookup(serverURL);
			
			System.out.print("Enter first number: ");
		        int a = sc.nextInt();
		        System.out.print("Enter second number: ");
		        int b = sc.nextInt();
		        
		        System.out.println("--------------- Results ---------------");
		        System.out.println("Multiplication Is: " + mulIntf.mul(a,b));
		} catch (Exception e) {
			System.out.println("Exception Occurred At Client!" + e.getMessage());
		}
	}
}
