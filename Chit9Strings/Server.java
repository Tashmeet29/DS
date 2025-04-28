import java.rmi.*;

public class Server {
	public static void main(String[] args) {
		try {
			StringImpl obj = new StringImpl();
			Naming.rebind("Server", obj);
			System.out.println("String Comparison Server is ready...");
		}  catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		} 
	}
}
