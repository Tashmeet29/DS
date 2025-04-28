import java.rmi.*;

public class SubServer {
	public static void main(String[] args) {
		try {
			SubImpl obj = new SubImpl();
			Naming.rebind("SubServer", obj);
			System.out.println("Subtraction Server is ready...");
		}  catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		} 
	}
}
