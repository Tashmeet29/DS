import java.rmi.*;
import java.util.*;

public class Client {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String serverURL = "rmi://localhost/Server";
			TempIntf tempIntf = (TempIntf) Naming.lookup(serverURL);
			
			System.out.print("Enter temperature in Celcius: ");
		        double celcius = sc.nextDouble();
		       
		        System.out.println("--------------- Results ---------------");
		        double fahrenheit = tempIntf.ctof(celcius);
		        System.out.println(celcius + "'C = " + fahrenheit + "'F");
		} catch (Exception e) {
			System.out.println("Exception Occurred At Client!" + e.getMessage());
		}
	}
}
