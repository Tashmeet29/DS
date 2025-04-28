import java.rmi.*;

public class PowServer {
	public static void main(String[] args) {
		try {
			PowImpl obj = new PowImpl();
			Naming.rebind("PowServer", obj);
			System.out.println("Power Server is ready...");
		}  catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		} 
	}
}
