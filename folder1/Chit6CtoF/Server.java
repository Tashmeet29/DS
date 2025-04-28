import java.rmi.*;

public class Server {
	public static void main(String[] args) {
		try {
			TempImpl obj = new TempImpl();
			Naming.rebind("Server", obj);
			System.out.println("Temperature Server is ready...");
		}  catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		} 
	}
}
