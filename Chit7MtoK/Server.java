import java.rmi.*;

public class Server {
	public static void main(String[] args) {
		try {
			DistImpl obj = new DistImpl();
			Naming.rebind("Server", obj);
			System.out.println("Distance Server is ready...");
		}  catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		} 
	}
}
