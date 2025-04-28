import java.rmi.*;

public class EchoServer {
	public static void main(String[] args) {
		try {
			EchoImpl obj = new EchoImpl();
			Naming.rebind("EchoServer", obj);
			System.out.println("Echo Server is ready...");
		}  catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		} 
	}
}
