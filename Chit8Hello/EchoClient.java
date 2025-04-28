import java.rmi.*;
import java.util.*;

public class EchoClient {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String serverURL = "rmi://localhost/EchoServer";
			EchoIntf echoIntf = (EchoIntf) Naming.lookup(serverURL);
			
			System.out.print("Enter your name: ");
		        String name = sc.nextLine();
		        
		        String response = echoIntf.sayHello(name);
		        
		        System.out.println("--------------- Results ---------------");
		        System.out.println(response);
		} catch (Exception e) {
			System.out.println("Exception Occurred At Client!" + e.getMessage());
		}
	}
}
