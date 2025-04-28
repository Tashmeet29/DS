import java.rmi.*;

public class FactServer {
	public static void main(String[]  args) {
		try {
			FactImpl obj = new FactImpl();
			Naming.rebind("FactServer", obj);
			System.out.println("Factorial Server is ready...");
		} catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		}
	}
}
