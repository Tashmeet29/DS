import java.rmi.*;

public class MulServer {
	public static void main(String[] args) {
		try {
			MulImpl obj = new MulImpl();
			Naming.rebind("MulServer", obj);
			System.out.println("Multiplication Server is ready...");
		}  catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		} 
	}
}
