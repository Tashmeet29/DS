import java.rmi.*;

public class AddServer {
	public static void main(String[] args) {
		try {
			AddImpl obj = new AddImpl();
			Naming.rebind("AddServer", obj);
			System.out.println("Addition Server is ready...");
		}  catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		} 
	}
}
