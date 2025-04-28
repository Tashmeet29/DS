import java.rmi.*;
import java.util.*;

public class Client {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String serverURL = "rmi://localhost/Server";
			DistIntf distIntf = (DistIntf) Naming.lookup(serverURL);
			
			System.out.print("Enter distance in miles: ");
		        double miles = sc.nextDouble();
		        
		        double kilometers = distIntf.mtok(miles);
		        
		        System.out.println("--------------- Results ---------------");
		        System.out.println(miles + " miles = " + kilometers + " kilometers");
		} catch (Exception e) {
			System.out.println("Exception Occurred At Client!" + e.getMessage());
		}
	}
}
