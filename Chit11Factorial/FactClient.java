import java.rmi.*;
import java.util.Scanner;

public class FactClient {
	public static void main(String[] args) {
	        try {
	        	Scanner sc = new Scanner(System.in);
			String serverURL = "rmi://localhost/FactServer";
			FactIntf factIntf = (FactIntf) Naming.lookup(serverURL);
			
			System.out.print("Enter a number: ");
			int number = sc.nextInt();
			System.out.println("----------------Results---------------");
			System.out.println("Factorial of " + number + " is " + factIntf.calculateFact(number));
	        } catch (Exception e) {
	        	System.out.println("Exception occured at Client!" + e.getMessage());
	        }	
	}
}
