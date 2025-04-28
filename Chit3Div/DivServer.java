import java.rmi.*;

public class DivServer {
	public static void main(String[] args) {
		try {
			DivImpl obj = new DivImpl();
			Naming.rebind("DivServer", obj);
			System.out.println("Division Server is ready...");
		}  catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		} 
	}
}
